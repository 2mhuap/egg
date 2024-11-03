import renderLayout from "./renderLayout.js";

export default async function layout() {
  fetch("./options.json")
    .then(response => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json();
    })
    .then(data => renderLayout(data.navigation, data.optionsFooter))
    .catch(error => console.error("ERROR: ", error));
}
