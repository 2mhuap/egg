// import styles from "./Footer.module.css";

export default function Footer() {
  return (
    <footer>
      <div className="flex justify-between flex-wrap w-full max-w-[1170px] mx-auto">
        <ul className="w-[170px] py-4 list-none">
          <li className="font-bold pb-1">
            <a className="text-white no-underline" href="./index.html">
              Ofertas
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Laptops
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Audio
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Auriculares
            </a>
          </li>
        </ul>
        <ul className="w-[170px] py-4 list-none">
          <li className="font-bold pb-1">
            <a className="text-white no-underline" href="./index.html">
              Cómo comprar
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Formas de pago
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Envios
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Devoluciones
            </a>
          </li>
        </ul>
        <ul className="w-[170px] py-4 list-none">
          <li className="font-bold pb-1">
            <a className="text-white no-underline" href="./index.html">
              Costos y tarifas
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Impuestos
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Facturación
            </a>
          </li>
        </ul>
        <ul className="w-[170px] py-4 list-none">
          <li className="font-bold pb-1">
            <a className="text-white no-underline" href="./index.html">
              Mis pedidos
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Pedir nuevamente
            </a>
          </li>
          <li className="py-1">
            <a className="text-white no-underline" href="./index.html">
              Lista de deseos
            </a>
          </li>
        </ul>
        <ul className="w-[170px] py-4 list-none">
          <li className="font-bold pb-1">
            <a className="text-white no-underline" href="./index.html">
              Garantía
            </a>
          </li>
        </ul>
      </div>
      <div className="text-center text-white font-bold py-5 box-border">
        Curso de HTML + CSS 2023
      </div>
    </footer>
  );
}
