const frase = prompt("Ingrese una palabra o frase");
const cantidad = frase.length;
// const mensajeCantidad = "La longitud de la palabra o frase es " + cantidad;
// console.log(mensajeCantidad);
const fraseMinusculas = frase.toLowerCase();
const fraseMayusculas = frase.toUpperCase();

const minMay =
  "La frase en minusculas es: " +
  fraseMinusculas +
  "\nLa frase en mayusculas es: " +
  fraseMayusculas;

alert(minMay);
