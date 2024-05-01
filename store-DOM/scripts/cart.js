const cart = JSON.parse(localStorage.getItem("cart"));

function createCartCard(prod) {
  return `
  <div class="product-info">
    <img src="${prod.image}" alt="${prod.title}">
    <div class="product-details">
      <p class="prod-name">${prod.title}</p>
      <p class="prod-color">${prod.color}</p>
      <div class="input-price-group">
        <input type="number" value="${prod.quantity}" readonly>
        <p>S/${prod.price}</p>
      </div>
    </div>
  </div>
  `;
}

function printCartCards() {
  const productsSelector = document.getElementById("cart-products");
  let productsTemplate = ``;

  cart.forEach(p => (productsTemplate += createCartCard(p)));

  productsSelector.innerHTML = productsTemplate;
}

function updateTotal() {
  let total = 0;
  cart.forEach(p => (total += p.price * p.quantity));

  const totalSelector = document.getElementById("total-span");
  totalSelector.textContent = total;
}

printCartCards();
updateTotal();
