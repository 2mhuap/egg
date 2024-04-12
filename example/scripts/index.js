/* seleccionar una etiqueta del HTML */
const selector = document.getElementById("mensaje");

/* escribir dentro de esa etiqueta con JS */
selector.innerHTML = "CONEXIÓN EXITOSA ENTRE HTML Y JS";

// const entrada = prompt("¿Qué producto desea comprar?");
// console.log(entrada);
// alert(entrada);

const nombre = prompt("Podrias indicarme tu nombre por favor?");
// console.log(nombre);
const mensaje = "Bienvenido " + nombre;
alert(mensaje);
