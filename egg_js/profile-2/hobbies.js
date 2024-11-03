// ✏️ Actividad: Desestructuración de objetos
const hobby = {
  enPareja: ["hobby1", "hobby2", "hobby3", "hobby4", "hobby5"],
  conAmigos: ["hobby6", "hobby7", "hobby8", "hobby9", "hobby10"],
  conFamilia: ["hobby11", "hobby12", "hobby13", "hobby14", "hobby15"],
};

const [, , tercerEnPareja] = hobby.enPareja;
const [, , , cuartoConFamilia] = hobby.conFamilia;

const mensaje = `Hobby favorito para hacer en pareja: ${tercerEnPareja} y hobby favorito para hacer en familia: ${cuartoConFamilia}`;

function mostrar() {
  const divSelector = document.getElementById("hobbies-seleccionados");
  divSelector.textContent = mensaje;
}

mostrar();

// ✏️ Actividad: Creación de un nuevo objeto con un nuevo arreglo
const { enPareja, conAmigos, conFamilia } = hobby;
const todos = [...enPareja, ...conAmigos, ...conFamilia];
console.log(todos);

// ✏️ Actividad: Definición personalizada de hobbies
const algunos = [
  todos[1],
  enPareja[2],
  enPareja[3],
  conAmigos[0],
  conFamilia[0],
];

console.log(algunos);
