import { createReducer } from "@reduxjs/toolkit";
import { captureSearchText, clearCart, updateCart } from "../actions/products";
import CartProduct from "../../interfaces/CartProduct";

const initialState = { searchText: "", cartTotal: 0, cartCount: 0 };

const productsReducer = createReducer(
  initialState,
  builder => {
    builder
      .addCase(captureSearchText,(state, action) => (
        {...state, searchText: action.payload.searchText}
      ))
      // .addCase(calculateTotal, (state, action) => {
      //   const products = action.payload.products;
      //   const subtotals = products.map(p => p.price * p.units);
      //   const cartTotal = subtotals.reduce((acc: number, val: number) => acc + val);
      //   return {...state, cartTotal}
      // })
      .addCase(updateCart, (state, action) => {
        const products = action.payload.products;
        const cartTotal = products.reduce((acc: number, p: CartProduct) => acc + p.price * p.units, 0);
        const cartCount = products.reduce((acc, p: CartProduct) => acc + p.units, 0);
        return {...state, cartTotal, cartCount}
      })
      .addCase(clearCart, (state, action) => ({...state, cartTotal: 0, cartCount: 0}))
  }
)

export default productsReducer;