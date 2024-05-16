// import products from "./products.js";
import captureText from "../filterProducts/captureText.js";

// captureText

export default function filterProducts(products) {
  const searchSelector = document.querySelector(".search .form input");
  searchSelector.addEventListener("keyup", event =>
    captureText(event, products)
  );
}
