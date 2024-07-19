import React, { useState, useContext } from 'react';
import { Link } from 'react-router-dom';
import { CartContext } from '../context/CartContext';

const ProductCard = ({ item }) => {
  const [quantity, setQuantity] = useState(1); // Default quantity is 1
  const { addToCart } = useContext(CartContext);

  const handleAddToCart = () => {
    addToCart(item.productId, quantity);
  };

  return (
    <div className="max-w-xs rounded overflow-hidden shadow-lg mx-2 flex flex-col">
      <Link
      to={`/home/detail/${item.productId}`}
      state={{ item: item }}
      >
        <img className="w-full h-64 object-cover" src={item.image} alt={item.title} />
      </Link>
      <div className="px-6 py-4 flex-1 flex flex-col justify-between">
        <div>
          <div className="font-bold text-xl mb-2">{item.title}</div>
          <p className="text-gray-700 text-base">Category: {item.category.categoryName}</p>
          <p className="text-gray-700 text-base">Price: {item.currentPrice} k</p>
        </div>
        <div className="mt-4 flex justify-between items-center">
          <input
            className="shadow appearance-none border rounded w-24 py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
            type="number"
            min="1"
            value={quantity}
            onChange={(e) => setQuantity(parseInt(e.target.value))}
          />
          <button
            className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
            onClick={handleAddToCart}
          >
            Add to Cart
          </button>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;
