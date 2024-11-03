import loginUser from "../online/loginUser.js";

export default function registerUser(email, pw, offer) {
  const users = JSON.parse(localStorage.getItem("users"));
  const newUser = { email, contraseña: pw, oferta: offer };
  if (users) {
    const storedEmail = users.find(u => u.email == email);
    if (storedEmail) {
      alert("Ya existe ese email en el sistema");
    } else {
      users.push(newUser);
      localStorage.setItem("users", JSON.stringify(users));
      loginUser(email);
      window.location.href = "index.html";
    }
  } else {
    localStorage.setItem("users", JSON.stringify([newUser]));
    loginUser(email);
    window.location.href = "index.html";
  }
}
