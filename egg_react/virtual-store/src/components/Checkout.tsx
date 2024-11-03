import { useState, useRef, useEffect } from "react";
import styles from "./Checkout.module.css";
import Product from "../interfaces/Product";
import CartProduct from "../interfaces/CartProduct";
import { updateCart } from "../store/actions/products";
import { useAppDispatch } from "../store/hooks";

export default function Checkout({
  product,
  selectedColor,
}: {
  product: Product;
  selectedColor: string | undefined;
}) {
  const [quantity, setQuantity] = useState(1);
  const [removeButton, setRemoveButton] = useState(false);
  const unitsRef = useRef<any>(null);
  const dispatch = useAppDispatch();

  useEffect(() => {
    let productsInStorage: CartProduct[] = [];
    const getCart = localStorage.getItem("cart");
    if (getCart) {
      productsInStorage = JSON.parse(getCart);
    }

    const prodIsStored: CartProduct | undefined = productsInStorage.find(
      (p: CartProduct) => p.id == product.id && p.color == selectedColor
    );
    console.log("looking for product");
    if (prodIsStored) {
      setQuantity(prodIsStored.units);
      setRemoveButton(true);
    } else {
      setQuantity(1);
      setRemoveButton(false);
    }
  }, [product.id, selectedColor]);

  const manageCart = () => {
    let productsInStorage: CartProduct[] = [];
    const getCart = localStorage.getItem("cart");
    if (getCart) {
      productsInStorage = JSON.parse(getCart);
    }

    const prodIsStored = productsInStorage.find(
      p => p.id == product.id && p.color == selectedColor
    );
    if (prodIsStored) {
      // producto se encuentra en localStorage -> sacarlo
      productsInStorage = productsInStorage.filter(
        p => p.id !== product.id && p.color != selectedColor
      );
      setRemoveButton(false);
    } else {
      // producto NO se encuentra en localStorage -> agregarlo
      const prodForCart: CartProduct = {
        id: product.id,
        title: product.title,
        price: product.price,
        image: product.images[0],
        color: selectedColor ?? "",
        units: quantity,
        onsale: product.onsale,
      };

      productsInStorage.push(prodForCart);
      setRemoveButton(true);
    }

    localStorage.setItem("cart", JSON.stringify(productsInStorage));
    dispatch(updateCart(productsInStorage));
  };

  return (
    <>
      <div className={styles["checkout-container"]}>
        <span className={styles["checkout-total-label"]}>Precio:</span>
        <h2 className={styles["checkout-total-price"]}>
          S/{product.price.toLocaleString()}
        </h2>
        <p className={styles["checkout-description"]}>
          Incluye impuesto PAIS y percepción AFIP.
        </p>
        <ul className={styles["checkout-policy-list"]}>
          <li>
            <span className={styles["policy-icon"]}>
              <img src="../truck.png" alt="Truck" />
            </span>
            <span className={styles["policy-desc"]}>
              Agrega el producto al carrito para conocer los costos de envío
            </span>
          </li>
          <li>
            <span className={styles["policy-icon"]}>
              <img src="../plane.png" alt="Plane" />
            </span>
            <span className={styles["policy-desc"]}>
              Recibí aproximadamente entre 10 y 15 días hábiles, seleccionando
              envío normal
            </span>
          </li>
        </ul>
        <div className={styles["checkout-process"]}>
          <div className={styles["top"]}>
            <input
              id={styles["cantidad"]}
              type="number"
              defaultValue={quantity}
              min="1"
              disabled={removeButton}
              ref={unitsRef}
              onChange={() => setQuantity(Number(unitsRef.current.value))}
            />
            <button
              id={styles["add-to-cart"]}
              className={
                removeButton ? styles["btn-remove"] : styles["btn-primary"]
              }
              onClick={manageCart}
            >
              {removeButton ? "Sacar del carrito" : "Añadir al carrito"}
            </button>
          </div>
          <div>
            Subtotal: S/
            <span id={styles["subtotal"]}>{product.price * quantity}</span>
          </div>
        </div>
      </div>
    </>
  );
}
