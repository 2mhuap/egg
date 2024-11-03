import { faHeart, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { useRef } from "react";
import CartProduct from "../interfaces/CartProduct";

export default function CartCard({
  product,
  updateUnits,
  removeProduct,
  last = false,
}: {
  product: CartProduct;
  updateUnits: (id: string, color: string, newUnits: number) => void;
  removeProduct: (id: string, color: string) => void;
  last: boolean;
}) {
  const { id, title, color, price, image, units } = product;
  const unitsRef = useRef<any>(units);

  return (
    <div className={"flex gap-3 md:gap-6 items-start" + (last ? "" : " mb-6")}>
      <div className="flex items-center">
        <FontAwesomeIcon
          icon={faTrash}
          className="mr-4 ml-[-6px] text-gray-500 cursor-pointer"
          onClick={() => removeProduct(id, color)}
        />
        <img
          className="w-20 md:w-36 object-contain"
          src={image}
          alt="prodImg"
        />
      </div>
      <div className="grow">
        <div className="flex justify-between mt-2">
          <p className="font-bold">{title}</p>
          <FontAwesomeIcon
            className="border-none text-grey-500 text-xl cursor-pointer bg-none text-gray-500 hover:text-red-600"
            icon={faHeart}
          />
        </div>

        <p className="capitalize">{color}</p>
        <div className="flex justify-start items-center">
          <p className="font-bold">S/{price} x </p>
          <input
            className="rounded-lg w-16 border-none ml-2 px-3 h-[40px]"
            type="number"
            name={"quantity-" + id}
            defaultValue={units}
            ref={unitsRef}
            onChange={() =>
              updateUnits(id, color, Number(unitsRef.current?.value))
            }
            min="1"
          />
        </div>
      </div>
    </div>
  );
}
