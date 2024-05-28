import Usuario from "./Data";

const nombre: string = "Matias";
const edad: number = 26;
const correo: string = "xyz@gmail.com";
const altura: string = "0cm";
const peso: string = "0kg";

const data1: Usuario = {
  nombre,
  edad,
  correo,
  altura,
  peso,
};

const data2: Usuario = {
  nombre: "Matias2",
  edad: 26,
  correo: "xyz2@gmail.com",
  altura: "0cm",
  peso: "0kg"
}

const family: Usuario[] = [data1, data2];
// console.log(family);

// Primeros pasos con Operadores Avanzados -----------
// Actividad: Implementando el operador “Typeof”
// console.log("nombre: ", typeof nombre);
// console.log("data1: ", typeof data1);
// console.log("family: ", typeof family);

// Actividad: Implementando el operador “In”
// console.log("nombre in: ", "nombre" in data1);
// console.log("direccion in: ", "direccion" in data1);

// Actividad: Implementando el operador “Is”
function isString(x: any): x is string {
  return typeof x === "string";
}
// console.log("nombre isString", isString(nombre));
// console.log("edad isString", isString(edad));

// Primeros pasos con Generics -------------------------
// Actividad: Implementando el uso de “Generics” I
function genericFirst<T>(array: T[]): T {
  return array[0];
}

// console.log(genericFirst<Usuario>(family));
// Actividad: Implementando el uso de “Generics” II