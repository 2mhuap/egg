function lengthOf(texto) {
  if (texto == "") {
    return "Invalid input";
  } else {
    return texto.length;
  }
}

const len1 = lengthOf("hola");
const len2 = lengthOf("no");
const len3 = lengthOf("");

console.log(len1);
console.log(len2);
console.log(len3);
