export default interface ProductInterface {
  id: string;
  title: string;
  price: number;
  stock: number;
  images: string[];
  onsale: boolean;
  _supplier: string;
  colors: string[];
  description: string;

  getSupplier: string;
  setSupplier: string;
  sellUnits(units: number): void;
}
