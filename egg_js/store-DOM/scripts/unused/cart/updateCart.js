export default function updateCart() {
  const storageCart = JSON.parse(localStorage.getItem("cart"));
  cart = storageCart ? storageCart : [];
  return cart;
}
