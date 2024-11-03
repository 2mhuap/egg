// ✏️ Actividad: Property Shorthand
const nombre = "Matias";
const edad = "26";
const correo = "xyz@gmail.com";
const altura = "0cm";
const peso = "0kg";

const perfil = {
  nombre,
  edad,
  correo,
  altura,
  peso,
};

const nombreSelector = document.getElementById("nombre");
nombreSelector.textContent += nombre;
const edadSelector = document.getElementById("edad");
edadSelector.textContent += edad;
const correoSelector = document.getElementById("correo");
correoSelector.textContent += correo;
const alturaSelector = document.getElementById("altura");
alturaSelector.textContent += altura;
const pesoSelector = document.getElementById("peso");
pesoSelector.textContent += peso;
