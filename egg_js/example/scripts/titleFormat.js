function titleFormat(texto) {
  const primeraLetra = texto.charAt(0);
  const resto = texto.slice(1);

  const resultado = primeraLetra.toUpperCase() + resto.toLowerCase();

  // return resultado.length;
  return resultado;
}

// const title1 = titleFormat("hola");
// const title2 = titleFormat("no");
// const title3 = titleFormat("???");

console.log(titleFormat("hello world"));
console.log(titleFormat("HELLO world"));
console.log(titleFormat("HellO WOrLd"));
