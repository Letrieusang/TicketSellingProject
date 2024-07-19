import React, { useContext, useState, useEffect } from 'react';
import { CartContext } from '../context/CartContext';
import productApi from '../api/productApi';

const CartCard = ({ item, onQuantityChange }) => {
  const { updateCartItemQuantity, removeFromCart } = useContext(CartContext);
  const [productDetail, setProductDetail] = useState(null);

  useEffect(() => {
    const fetchProductDetail = async () => {
      try {
        const response = await productApi.getProduct(item.productId);
        setProductDetail(response.data);
      } catch (error) {
        console.error('Error fetching product detail:', error);
      }
    };

    fetchProductDetail();
  }, [item.productId]);

  const handleQuantityChange = (e) => {
    const newQuantity = parseInt(e.target.value);
    updateCartItemQuantity(item.productId, newQuantity);
    onQuantityChange(item.productId, newQuantity);
  };

  if (!productDetail) {
    return <div>Loading...</div>;
  }

  const totalWeight = (productDetail.weight * item.addedQuantity).toFixed(2);
  return (
    <div className="border-b pb-4 mb-4 flex items-center">
      <div className="w-1/4">
        <img src={productDetail.image} alt={productDetail.title} className="w-64 h-64 object-cover rounded" />
      </div>
      <div className="w-3/4 px-4 flex flex-col">
        <h2 className="text-xl font-bold">{productDetail.title}</h2>
        <p>Category: {productDetail.category.categoryName}</p>
        <p>Available in stock: {productDetail.quantity}</p>
        <p>Price: {productDetail.currentPrice} k</p>
        <p>Weight: {productDetail.weight} kg</p>
        <p>Total Weight: {totalWeight} kg</p>
        <div className="flex items-center">
          <label className="mr-2">Buy:</label>
          <input
            type="number"
            className="w-16 p-1 border border-gray-300 rounded"
            value={item.addedQuantity}
            min="1"
            onChange={handleQuantityChange}
          />
        </div>
        <p>Total: {productDetail.currentPrice * item.addedQuantity} k</p>
        <p>Rush Order Support: {productDetail.rushOrderSupport ? 'Yes' : 'No'}</p>
        <button
          className="mt-2 bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded"
          onClick={() => removeFromCart(item.productId)}
        >
          Remove
        </button>
      </div>
    </div>
  );
};

export default CartCard;
