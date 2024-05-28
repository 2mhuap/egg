export default function logoutUser() {
  localStorage.setItem("isOnline", JSON.stringify(false));
  localStorage.removeItem("onlineUser");
}
