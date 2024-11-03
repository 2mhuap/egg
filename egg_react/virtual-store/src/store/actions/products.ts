import { createAction } from "@reduxjs/toolkit";
import CartProduct from "../../interfaces/CartProduct";

const captureSearchText = createAction(
  "captureSearchText",
  (searchText: string) => ({payload: {searchText}})
)

// const calculateTotal = createAction(
//   "calculateTotal",
//   (products: CartProduct[]) => ({payload: {products}})
// )

const updateCart = createAction(
  "updateCart",
  (products: CartProduct[]) => ({payload: {products}})
)

const clearCart = createAction("clearCart")

export { captureSearchText, updateCart, clearCart };