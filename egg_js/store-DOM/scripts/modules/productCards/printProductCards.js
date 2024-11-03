import createProductCard from "./createProductCard.js";

export default function printProductCards(arrayOfProducts, idSelector) {
  const productsSelector = document.getElementById(idSelector);
  let productsTemplate = ``;

  for (const el of arrayOfProducts) {
    productsTemplate = productsTemplate + createProductCard(el);
  }
  productsSelector.innerHTML = productsTemplate;
  console.log("printProductCards");
}
