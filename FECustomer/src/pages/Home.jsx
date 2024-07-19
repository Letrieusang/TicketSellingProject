import React, { useEffect, useState } from 'react';
import productApi from '../api/productApi';
import ProductCard from '../component/ProductCard';
import { Link } from 'react-router-dom';

const Home = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await productApi.random20Products();
        setProducts(response.data);
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    };

    fetchProducts();
  }, []);

  return (
    <div className="flex flex-col items-center mx-4">
      <div className="mt-10 mb-20 shadow-lg">
      <Link to={"/cart"}>
        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
          Cart
        </button>
      </Link>
      </div>
      <div className="grid grid-cols-5 gap-4 grid-flow-row-dense grid-rows-4">
        {products.map((product, index) => (
          <ProductCard key={index} item={product}/>
        ))}
      </div>
    </div>
  );
};

export default Home;
