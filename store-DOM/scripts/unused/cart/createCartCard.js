export default function createCartCard(prod) {
  return `
  <div class="product-info">
    <img src="${prod.image}" alt="${prod.title}">
    <div class="product-details">
      <p class="prod-name">${prod.title}</p>
      <p class="prod-color">${prod.color}</p>
      <div class="input-price-group">
        <p>S/${prod.price} x </p>
        <input id="input-${prod.id}" type="number" value="${prod.quantity}" onchange="changeQuantity(event)">
      </div>
      <div class="fav-row">
        <i class="fa-solid fa-heart" id="fav-${prod.id}" onclick="favorite(event)"></i>
      </div>
    </div>
  </div>
  `;
}
