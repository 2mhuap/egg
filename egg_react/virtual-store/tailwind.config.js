/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      gridTemplateColumns: {
        "autofit-products": "repeat(auto-fit, minmax(250px, 1fr))",
      },
      backgroundImage: {
        hero: "url('../hero_bg.png')",
      },
    },
  },
  plugins: [],
};
