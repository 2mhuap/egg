const buySelector = document.getElementById("buy-button");

buySelector.addEventListener("click", () => {
  const totalSelector = document.getElementById("total-span");
  const mensaje = "Has hecho una compra de S/" + totalSelector.textContent;
  alert(mensaje);

  localStorage.removeItem("cart");
  updateCart();
  printCartCards();
  updateTotal();
});
