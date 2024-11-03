import registerUser from "./modules/register/registerUser.js";

const registerBtnSelector = document.getElementById("register-btn");
const emailSelector = document.getElementById("input-email");
const pwSelector = document.getElementById("input-pw");
const offerSelector = document.getElementById("checkbox-ofertas");

registerBtnSelector.addEventListener("click", e => {
  // e.preventDefault();
  registerUser(emailSelector.value, pwSelector.value, offerSelector.checked);
});
