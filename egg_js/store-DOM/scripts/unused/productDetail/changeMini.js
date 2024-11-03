export default function changeMini(e) {
  const clickedSrc = e.target.src;
  const bigSelector = document.querySelector(".main-image");
  bigSelector.src = clickedSrc;
}
