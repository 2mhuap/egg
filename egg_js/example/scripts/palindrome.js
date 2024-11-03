function palindrome(texto) {
  const spl = texto.split("");
  const rev = spl.reverse();
  const resultado = rev.join("");
  return texto == resultado;
}
console.log(palindrome("hello"));
console.log(palindrome("hannah"));
