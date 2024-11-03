import { Link } from "react-router-dom";
import styles from "./OnSaleCard.module.css";

export default function OnSaleCard({ product }) {
  const { id, title, description, price, stock, images, colors, onsale } =
    product;

  return (
    <Link className={styles.productCard} to={"/details/" + id}>
      <img className={styles.productImg} src={images[0]} alt={title} />
      <div className={styles.productInfo}>
        <p className={styles.productTitle}>{title}</p>
        {/* <span className={styles.productDescription}>{colors[0]}</span> */}
        <div className={styles.productPriceBlock}>
          <span className={styles.price}>S/{price}</span>
          <span className={styles.discount}>{onsale ? "50% Off" : ""}</span>
        </div>
        <div className={styles.productTaxPolicy}>¡Compra y paga en soles!</div>
      </div>
    </Link>
  );
}
