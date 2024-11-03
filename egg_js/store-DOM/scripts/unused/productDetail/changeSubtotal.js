export default function changeSubtotal(e, prod) {
  const cantidad = e.target.value;
  const precio = prod.price;
  const subtotal = precio * cantidad;
  const subtotalSelector = document.getElementById("subtotal");
  subtotalSelector.textContent = subtotal;
}
