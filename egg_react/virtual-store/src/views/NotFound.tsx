import Footer from "../components/Footer";
import Hero from "../components/Hero";
import NavBar from "../components/NavBar";
// import styles from "./NotFound.module.css";

export default function NotFound() {
  return (
    <>
      <NavBar />
      <Hero first="404" second="Not found" />
      <Footer />
    </>
  );
}
