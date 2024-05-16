export default function createFavCard(product) {
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
