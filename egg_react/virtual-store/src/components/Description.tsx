import { Dispatch, useEffect, useRef } from "react";
import Product from "../interfaces/Product";
import styles from "./Description.module.css";

export default function Description({
  product,
  setSelectedColor,
}: {
  product: Product;
  setSelectedColor: Dispatch<string | undefined>;
}) {
  const colorRef = useRef<HTMLSelectElement>(null);

  useEffect(() => {
    setSelectedColor(colorRef.current?.value);
  }, [colorRef.current?.value]);
  return (
    <>
      <div className={styles["product-description-block"]}>
        <h1 className={styles["title"]}>{product.title}</h1>
        <form className={styles["selector"]}>
          <fieldset>
            <label className={styles["label"]} htmlFor="color">
              Color
            </label>
            <select
              ref={colorRef}
              onChange={() => setSelectedColor(colorRef.current?.value)}
            >
              {product.colors.map(c => (
                <option key={c} value={c}>
                  {c}
                </option>
              ))}
            </select>
          </fieldset>
        </form>
        <div className={styles["description"]}>
          <p>
            <strong>Descripción</strong>
          </p>
          <p>{product.description}</p>
        </div>
      </div>
    </>
  );
}
