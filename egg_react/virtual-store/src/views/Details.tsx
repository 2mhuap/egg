import { useParams } from "react-router-dom";
import Footer from "../components/Footer";
import NavBar from "../components/NavBar";
// import styles from "./Details.module.css";
// import products from "../assets/products";
import NotFound from "./NotFound";
import Thumbs from "../components/Thumbs";
import Description from "../components/Description";
import Checkout from "../components/Checkout";
import { useEffect, useState } from "react";
import Product from "../interfaces/Product";
import OnSaleSlider from "../components/OnSaleSlider";
import axios from "axios";

export default function Details() {
  const { productId } = useParams();
  const [product, setProduct] = useState<Product>({
    id: "",
    title: "",
    description: "",
    price: 0,
    stock: 0,
    images: [],
    colors: [],
    onsale: false,
  });
  const [selectedColor, setSelectedColor] = useState<string | undefined>("");

  // const product: Product = products.find((p: Product) => p.id == productId);
  useEffect(() => {
    axios("/products.json")
      .then(res => {
        const products: Product[] = res.data;
        const detailProduct: Product | undefined = products.find(
          (p: Product) => p.id == productId
        );
        detailProduct && setProduct(detailProduct);
      })
      .catch(err => console.log(err));
  }, [productId]);

  // console.log(product);
  if (product) {
    return (
      <>
        <NavBar />
        <main>
          <div className="h-full w-full max-w-[1170px] mx-auto">
            <div className="flex sm:flex-row justify-between mb-10 gap-4 flex-wrap flex-col">
              <Thumbs product={product} />
              <Description
                product={product}
                setSelectedColor={setSelectedColor}
              />
              <Checkout product={product} selectedColor={selectedColor} />
            </div>
            <div className="mb-8 border-t-slate-100 border-t-2">
              <h2 className="text-2xl font-bold w-full text-center my-10">
                Ofertas
              </h2>
              <OnSaleSlider />
            </div>
          </div>
        </main>

        <Footer />
      </>
    );
  } else {
    return <NotFound />;
  }
}
