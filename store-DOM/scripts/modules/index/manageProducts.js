import printProductCards from "../productCards/printProductCards.js";
import filterProducts from "../index/filterProducts.js";

export default async function manageProducts() {
  fetch("./products.json")
    .then(response => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then(data => {
      data.sort((p1, p2) => {
        const t1 = p1.title.toUpperCase();
        const t2 = p2.title.toUpperCase();
        return t1.localeCompare(t2);
      });
      printProductCards(data, "products");
      filterProducts(data);
    })
    .catch(error => console.error("ERROR: ", error));
}
