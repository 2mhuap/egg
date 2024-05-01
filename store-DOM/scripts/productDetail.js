const query = location.search;
const params = new URLSearchParams(query);
const idParam = params.get("id");
// console.log(id);

function printDetails(id) {
  const product = products.find(each => each.id === id);
  document.title = product.title;

  const productImagesBlock = `
  ${product.images
    .map(
      img => `<div class="thumbnail-container">
    <img class="miniImg" src="${img}" alt="mini" onclick="changeMini(event)"/>
    </div>`
    )
    .join("")}
  <img class="main-image" src="${product.images[0]}" alt="mock 1 main">
  `;
  const imagesSelector = document.querySelector(".product-images-block");
  imagesSelector.innerHTML = productImagesBlock;

  const productDescriptionBlock = `
  <h1 class="title">${product.title}</h1>
  <form class="selector">
    <fieldset>
      <label class="label" for="color">Color</label>
      <select id="color-select" type="text" placeholder="Selecciona un color">
      ${product.colors
        .map(c => `<option value=${c.toLowerCase()}>${c}</option>`)
        .join("")}
      </select>
    </fieldset>
  </form>
  <div class="description">
    <p><strong>Descripción</strong></p>
    <p>${product.description}</p>
  </div>
  `;
  const descriptionSelector = document.querySelector(
    ".product-description-block"
  );
  descriptionSelector.innerHTML = productDescriptionBlock;

  const priceSelector = document.querySelector(".checkout-total-price");
  priceSelector.textContent = "S/" + product.price;

  const cantidadInput = document.getElementById("cantidad");
  cantidadInput.addEventListener("change", event =>
    changeSubtotal(event, product)
  );

  const cartButton = document.getElementById("add-to-cart");
  cartButton.addEventListener("click", () => saveProduct(product));
  const subtotalSelector = document.getElementById("subtotal");
  subtotalSelector.textContent = product.price;
}

printDetails(idParam);

function changeMini(e) {
  const clickedSrc = e.target.src;
  const bigSelector = document.querySelector(".main-image");
  bigSelector.src = clickedSrc;
}

function changeSubtotal(e, prod) {
  const cantidad = e.target.value;
  const precio = prod.price;
  const subtotal = precio * cantidad;
  const subtotalSelector = document.getElementById("subtotal");
  subtotalSelector.textContent = subtotal;
}

function saveProduct(prod) {
  const currColor = document.querySelector("#color-select").value;
  const currQuantity = Number(document.querySelector("#cantidad").value);

  const prodCart = {
    id: prod.id,
    title: prod.title,
    price: prod.price,
    image: prod.images[0],
    color: currColor,
    quantity: currQuantity,
  };
  const cart = JSON.parse(localStorage.getItem("cart"));

  if (cart) {
    const prodExists = cart.find(p => p.id == prod.id);
    if (prodExists && prodExists.color == currColor) {
      prodExists.quantity += currQuantity;
    } else {
      cart.push(prodCart);
    }

    const stringifyProduct = JSON.stringify(cart);
    localStorage.setItem("cart", stringifyProduct);
  } else {
    const stringifyProduct = JSON.stringify([prodCart]);
    localStorage.setItem("cart", stringifyProduct);
  }
}
