export default function renderLayout(options, optionsFooter) {
  // Actividad: Renderizando la barra de navegación del store

  // const navSelector = document.getElementById("nav");
  const navSelector = document.querySelectorAll("#nav li");

  // const options = [
  //   { title: "Ofertas de la semana js", linkTo: "./outlet.html" },
  //   { title: "Productos js", linkTo: "./products.html" },
  //   { title: "Contacto js", linkTo: "./contact.html" },
  //   { title: "Marcas js", linkTo: "./brands.html" },
  // ];

  for (let i = 0; i < 4; i++) {
    const option = options[i];
    const navEl = navSelector[i];
    // const anchor = document.createElement("a");
    // anchor.className = "nav-button";
    const anchor = navEl.querySelector("a");
    // anchor.textContent = option.title;
    anchor.href = option.linkTo;
    navEl.appendChild(anchor);
  }

  // Actividad: Renderizando el pie de página del store

  // const footerSelector = document.querySelector("#footer");
  const footerSelector = document.querySelectorAll("#footer ul");

  // const optionsFooter = [
  //   {
  //     title: "Ofertas de la semana",
  //     linkTo: "./outlet.html",
  //     opts: ["Laptops", "Audio", "Auticulares"],
  //   },
  //   {
  //     title: "Cómo comprar",
  //     linkTo: "./how.html",
  //     opts: ["Formas de pago", "Envios", "Devoluciones"],
  //   },
  //   {
  //     title: "Costos y tarifas",
  //     linkTo: "./taxes.html",
  //     opts: ["Impuestos", "Facturación"],
  //   },
  //   {
  //     title: "Mis pedidos",
  //     linkTo: "./orders.html",
  //     opts: ["Pedir nuevamente", "Lista de deseos"],
  //   },
  //   {
  //     title: "Garantía de Entrega",
  //     linkTo: "./warranty.html",
  //     opts: [],
  //   },
  // ];

  for (let i = 0; i < 5; i++) {
    const option = optionsFooter[i];
    const navUl = footerSelector[i];
    const title = navUl.querySelector(".col-main-item");
    const anchorTitle = document.createElement("a");
    anchorTitle.textContent = option.title;
    anchorTitle.href = option.linkTo;
    title.appendChild(anchorTitle);

    const liSelector = navUl.querySelectorAll("li");
    let j = 1;
    for (const op of option.opts) {
      const newAnchor = document.createElement("a");
      const li = liSelector[j];
      newAnchor.textContent = op;
      newAnchor.href = "#";
      li.appendChild(newAnchor);
      j++;
    }
  }
}
