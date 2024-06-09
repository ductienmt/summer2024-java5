import Category from "../category/category";
import Discount from "../discount/discount";
import OrderMethod from "../orderMethod/orderMethod";
import NewArrival from "../products/newArrival";
import PopularProduct from "../products/popular_product/popularProduct";
import Banner from "./Banner/Banner";

const Home = () => {
  return (
    <div>
      <Banner />
      <Category />
      <PopularProduct />
      <NewArrival />
      <Discount />
      <OrderMethod />
    </div>
  );
};

export default Home;
