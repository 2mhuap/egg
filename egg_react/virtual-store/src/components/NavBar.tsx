import { Link, useLocation, useNavigate } from "react-router-dom";
// import styles from "./NavBar.module.css";
import NavButton from "./NavButton";
import { useEffect, useRef } from "react";
import { captureSearchText, updateCart } from "../store/actions/products";
import { useAppDispatch, useAppSelector } from "../store/hooks";
import CartProduct from "../interfaces/CartProduct";

export default function NavBar() {
  const searchTextRef = useRef<HTMLInputElement>(null);
  const { searchText, cartCount } = useAppSelector(state => state.products);
  const dispatch = useAppDispatch();
  const location = useLocation();
  const navigate = useNavigate();

  useEffect(() => {
    const getCart = localStorage.getItem("cart");
    let productsInStorage: CartProduct[] = [];
    if (getCart) {
      productsInStorage = JSON.parse(getCart);
      dispatch(updateCart(productsInStorage));
    }
  }, []);

  const setText = () => {
    dispatch(
      captureSearchText(
        searchTextRef.current ? searchTextRef.current.value : ""
      )
    );
  };

  const submitSearch = e => {
    e.preventDefault();
    if (location.pathname != "/") {
      navigate("/");
    }
  };

  return (
    <>
      <header className="bg-[#ff3b3c]">
        <div className="h-full w-full max-w-[1170px] mx-auto">
          <div className="flex-1 flex flex-wrap justify-between items-center gap-3 sm:gap-4">
            <div className="w-full flex justify-center mt-2 sm:justify-start sm:w-fit sm:mt-0">
              <Link to="/">
                <img
                  className="block w-36"
                  src="../tiendamia-logo.svg"
                  width="218"
                  alt="Logo store"
                />
              </Link>
            </div>
            <div className="box-border flex justify-center flex-1">
              <form className="w-full max-w-[500px]" onSubmit={submitSearch}>
                <input
                  className="rounded-xl border-none w-full p-2 sm:p-4 box-border"
                  type="text"
                  placeholder="Search"
                  ref={searchTextRef}
                  defaultValue={searchText}
                  onChange={setText}
                />
              </form>
            </div>
            <div className="social">
              <ul className="flex justify-end items-center list-none">
                <li>
                  <img
                    className="block w-6 mr-3"
                    src="../facebook.png"
                    alt="icono facebook"
                  />
                </li>
                <li>
                  <img
                    className="block mb-[-2px] mr-3"
                    src="../instagram.png"
                    alt="icono instagram"
                  />
                </li>
                <li className=" relative">
                  <div className="flex justify-center font-bold items-center rounded-full bg-white text-[#ff3b3c] border-2 border-[#ff3b3c] box-border absolute w-5 h-5 right-[-6px] top-[-8px] text-sm">
                    <div>{cartCount}</div>
                  </div>
                  <Link to="/cart">
                    <img
                      className="block h-8 mb-[-2px] mx-[-2px] object-contain"
                      src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAYAAAA6/NlyAAAAAXNSR0IArs4c6QAAA81JREFUaEPtml2ITVEUx/9/UsjDiDFJHpQ8iAfNNCFfSV4YKUUzJOHVw0QKTT4ilDJ58UBpkq/yIIM3GV9NE0Z58aCRfGZGyseDByx3ZV/dtn3vuedjnzNz792vZ++11m//V3vts84hqmywynhRA650xWsK1xSusB2opXSFCfofTk1h3RIRkRGu9ACAXSSv2RxOhSsAWDl/A6gj+a0QupKBlXMayffVAjxEcko1pfQFkpvKAnYdWCJSD+ADgNHW8+Uk72R1yImIxvMVwHgrho0kL0YGNqf3DQCrLCPnSG7NEHgZAHvDtcpMJPklLvAGAJctI98B1JP8kQW0iBwHsNvy3UdyviueUBcPERkLYAjABMtYK0l7I1LhF5FnAOZazvaTPBQb2KT1WQDbLGO3SNqp7h3YnCuDDkfNuXgeJQW8FECPZewXgKkkVf3UhojoxqsAhUNjaCDpvC2GSmmjsK55o0XdctROsjM12r9X4KsA1lk+z5PcXCyO0MAG+giAvZbRfpKNaQGXKEdtJC8lDTwDwEuH0dkkn6cBLSKLAdyzfBUtR/l5kRQ2Kuuh0GQ5PEZyT0rArizrJbmwlP84wDsAnLKMvwMwvdiBkeRGiEg/gHmWzQ6Sh30B1wH4lMVVs0Q5aiL5xAuwSetuAKstBw8A3E5STYetWQBa7XLkejuy10ZOaQO8HsAVz3Dlmu8iuSVoclzgMQA+O66aQX59PF9BMjCzYgEblc8A2O6DIITN+ySXlDM/CWB1dLccZ57maMNuQbnX2tjARuXXWo4soMcAbnqCzJv9SPJ0GB9JAWvt22c5HiA5M0wwacxNCrjYVTOwLqYBWegjEWCT1n0Ami2AzlybpT1tKG8Xj0LDIuK6av4E0EhSuxLDYiSp8KRceXoLQNtA9tDu4QsPxD0k7WZESTeJAZu0PgFgpwewYiYPkjwQxl/SwJMBaIkaFyaIGHOzBTYqrwSgX+3SgM4e2EBr2/Soo2kfQ0zn0uEBnA8t12SbY3rG2vCze9lJwGd7aCVB4NtGooeW72CTsO8dWEROAmgDoCd4b65Oa6NPP8oFjjhrixn3Ciwi1wG0OJy3BEHHWVtqJ70Bi4j2urTn5RoPSS4qFlictUFp4xO4A4DzC57+cELS/rD+L1YRibw2S2DXy0Q+nsHci3tDCYUjr80SWDsgr3Iqj3IEUfK1UUQir80M2Ny49KeSLgu6m+SaoMBEJPLaTA6tgtuWqrVWfxID8DTodC4M1igdaW0mZSlIxSyeezuls4Apx2cNuJxdGslzagqPZPXKib3qFP4DPc5DTOx+iUAAAAAASUVORK5CYII="
                      alt="icono cart"
                    />
                  </Link>
                </li>
                <li id="login"></li>
              </ul>
            </div>
          </div>
          <div className="mt-4">
            <ul className="flex justify-between list-none gap-x-8 flex-wrap">
              <li>
                <NavButton title="Ofertas de la semana" link="/onsale" />
              </li>
              <li>
                <NavButton title="Productos" link="/" />
              </li>
              <li>
                <NavButton title="Contacto" link="/" />
              </li>
              <li>
                <NavButton title="Marcas" link="/" />
              </li>
            </ul>
          </div>
        </div>
      </header>
    </>
  );
}
