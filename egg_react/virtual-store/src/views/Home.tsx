import { useEffect, useState } from "react";
import axios from "axios";
import Footer from "../components/Footer";
import Hero from "../components/Hero";
import NavBar from "../components/NavBar";
import ProductCard from "../components/ProductCard";
import Product from "../interfaces/Product";
import { useAppSelector } from "../store/hooks";
// import styles from "./Home.module.css";

export default function Home() {
  const [products, setProducts] = useState<Product[]>([]);
  const searchText = useAppSelector(state => state.products.searchText);

  useEffect(() => {
    axios
      .get("/products.json")
      .then(res => {
        if (searchText == "") {
          setProducts(res.data);
        } else {
          const filterData = res.data.filter(p =>
            p.title.toLowerCase().includes(searchText.toLowerCase())
          );
          setProducts(filterData);
        }
      })
      .catch(error => console.error(error));
  }, [searchText]);

  return (
    <>
      <NavBar />

      <Hero first="tecnología" second="renovada" />

      <main>
        <div className="w-full max-w-[1170px] mx-auto">
          <div className="grid grid-cols-autofit-products gap-5">
            {products.map((p: Product) => (
              <ProductCard key={p.id} product={p} />
            ))}
          </div>
        </div>
      </main>

      <Footer />
    </>
  );
}
