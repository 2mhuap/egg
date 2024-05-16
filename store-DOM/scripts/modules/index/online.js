import updateLoginIcon from "../online/updateLoginIcon.js";

// updateLoginIcon

const loginSelector = document.getElementById("login");

export default function manageOnline() {
  let isOnline = JSON.parse(localStorage.getItem("isOnline"));

  loginSelector.addEventListener("click", () => {
    isOnline = JSON.parse(localStorage.getItem("isOnline"));
    let newStatus;
    if (isOnline == null) {
      newStatus = true;
    } else {
      newStatus = !isOnline;
    }
    localStorage.setItem("isOnline", JSON.stringify(newStatus));
    updateLoginIcon(newStatus);
  });

  updateLoginIcon(isOnline ?? false);
}
