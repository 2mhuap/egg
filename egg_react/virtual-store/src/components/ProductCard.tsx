import { Link } from "react-router-dom";
import styles from "./ProductCard.module.css";
import Product from "../interfaces/Product";

export default function ProductCard({ product }: { product: Product }) {
  const { id, title, price, images, onsale } = product;

  return (
    <Link className={styles.productCard} to={"/details/" + id}>
      <img className={styles.productImg} src={images[0]} alt={title} />
      <div className={styles.productInfo}>
        <span className={styles.productTitle}>{title}</span>
        {/* <span className={styles.productDescription}>{colors[0]}</span> */}
        <div className={styles.productPriceBlock}>
          <span className={styles.price}>S/{price}</span>
          {onsale && <span className={styles.discount}>50% Off</span>}
        </div>
        <div className={styles.productTaxPolicy}>
          Incluye impuesto País y percepción AFIP
        </div>
      </div>
    </Link>
  );
}

{
  /* <a class="product-card" href="./details.html?id=${product.id}">
  <img
    class="product-img"
    src="${
        product.images.length == 0 ? img : product.images[0]
      }"
    alt="${product.title}"
  />
  <div class="product-info">
    <span class="product-title">${product.title}</span>
    <span class="product-description">${product.getSupplier}</span>
    <div class="product-price-block">
      <span class="price">S/${product.price}</span>
      <span class="discount">${product.onsale ? "50% off" : ""}</span>
    </div>
    <div class="product-tax-policy">
      Incluye impuesto País y percepción AFIP
    </div>
  </div>
</a>; */
}
