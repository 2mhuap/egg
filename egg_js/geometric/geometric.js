import area from "./area.js";
import perimetro from "./perimeter.js";
import rects from "./rectangleData.js";

const resultado = rects.map(r => {
  return { perimetro: perimetro(r), area: area(r) };
});

console.log(resultado);
