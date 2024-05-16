export default function updateTotal(cart) {
  let total = 0;
  cart.forEach(p => (total += p.price * p.quantity));

  const totalSelector = document.getElementById("total-span");
  totalSelector.textContent = total;

  const buySelector = document.getElementById("buy-button");
  const disableBuy = cart.length == 0;
  buySelector.disabled = disableBuy;
}
