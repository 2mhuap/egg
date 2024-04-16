const cantidad = Number(prompt("¿Cuántos tipos de productos desea llevar?"));
let totalApagar = 0;
// const totalApagar = 0;

for (let index = 1; index <= cantidad; index++) {
  const nombre = prompt("¿Qué producto desea llevar?");
  const unidades = Number(prompt("¿Cuántas unidades?"));
  const precio = Number(prompt("¿Cuánto sale cada unidad?"));
  const subtotal = unidades * precio;
  totalApagar = totalApagar + subtotal;
}

console.log(totalApagar);
