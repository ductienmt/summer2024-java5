import Category from "../category/category";
import Discount from "../discount/discount";
import OrderMethod from "../orderMethod/orderMethod";
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
      <Discount />
      <OrderMethod />
    </div>
  );
};

export default Home;
