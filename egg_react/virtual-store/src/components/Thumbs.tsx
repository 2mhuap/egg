import { useEffect, useState } from "react";
import styles from "./Thumbs.module.css";
import Product from "../interfaces/Product";

export default function Thumbs({ product }: { product: Product }) {
  const [thumb, setThumb] = useState(product.images[0] || "/mock1.jpg");

  useEffect(() => setThumb(product.images[0] || "/mock1.jpg"), [product.id]);

  return (
    <div className={styles["product-images-block"]}>
      {product.images.map(i => (
        <div key={i} className={styles["thumbnail-container"]}>
          <img src={i} alt={product.title} onClick={() => setThumb(i)} />
        </div>
      ))}
      <img className={styles["main-image"]} src={thumb} alt="mock 1 main" />
    </div>
  );
}
