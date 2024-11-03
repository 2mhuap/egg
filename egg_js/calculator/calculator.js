class Calculadora {

  sumar() {
    const x = Number(prompt("Sumar:\nIngresa el primer número"));
    const y = Number(prompt("Sumar:\nIngresa el segundo número"));
    alert("El resultado es: " + (x + y));
  }

  restar() {
    const x = Number(prompt("Restar:\nIngresa el primer número"));
    const y = Number(prompt("Restar:\nIngresa el segundo número"));
    alert("El resultado es: " + (x - y));
  }

  multiplicar() {
    const x = Number(prompt("Multiplicar:\nIngresa el primer número"));
    const y = Number(prompt("Multiplicar:\nIngresa el segundo número"));
    alert("El resultado es: " + (x * y));
  }

  dividir() {
    const x = Number(prompt("Dividir:\nIngresa el primer número"));
    const y = Number(prompt("Dividir:\nIngresa el segundo número"));
    alert("El resultado es: " + (x / y));
  }

  raizCuadrada() {
    const x = Number(prompt("Raiz cuadrada:\nIngresa el número"));
    alert("El resultado es: " + Math.sqrt(x));
  }

  raizCubica() {
    const x = Number(prompt("Raiz cúbica:\nIngresa el número"));
    alert("El resultado es: " + Math.cbrt(x));
  }

  potencia() {
    const x = Number(prompt("Potencia:\nIngresa la base"));
    const y = Number(prompt("Potencia:\nIngresa el exponente"));
    alert("El resultado es: " + Math.pow(x, y));
  }

}

const op = prompt(`Elige la operación (con número):
  1. sumar
  2. restar
  3. multiplicar
  4. dividir
  5. raiz cuadrada
  6. raiz cubica
  7. potencia
`);

const calc = new Calculadora();

switch (Number(op)) {
  case 1:
    calc.sumar();
    break;
  case 2:
    calc.restar();
    break;
  case 3:
    calc.multiplicar();
    break;
  case 4:
    calc.dividir();
    break;
  case 5:
    calc.raizCuadrada();
    break;
  case 6:
    calc.raizCubica();
    break;
  case 7:
    calc.potencia();
    break;
  default:
    alert("Operación inválida");
    break;
}