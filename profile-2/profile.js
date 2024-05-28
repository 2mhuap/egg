"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var nombre = "Matias";
var edad = 26;
var correo = "xyz@gmail.com";
var altura = "0cm";
var peso = "0kg";
var data1 = {
    nombre: nombre,
    edad: edad,
    correo: correo,
    altura: altura,
    peso: peso,
};
var data2 = {
    nombre: "Matias2",
    edad: 26,
    correo: "xyz2@gmail.com",
    altura: "0cm",
    peso: "0kg"
};
var family = [data1, data2];
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
function isString(x) {
    return typeof x === "string";
}
// console.log("nombre isString", isString(nombre));
// console.log("edad isString", isString(edad));
// Primeros pasos con Generics -------------------------
// Actividad: Implementando el uso de “Generics” I
function genericFirst(array) {
    return array[0];
}
console.log(genericFirst(family));
