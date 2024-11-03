import { createBrowserRouter, RouterProvider } from "react-router-dom";
import Home from "./views/Home";
import Details from "./views/Details";
import Cart from "./views/Cart";
import NotFound from "./views/NotFound";
import OnSale from "./views/OnSale";
import { Provider } from "react-redux";
import { store } from "./store/index";

function App() {
  const browserRouter = createBrowserRouter([
    { path: "/", element: <Home /> },
    { path: "/details/:productId", element: <Details /> },
    { path: "/cart", element: <Cart /> },
    { path: "/onsale", element: <OnSale /> },
    { path: "/*", element: <NotFound /> },
  ]);

  return (
    <Provider store={store}>
      <RouterProvider router={browserRouter} />
    </Provider>
  );
}

export default App;
