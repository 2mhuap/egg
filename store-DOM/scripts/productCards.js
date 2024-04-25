const img = "./assets/mock1.jpg";

function printCards(arrayOfProducts, idSelector) {
  const productsSelector = document.getElementById(idSelector);
  let productsTemplate = ``;

  function createCard(product) {
    return `
      <a class="product-card" href="./details.html?id=${product.id}">
        <img class="product-img" src="${
          product.images.length == 0 ? img : product.images[0]
        }" alt="${product.title}" />
        <div class="product-info">
          <span class="product-title">${product.title}</span>
          <span class="product-description">${product.getSupplier}</span>
          <div class="product-price-block">
            <span class="price">S/${product.price}</span>
            <span class="discount">${product.onsale ? "50% off" : ""}</span>
          </div>
          <div class="product-tax-policy">Incluye impuesto País y percepción AFIP</div>
        </div>
      </a>
      `;
  }

  for (const el of arrayOfProducts) {
    productsTemplate = productsTemplate + createCard(el);
  }
  productsSelector.innerHTML = productsTemplate;
  console.log("printCards");
}

printCards(products, "products");
