// alert("Hola este es mi Javascript");
// let nombre = "Matias";
// console.log(nombre);

// CONDICIONALES -------------
// let contenidoTitulo = "Nombre";

// let titulo = document.querySelector("#nombre");
// titulo.innerHTML = contenidoTitulo;

// let textoTitulo = titulo.innerText;
// console.log(textoTitulo);

// // if (textoTitulo == "Nombre") {
// //   titulo.innerHTML = "Otro";
// // } else {
// //   console.log("no se cumple");
// // }

// let acercaDe = document.querySelector(".acerca-de h2");
// if (textoTitulo == "Nombre") {
//   acercaDe.innerHTML = "~";
// } else {
//   console.log("acerca de - no se cumple");
// }

// FUNCIONES -----------

// let n = "Mat";
// let c = "Lima";

// function cambiarTexto(nombre, ciudad) {
//   let contenido = `Me llamo ${nombre}. ${ciudad}. Lorem ipsum dolor sit
//   amet, consectetur adipiscing elit, sed do eiusmod tempor
//   incididunt ut labore et dolore magna aliqua. Ut enim ad
//   minim veniam, quis nostrud exercitation ullamco laboris
//   nisi ut aliquip ex ea commodo consequat.`

//   return contenido;
// }

// let parrafo = document.querySelector("#acerca-de-texto");

// parrafo.innerText = cambiarTexto(n, c);

// MENU ---------

let menu_responsive = document.querySelector(".checkbtn");
menu_responsive.onclick = function () {
  navBar = document.querySelector("nav");
  navBar.classList.toggle("active");
};

// FORMULARIO ------------
const form = document.getElementById("form");
const nombre = document.getElementById("nombre");
const parrafo = document.getElementById("alertas");

function validarFormulario() {
  let warnings = "";
  let valido = true;
  parrafo.innerHTML = "";

  if (nombre.value.length < 4) {
    warnings += `El nombre debe contener más de 4 carcateres`;
    valido = false;
  }

  if (!valido) {
    parrafo.innerHTML = warnings;
  } else {
    parrafo.innerHTML = "Enviado";
  }
  return valido;
}

form.addEventListener("submit", (e) => {
  if (validarFormulario()) {
    // Si la validación es exitosa, puedes enviar el formulario
    formulario.submit();
  } else {
    e.preventDefault(); // Evita que el formulario se envíe automáticamente
  }
});