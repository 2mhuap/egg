export default function changeQuantity(e, cart) {
  // console.log(e.target.id);
  const prodId = e.target.id.substring(6);
  const product = cart.find(p => p.id == prodId);
  product.quantity = Number(e.target.value);
  localStorage.setItem("cart", JSON.stringify(cart));
  updateTotal();
}
