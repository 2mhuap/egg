// favorite
// createFavCard
// updateFavorites

function favorite(e) {
  const prodId = e.target.id.substring(4);
  const product = cart.find(p => p.id == prodId);

  const faves = JSON.parse(localStorage.getItem("faves"));

  const { quantity, ...rest } = product;
  const prodNoQuantity = { ...rest };
  // console.log(prodNoQuantity);

  if (faves) {
    const prodExists = faves.find(
      p => p.id == prodId && p.color == product.color
    );
    if (prodExists == null) {
      // no existe
      faves.push(prodNoQuantity);
      localStorage.setItem("faves", JSON.stringify(faves));
      // e.target.class += " disabled";
      e.target.classList.add("disabled");
      console.log(e.target.classList);
    }
  } else {
    localStorage.setItem("faves", JSON.stringify([prodNoQuantity]));
  }
  updateFavorites();
}

function createFavCard(product) {
  return `
    <a class="product-card" href="./details.html?id=${product.id}">
      <img class="product-img" src="${product.image}" alt="${product.title}" />
      <div class="product-info">
        <span class="product-title">${product.title}</span>
        <div class="product-price-block">
          <span class="price">S/${product.price}</span>
        </div>
      </div>
    </a>
    `;
}

function updateFavorites() {
  const favSelector = document.getElementById("favoritos");
  const faves = JSON.parse(localStorage.getItem("faves"));

  let productsTemplate = ``;

  if (faves) {
    faves.forEach(p => {
      productsTemplate = productsTemplate + createFavCard(p);
      favSelector.innerHTML = productsTemplate;
    });
  }
}

updateFavorites();
