import Footer from "../components/Footer";
import NavBar from "../components/NavBar";

import styles from "./OnSale.module.css";
// import { Link } from "react-router-dom";
import products from "../assets/products.js";
// import ProductCard from "../components/ProductCard";
import Product from "../interfaces/Product.js";
import OnSaleCard from "../components/OnSaleCard";

const productsOnSale: Product[] = products.filter(p => p.onsale);
// .filter(p => p.onsale)

export default function OnSale() {
  return (
    <>
      <NavBar />

      <main className={styles.onSaleMain}>
        <div className={styles.container}>
          <div className={styles.productContainer}>
            {productsOnSale.map((p: Product) => (
              <OnSaleCard key={p.id} product={p} />
            ))}
          </div>
        </div>
      </main>

      <Footer />
    </>
  );
}
