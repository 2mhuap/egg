export default function saveProduct(prod) {
  const currColor = document.querySelector("#color-select").value;
  const currQuantity = Number(document.querySelector("#cantidad").value);

  const prodCart = {
    id: prod.id,
    title: prod.title,
    price: prod.price,
    image: prod.images[0],
    color: currColor,
    quantity: currQuantity,
  };
  const cart = JSON.parse(localStorage.getItem("cart"));

  if (cart) {
    const prodExists = cart.find(p => p.id == prod.id);
    if (prodExists && prodExists.color == currColor) {
      prodExists.quantity += currQuantity;
    } else {
      cart.push(prodCart);
    }

    const stringifyProduct = JSON.stringify(cart);
    localStorage.setItem("cart", stringifyProduct);
  } else {
    const stringifyProduct = JSON.stringify([prodCart]);
    localStorage.setItem("cart", stringifyProduct);
  }
}
