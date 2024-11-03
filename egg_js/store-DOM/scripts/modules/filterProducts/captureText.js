import printProductCards from "../productCards/printProductCards.js";
export default function captureText(e, products) {
    // console.log(e.target.value);
    const searched = products.filter(p => p.title.toLowerCase().includes(e.target.value.toLowerCase()));
    printProductCards(searched, "products");
}
