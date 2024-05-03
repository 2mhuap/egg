let cart = [];

function updateCart() {
  const storageCart = JSON.parse(localStorage.getItem("cart"));
  cart = storageCart ? storageCart : [];
}

function createCartCard(prod) {
  return `
  <div class="product-info">
    <img src="${prod.image}" alt="${prod.title}">
    <div class="product-details">
      <p class="prod-name">${prod.title}</p>
      <p class="prod-color">${prod.color}</p>
      <div class="input-price-group">
        <p>S/${prod.price} x </p>
        <input id="${prod.id}" type="number" value="${prod.quantity}" onchange="changeQuantity(event)">
      </div>
    </div>
  </div>
  `;
}

function printCartCards() {
  const productsSelector = document.getElementById("cart-products");

  if (cart.length) {
    let productsTemplate = ``;

    cart.forEach(p => {
      productsTemplate += createCartCard(p);
    });

    productsSelector.innerHTML = productsTemplate;
  } else {
    productsSelector.textContent = "No hay productos en el carrito";
  }
}

function updateTotal() {
  let total = 0;
  cart.forEach(p => (total += p.price * p.quantity));

  const totalSelector = document.getElementById("total-span");
  totalSelector.textContent = total;

  const buySelector = document.getElementById("buy-button");
  const disableBuy = cart.length == 0;
  buySelector.disabled = disableBuy;
}

updateCart();
printCartCards();
updateTotal();

function changeQuantity(e) {
  console.log(e.target.id);
  const product = cart.find(p => p.id == e.target.id);
  product.quantity = Number(e.target.value);
  localStorage.setItem("cart", JSON.stringify(cart));
  updateTotal();
}
