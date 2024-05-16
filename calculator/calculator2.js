const num1 = Number(prompt("Primer numero"));
const num2 = Number(prompt("Segundo numero"));

function dividir(x, y, callback) {
  if (isNaN(x) || isNaN(y)) {
    callback("Error - parámetros no son numéricos");
  } else if (y == 0) {
    callback("No se puede dividir por cero");
  } else {
    const mainSelector = document.querySelector("main");
    mainSelector.textContent = x / y;
  }
}

function manejarError(mensaje) {
  alert(mensaje);
}

dividir(num1, num2, manejarError);
