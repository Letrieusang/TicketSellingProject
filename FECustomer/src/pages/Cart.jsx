import React, { useContext, useState, useEffect } from 'react';
import { CartContext } from '../context/CartContext';
import { Link } from 'react-router-dom';
import CartCard from '../component/CartCard';
import DeliveryForm from '../component/DeliveryForm';
import productApi from '../api/productApi';

const Cart = () => {
  const { cartItems, checkStock, stockStatus, updateCartItemQuantity } = useContext(CartContext);
  const [showOrderForm, setShowOrderForm] = useState(false);
  const [shippingFee, setShippingFee] = useState(0);
  const [rushOrder, setRushOrder] = useState(false);
  const [heaviestItemWeight, setHeaviestItemWeight] = useState(0);
  const [selectedProvince, setSelectedProvince] = useState('');

  // Function to calculate heaviest item weight
  const calculateHeaviestItem = async (items) => {
    let maxWeight = 0;
    for (const item of items) {
      const response = await productApi.getProduct(item.productId);
      const itemWeight = response.data.weight * item.addedQuantity;
      if (itemWeight > maxWeight) {
        maxWeight = itemWeight;
      }
    }
    setHeaviestItemWeight(maxWeight);
    return maxWeight; // Return the max weight if needed
  };

  // Function to calculate shipping fee
  const calculateShippingFee = async (province, isRushOrder, maxWeight) => {
    let fee = 0;
    if (province === 'Ha Noi' || province === 'Ho Chi Minh City') {
      fee = maxWeight < 3 ? 22 : 22 + Math.ceil((maxWeight - 3) / 0.5) * 2.5;
    } else {
      fee = maxWeight < 3 ? 30 : 30 + Math.ceil((maxWeight - 3) / 0.5) * 2.5;
    }

    if (isRushOrder) {
      const rushOrderFee = await calculateRushOrderFee();
      fee += rushOrderFee;
    }

    setShippingFee(fee);
  };

  // Function to calculate rush order fee
  const calculateRushOrderFee = async () => {
    let rushOrderFee = 0;
    for (const item of cartItems) {
      const response = await productApi.getProduct(item.productId);
      if (response.data.rushOrderSupport) {
        rushOrderFee += 10;
      }
    }
    return rushOrderFee;
  };

  // Use useEffect to calculate heaviest item weight when cartItems change
  useEffect(() => {
    if (cartItems.length > 0) {
      calculateHeaviestItem(cartItems);
    }
  }, [cartItems]);

  // Use useEffect to calculate shipping fee when heaviest item weight, selected province or rush order change
  useEffect(() => {
    if (selectedProvince && heaviestItemWeight !== 0) {
      calculateShippingFee(selectedProvince, rushOrder, heaviestItemWeight);
    }
  }, [selectedProvince, rushOrder, heaviestItemWeight]);

  // Handle place order button click
  const handlePlaceOrder = async () => {
    const stockCheck = await checkStock();
    if (stockCheck) {
      setShowOrderForm(true);
    } else {
      setShowOrderForm(false);
    }
  };

  // Handle province change
  const handleProvinceChange = (province) => {
    setSelectedProvince(province);
    // Recalculate shipping fee with updated province and rush order status
    calculateShippingFee(province, rushOrder, heaviestItemWeight);
  };

  // Handle rush order change
  const handleRushOrderChange = async (isRushOrder) => {
    setRushOrder(isRushOrder);
    // Recalculate shipping fee with updated rush order status
    calculateShippingFee(selectedProvince, isRushOrder, heaviestItemWeight);
  };

  // Handle quantity change
  const handleQuantityChange = async (productId, quantity) => {
    await updateCartItemQuantity(productId, quantity);
    // Update the heaviest item weight and shipping fee after quantity change
    const updatedCartItems = cartItems.map((item) =>
      item.productId === productId ? { ...item, addedQuantity: quantity } : item
    );
    const updatedHeaviestItem = await calculateHeaviestItem(updatedCartItems);
    setHeaviestItemWeight(updatedHeaviestItem);

    if (selectedProvince) {
      calculateShippingFee(selectedProvince, rushOrder, updatedHeaviestItem);
    }
  };

  return (
    <div className="container mx-auto mt-10 p-4 bg-white shadow-lg rounded-lg">
      <h1 className="text-3xl font-bold mb-6 text-center">Your Cart</h1>
      {cartItems.length === 0 ? (
        <p className="text-center">Your cart is empty.</p>
      ) : (
        <div>
          {cartItems.map((item, index) => (
            <CartCard key={index} item={item} onQuantityChange={handleQuantityChange} />
          ))}
          {stockStatus && (
            <div className="text-red-500 mb-4 text-center">
              {stockStatus.message}
            </div>
          )}
          <div className="flex justify-end mt-6">
            <button
              className="bg-green-500 hover:bg-green-700 text-white font-bold py-2 px-6 rounded"
              onClick={handlePlaceOrder}
            >
              Place Order
            </button>
          </div>
        </div>
      )}
      {showOrderForm && (
        <DeliveryForm
          onSubmit={() => {}}
          onProvinceChange={handleProvinceChange}
          onRushOrderChange={handleRushOrderChange}
        />
      )}
      {showOrderForm && selectedProvince && (
        <div className="mt-4 text-center">
          <p className="text-lg font-semibold">Shipping Fee: {shippingFee} k</p>
        </div>
      )}
      <div className="mt-4 text-center">
        <Link to="/" className="text-blue-500 hover:text-blue-700 text-3xl">Continue Shopping</Link>
      </div>
    </div>
  );
};

export default Cart;
