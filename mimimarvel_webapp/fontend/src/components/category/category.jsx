import { useEffect, useState } from "react";
import axios from "axios";
import "./category.css";

const Category = () => {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    loadCategories();
  }, []);

  const loadCategories = async () => {
    try {
      const res = await axios.get("http://localhost:8080/category/list");
      setCategories(res.data);
    } catch (error) {
      console.error("Error loading categories", error);
    }
  };

  return (
    <div className="container gx-0 py-4 full-main-category">
      <h2 className="py-3 name-header">Danh mục</h2>
      <div className="row gx-0 main-category">
        {categories.map((category, index) => (
          <div className="col-md-2 col-6" key={index}>
            <div className="home-category text-center">
              <img
                src={`../../../public/category/${category.image}`}
                className="img-fluid"
                alt={category.name || "Category"}
              />

              <h5 className="category-title">
                {category.name || "Categories"}
              </h5>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Category;
