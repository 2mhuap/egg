// const num1 = Number(prompt("Primer numero"));
// const num2 = Number(prompt("Segundo numero"));

// const suma = num1 + num2;
// const mensajeSuma = "El resultado de la suma es " + suma;

// // alert(mensajeSuma);

// const promedio = suma / 2;
// const triple = promedio * 3;
// const resultadoMenosDiez = triple - 10;

// const mensajeFinal = "El resultado final es " + resultadoMenosDiez;
// alert(mensajeFinal);

const cantidad = Number(prompt("¿Cuántos números desea sumar?"));
let sumatoria = 0;
for (let index = 1; index <= cantidad; index++) {
  const numeroAsumar = Number(prompt("Ingrese un número a sumar"));
  sumatoria = sumatoria + numeroAsumar;
}

console.log(sumatoria);
