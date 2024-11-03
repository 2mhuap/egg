export default function favorite(e, cart) {
  const prodId = e.target.id.substring(4);
  const product = cart.find(p => p.id == prodId);

  const faves = JSON.parse(localStorage.getItem("faves"));

  const { quantity, ...rest } = product;
  const prodNoQuantity = { ...rest };
  // console.log(prodNoQuantity);

  if (faves) {
    const prodExists = faves.find(
      p => p.id == prodId && p.color == product.color
    );
    if (prodExists == null) {
      // no existe
      faves.push(prodNoQuantity);
      localStorage.setItem("faves", JSON.stringify(faves));
      // e.target.class += " disabled";
      e.target.classList.add("disabled");
      console.log(e.target.classList);
    }
  } else {
    localStorage.setItem("faves", JSON.stringify([prodNoQuantity]));
  }
  updateFavorites();
}
