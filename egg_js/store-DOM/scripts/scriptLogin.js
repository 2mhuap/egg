import verifyLogin from "./modules/login/verifyLogin.js";

const loginBtnSelector = document.getElementById("btn-login");
const emailSelector = document.getElementById("input-email");
const pwSelector = document.getElementById("input-pw");

loginBtnSelector.addEventListener("click", e => {
  e.preventDefault();
  verifyLogin(emailSelector.value, pwSelector.value, e);
});
