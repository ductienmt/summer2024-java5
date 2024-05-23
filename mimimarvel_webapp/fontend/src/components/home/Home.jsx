import Category from "../category/category";
import NewArrival from "../products/newArrival";
import Products from "../products/products";
import Banner from "./Banner/Banner";

const Home = () => {
  return (
    <div>
      <Banner />
      <Category />
      <Products />
      <NewArrival />
    </div>
  );
};

export default Home;
