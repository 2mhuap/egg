export default function loginUser(user) {
  localStorage.setItem("onlineUser", user);
  localStorage.setItem("isOnline", JSON.stringify(true));
}
