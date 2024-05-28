const buySelector = document.getElementById("buy-button");

buySelector.addEventListener("click", () => {
  const totalSelector = document.getElementById("total-span");
  // const mensaje = "Has hecho una compra de S/" + totalSelector.textContent;
  // alert(mensaje);
  Swal.fire({
    title: "¿Estás seguro?",
    text: "Vas a hacer una compra de S/" + totalSelector.textContent,
    showCancelButton: true,
    confirmButtonText: "Finalizar compra",
  }).then(result => {
    if (result.isConfirmed) {
      localStorage.removeItem("cart");
      updateCart();
      printCartCards();
      updateTotal();
    }
  });
});
