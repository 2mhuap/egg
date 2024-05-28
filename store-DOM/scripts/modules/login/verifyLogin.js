import loginUser from "../online/loginUser.js";

export default function verifyLogin(email, pw) {
  const users = JSON.parse(localStorage.getItem("users"));
  if (users) {
    const storedUser = users.find(
      u => u.email == email && u["contraseña"] == pw
    );
    if (storedUser) {
      loginUser(email);
      window.location.href = "index.html";
    } else {
      alert("No existe ese usuario");
    }
  } else {
    alert("No existe ese usuario");
  }
}
