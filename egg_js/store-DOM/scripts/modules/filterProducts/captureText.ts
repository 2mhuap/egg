import ProductInterface from "../../ts/Product";
import printProductCards from "../productCards/printProductCards.js";

export default function captureText(e: Event, products: ProductInterface[]): void {
  // console.log(e.target.value);
  const searched = products.filter(p =>
    p.title.toLowerCase().includes((e.target as HTMLInputElement).value.toLowerCase())
  );
  printProductCards(searched, "products");
}
