export default function updateFavorites() {
  const favSelector = document.getElementById("favoritos");
  const faves = JSON.parse(localStorage.getItem("faves"));

  let productsTemplate = ``;

  if (faves) {
    faves.forEach(p => {
      productsTemplate = productsTemplate + createFavCard(p);
      favSelector.innerHTML = productsTemplate;
    });
  }
}
