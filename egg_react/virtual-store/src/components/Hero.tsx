// import styles from "./Hero.module.css";

export default function Hero({ first, second }) {
  return (
    <>
      <section className="h-[340px] bg-cover bg-[top_center] bg-hero">
        <div className="flex items-center justify-start h-full w-full max-w-[1170px] my-0 mx-auto">
          <div>
            <span className="block text-white font-bold text-2xl leading-[1rem]">
              {first}
            </span>
            <span className="block text-white font-bold text-6xl leading-[3rem]">
              {second}
            </span>
          </div>
        </div>
      </section>
    </>
  );
}
