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
  constructor(id, title, price, stock, images, onsale, supplier) {
    this.id = id;
    this.title = title;
    this.price = price;
    this.stock = stock;
    this.images = images;
    this.onsale = onsale;
    this._supplier = supplier;
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

const prod1 = new Product();
const prod2 = new Product("id123", "Jugo", "2");
const prod3 = new Product("id124", "Manzana", "2", "10", [], false);

console.log(prod1);
console.log(prod2);
console.log(prod3);

console.log(prod2.title);
console.log(prod3.onsale);

const prod4 = new Product("id125", "Manzana", "2", "10", [], false, "Wong");
prod4.setSupplier = "Totus";
console.log(prod4.getSupplier);

const prod5 = new Product("id126", "Manzana", "2", "12", [], false, "supplier");
prod5.sellUnits(10);
prod5.sellUnits(5);
console.log(prod5);
