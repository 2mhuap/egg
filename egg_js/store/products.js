// const producto1 = {
//   nombre: "celular",
//   precio: 100000,
//   stock: 2,
// };

// producto1.id = "id123";
// producto1["foto"] = "https://i.postimg.cc/Jn2C5W84/galaxy1.webp";

// console.log(producto1);
// console.log(producto1.nombre);

class Product {
  constructor(id, title, price, stock, images, onsale, supplier, colors, description) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.stock = stock;
    this.images = images;
    this.onsale = onsale;
    this._supplier = supplier;
    this.colors = colors;
    this.description = description;
  }

  get getSupplier() {
    return this._supplier;
  }

  set setSupplier(newName) {
    this._supplier = newName;
  }

  sellUnits(units) {
    if (this.stock >= units) {
      this.stock = this.stock - units;
    } else {
      console.error("No hay stock suficiente");
    }
  }
}

// Abril 17 - Programación Orientada a Objetos I

// const prod1 = new Product();
// const prod2 = new Product("id123", "Jugo", "2");
// const prod3 = new Product("id124", "Manzana", "2", "10", [], false);

// console.log(prod1);
// console.log(prod2);
// console.log(prod3);

// console.log(prod2.title);
// console.log(prod3.onsale);

// const prod4 = new Product("id125", "Manzana", "2", "10", [], false, "Wong");
// prod4.setSupplier = "Totus";
// console.log(prod4.getSupplier);

// const prod5 = new Product("id126", "Manzana", "2", "12", [], false, "supplier");
// prod5.sellUnits(10);
// prod5.sellUnits(5);
// console.log(prod5);

// Abril 18 - Arrays/Arreglos --------------

// Actividad: Listado de productos en la tienda
const prod1 = new Product("id001", "Manzana", "1", "10", [], false, "Supplier1", [], "Desc Manzana");
const prod2 = new Product("id002", "Platano", "2", "10", [], false, "Supplier2", [], "Desc Platano");
const prod3 = new Product("id003", "Naranja", "3", "10", [], false, "Supplier3", [], "Desc Naranja");
const prod4 = new Product("id004", "Limon", "4", "10", [], false, "Supplier4", [], "Desc Limon");

const products = [prod1, prod2, prod3, prod4];

// console.log(products);
// console.log(products[1]);
// console.log(products[products.length - 1].title);

// Actividad: Ampliando la lista de productos
const prod5 = new Product("id005", "Melon", "5", "10", [], false, "Supplier5", [], "Desc Melon");
const prod6 = new Product("id006", "Sandía", "6", "10", [], false, "Supplier6", [], "Desc Platano");

products.unshift(prod5);
products.push(prod6);

// console.log(products[0].title);
// console.log(products[products.length - 1].title);

// Actividad: Eliminación de productos de una lista 
products.shift();
products.pop();
console.log(products);

// Actividad: Enriquecimiento de información de productos
console.log(products);