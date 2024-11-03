import { Link } from "react-router-dom";
// import styles from "./NavButton.module.css";

export default function NavButton({ title, link }) {
  return (
    <Link className="text-white font-bold text-left no-underline" to={link}>
      {title}
    </Link>
  );
}
