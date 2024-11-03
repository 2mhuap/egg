import withReactContent from "sweetalert2-react-content";
import { useAppDispatch, useAppSelector } from "../store/hooks";
import Swal from "sweetalert2";
import { clearCart } from "../store/actions/products";

export default function CartResumen({ clearCards }) {
  const { cartTotal, cartCount } = useAppSelector(state => state.products);
  const dispatch = useAppDispatch();

  const showSwal = () => {
    withReactContent(Swal)
      .fire({
        title: "¿Estás seguro?",
        text: "Vas a hacer una compra de S/" + cartTotal,
        showCancelButton: true,
        confirmButtonText: "Finalizar compra",
      })
      .then(result => {
        if (result.isConfirmed) {
          localStorage.removeItem("cart");
          dispatch(clearCart());
          clearCards();
        }
      });
  };

  return (
    <div className="bg-[#ebebeb] p-3 md:p-6 rounded grow h-fit">
      <h3 className="font-bold text-xl">Resumen del pedido</h3>
      <div>Cantidad de productos: {cartCount}</div>
      <div className="flex font-bold justify-between my-4">
        <p>Total</p>
        <p>S/ {cartTotal}</p>
      </div>

      <p className=" text-xs my-4">Incluye impuesto PAIS y percepción AFIP</p>
      <button
        className="w-full bg-[#ff3b3c] text-white font-bold border-none rounded-lg p-3 cursor-pointer"
        onClick={showSwal}
      >
        Finaliza tu compra
      </button>
    </div>
  );
}
