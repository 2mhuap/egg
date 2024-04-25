function captureText(e) {
  // console.log(e.target.value);
  const searched = products.filter(p =>
    p.title.toLowerCase().includes(e.target.value.toLowerCase())
  );
  printCards(searched, "products");
}

const searchSelector = document.querySelector(".search .form input");
searchSelector.addEventListener("keyup", event => captureText(event));
