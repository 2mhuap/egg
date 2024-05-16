// ✏️ Actividad: Definiendo una plantilla
const nombre = "Matias";
const edad = "26";
const profesion = "Desarrollador";
const ubicacion = "Lima";
const hobby = "Gaming";

const template = `Nombre: ${nombre}, edad: ${edad}, profesión: ${profesion}, ubicación: ${ubicacion}, hobby: ${hobby}`;

const act1Selector = document.getElementById("actividad-1");
act1Selector.textContent = template;

// Actividad: Implementando la Asignación con AND lógico (&&)
let isOnline = false;
// const entrada = prompt("Estas conectado? Escribe SI o NO");
const entrada = "";
const respuesta = entrada.toUpperCase();

if (respuesta == "SI" && !isOnline) {
  isOnline = true;
}

if (isOnline) {
  const act2Selector = document.getElementById("actividad-2");
  act2Selector.textContent = "El usuario está conectado! " + template;
}

// ✏️ Actividad: Implementando el Encadenamiento opcional
const misDatosFisicos = {
  nombre,
  edad,
  direccion: {
    calle: "Jiron X",
    numero: 123,
    ciudad: "Lima",
  },
  altura: "altura",
  peso: "peso",
  hobby,
};

const act3Selector = document.getElementById("actividad-3");
const contenidoPerfil = `
<h4>${misDatosFisicos?.nombre}</h4>
<div>Edad: ${misDatosFisicos?.edad}</div>
<div>Dirección: ${misDatosFisicos?.direccion?.calle}, ${
  misDatosFisicos?.direccion?.numero
}, ${misDatosFisicos?.direccion?.ciudad}</div>
<div>Altura: ${misDatosFisicos?.altura ?? "No hay"}</div>
<div>Peso: ${misDatosFisicos?.peso ?? "No hay"}</div>
<div>Hobby: ${misDatosFisicos?.hobby ?? "No hay"}</div>
`;

act3Selector.innerHTML = contenidoPerfil;

// ✏️ Actividad: Definiendo una función con parámetros predeterminados.
function templateFunction(id = "act-4-3") {
  const act4Selector = document.getElementById(id);
  act4Selector.textContent = template;
  return id;
}

templateFunction();
templateFunction("act-4-1");
