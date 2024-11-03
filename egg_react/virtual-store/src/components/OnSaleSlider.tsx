import styles from "../views/OnSale.module.css";
import OnSaleCard from "../components/OnSaleCard";
import { useState } from "react";
import {
  faChevronLeft,
  faChevronRight,
} from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import Product from "../interfaces/Product";
import products from "../assets/products.js";

const productsOnSale: Product[] = products.filter(p => p.onsale);
// .filter(p => p.onsale)
const numOnSale = productsOnSale.length;
// length = 6

export default function OnSaleSlider() {
  const [from, setFrom] = useState(0);
  const [to, setTo] = useState(4);

  const nextSug = () => {
    // console.log(numOnSale);
    const newTo = Math.min(to + 4, numOnSale);
    // if (newTo == numOnSale) {
    //   setFrom(numOnSale - 4);
    // } else {
    //   setFrom(from + 4);
    // }
    setFrom(newTo - 4);
    setTo(newTo);
  };

  const prevSug = () => {
    const newFrom = Math.max(from - 4, 0);
    setFrom(newFrom);
    setTo(newFrom + 4);
  };

  return (
    <div className={styles.container}>
      <FontAwesomeIcon
        onClick={prevSug}
        className={[styles.fa, from == 0 ? styles["fa-disable"] : ""].join(" ")}
        icon={faChevronLeft}
      />
      <div id={styles.products} className={styles.productContainer}>
        {productsOnSale.slice(from, to).map(p => (
          <OnSaleCard key={p.id} product={p} />
        ))}
      </div>
      <FontAwesomeIcon
        onClick={nextSug}
        className={[
          styles.fa,
          to == numOnSale ? styles["fa-disable"] : "",
        ].join(" ")}
        icon={faChevronRight}
      />
    </div>
  );
}
