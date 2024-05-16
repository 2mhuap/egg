export default function printCartCards(cart) {
  const productsSelector = document.getElementById("cart-products");

  if (cart.length) {
    let productsTemplate = ``;

    cart.forEach(p => {
      productsTemplate += createCartCard(p);
    });

    productsSelector.innerHTML = productsTemplate;
  } else {
    productsSelector.textContent = "No hay productos en el carrito";
  }
}
