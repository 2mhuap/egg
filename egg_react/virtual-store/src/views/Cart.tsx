import CartCard from "../components/CartCard";
import CartResumen from "../components/CartResumen";
import Footer from "../components/Footer";
import Hero from "../components/Hero";
import NavBar from "../components/NavBar";
// import styles from "./Cart.module.css";
import { useEffect, useState } from "react";
import CartProduct from "../interfaces/CartProduct";
import { updateCart } from "../store/actions/products";
import { useAppDispatch } from "../store/hooks";

export default function Cart() {
  // const [total, setTotal] = useState(0);
  const [productsInCart, setProductsInCart] = useState<CartProduct[]>([]);
  const dispatch = useAppDispatch();

  useEffect(() => {
    const getCart = localStorage.getItem("cart");
    let productsInStorage: CartProduct[] = [];
    if (getCart) {
      productsInStorage = JSON.parse(getCart);
      setProductsInCart(productsInStorage);
      dispatch(updateCart(productsInStorage));
    }
    // setTotal(productsInStorage.reduce((acc, p) => acc + p.price * p.units, 0));
  }, []);

  const updateUnits = (id: string, color: string, newUnits: number) => {
    const prod = productsInCart.find(p => p.id == id && p.color == color);
    if (prod) {
      prod.units = newUnits;
      localStorage.setItem("cart", JSON.stringify(productsInCart));
      dispatch(updateCart(productsInCart));
    } else {
      console.error("Error: Producto no está en el carrito");
    }
  };

  const removeProduct = (id: string, color: string) => {
    const newProds = productsInCart.filter(p => p.id != id && p.color != color);
    setProductsInCart(newProds);
    localStorage.setItem("cart", JSON.stringify(newProds));
    dispatch(updateCart(newProds));
  };

  const clearCards = () => {
    setProductsInCart([]);
  };

  return (
    <>
      <NavBar />

      <Hero first="mi" second="carrito" />

      <main>
        <div className="h-full w-full max-w-[1170px] mx-auto flex justify-between gap-6 flex-col md:flex-row">
          <div className="bg-[#ebebeb] p-3 md:p-6 rounded md:w-2/3 h-fit">
            {productsInCart.length == 0 && "No hay productos en el carrito"}
            {productsInCart.map((p, i) => (
              <CartCard
                key={i}
                product={p}
                updateUnits={updateUnits}
                removeProduct={removeProduct}
                last={i == productsInCart.length - 1}
              />
            ))}
          </div>
          <CartResumen clearCards={clearCards} />
        </div>
        <div className="h-full w-full max-w-[1170px] mx-auto mt-6">
          <h2 className="text-xl font-bold">Favoritos</h2>
        </div>
        <div className="flex gap-3 max-w-[1170px] mx-auto">
          No hay favoritos
        </div>
      </main>
      <Footer />
    </>
  );
}
