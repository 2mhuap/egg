import ProductInterface from "./Product";

class Product implements ProductInterface {
  id: string;
  title: string;
  price: number;
  stock: number;
  images: string[];
  onsale: boolean;
  _supplier: string;
  colors: string[];
  description: string;

  constructor(
    id: string,
    title: string,
    price: number,
    stock: number,
    images: string[],
    onsale: boolean,
    supplier: string,
    colors: string[],
    description: string
  ) {
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

  set setSupplier(newName: string) {
    this._supplier = newName;
  }

  sellUnits(units: number) {
    if (this.stock >= units) {
      this.stock = this.stock - units;
    } else {
      console.error("No hay stock suficiente");
    }
  }
}

const macImg = "./assets/mock2.jpg";

const prod1: ProductInterface = new Product(
  "id001",
  "Apple Watch SE (2nd gen) - GPS - 40mm - Starlight - Aluminum - Sport Band - S/M",
  905,
  10,
  [
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_65219_mirakl_image_1_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_65219_mirakl_image_2_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_65219_mirakl_image_3_small.jpg",
  ],
  true,
  "Apple",
  ["Gold", "Black", "Silver"],
  `Water resistence: Water-Resistant
  Screen size smartwatch: 1.5"
  Band material type: Silicone
  Case material type: Aluminum`
);
const prod2: ProductInterface = new Product(
  "id002",
  "iPad 9.7 128GB - Gold - (Wi-Fi) - (Refurbished)",
  825,
  10,
  [
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_22014_mirakl_image_1.jpg",
  ],
  true,
  "Apple",
  ["Gold", "Silver"],
  `Screen Size: 9.7
  Ram: 2 GB
  Resolution: 2048 x 1536
  Storage: 128 GB`
);
const prod3: ProductInterface = new Product(
  "id003",
  '2015 Apple MacBook Air, 13.3",1.6GHz, Dual Core i5, 4GB RAM,128GB SSD(Renewed)',
  985,
  10,
  [
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_110150_mirakl_image_1_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_110150_mirakl_image_2_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_110150_mirakl_image_3_small.jpg",
  ],
  true,
  "Apple",
  ["Gray"],
  `Color Electronics: Silver
  Screen Size: 13.3
  Resolution: 2560 x 1600
  Wireless Technology: Wi-Fi`
);
const prod4: ProductInterface = new Product(
  "id004",
  "JBL Go 3: Portable Speaker with Bluetooth, Builtin Battery, Waterproof and Dustproof Feature Gray JBLGO3GRYAM",
  169,
  10,
  [
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_210089_mirakl_image_1_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_210089_mirakl_image_2_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_210089_mirakl_image_3_small.jpg",
  ],
  true,
  "JBL",
  ["Gray"],
  "JBL Go 3 features bold styling and rich JBL Pro Sound. With its new eye-catching edgy design, colorful fabrics and expressive details this a must-have accessory for your next outing."
);
const prod5: ProductInterface = new Product(
  "id005",
  "JBL TUNER XL FM Portable Speaker, Bluetooth Radio One Touch FM, Outdoor Convenient Bluetooth Audio",
  545,
  10,
  [
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_110189_mirakl_image_1_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_110189_mirakl_image_2_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_110189_mirakl_image_3_small.jpg",
  ],
  true,
  "JBL",
  ["Black"],
  "The JBL TUNER XL FM delivers surprisingly loud and powerful bass in an ultra-compact package."
);
const prod6: ProductInterface = new Product(
  "id006",
  "Apple AirPods Pro -1st Generation with MagSafe (Renewed Premium)",
  485,
  10,
  [
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_111408_mirakl_image_1_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_111408_mirakl_image_2_small.jpg",
    "https://static-catalog.tiendamia.com/marketplace_images/production/product_111408_mirakl_image_3_small.jpg",
  ],
  true,
  "Apple",
  ["White"],
  "Active noise cancellation for immersive sound + MagSafe Compatible Transparency mode for hearing and connecting with the world around you"
);

const products: ProductInterface[] = [prod1, prod2, prod3, prod4, prod5, prod6];

// console.log(JSON.stringify(products));

products.sort((p1, p2) => {
  const t1 = p1.title.toUpperCase();
  const t2 = p2.title.toUpperCase();
  return t1.localeCompare(t2);
});
