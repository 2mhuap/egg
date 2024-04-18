const cantidad = Number(prompt("¿Cuántos tipos de productos desea llevar?"));

const comprar = () => {
  let totalApagar = 0;

  for (let index = 1; index <= cantidad; index++) {
    const nombre = prompt("¿Qué producto desea llevar?");
    const unidades = Number(prompt("¿Cuántas unidades?"));
    const precio = Number(prompt("¿Cuánto sale cada unidad?"));
    const subtotal = unidades * precio;
    totalApagar = totalApagar + subtotal;
  }

  console.log(totalApagar);
  return totalApagar;
};

// const total1 = comprar();
// const total2 = comprar();
// const total3 = comprar();
// const total = total1 + total2 + total3;

const total = comprar() + comprar() + comprar();
console.log("El total es: ", total);
