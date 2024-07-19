import React, { createContext, useState } from 'react';
import productApi from '../api/productApi';

export const CartContext = createContext();

export const CartProvider = ({ children }) => {
  const [cartItems, setCartItems] = useState([]);
  const [stockStatus, setStockStatus] = useState(null);

  const addToCart = (productId, addedQuantity) => {
    setCartItems((prevItems) => {
      const existingItem = prevItems.find((item) => item.productId === productId);
      if (existingItem) {
        return prevItems.map((item) =>
          item.productId === productId
            ? { ...item, addedQuantity: item.addedQuantity + addedQuantity }
            : item
        );
      } else {
        return [...prevItems, { productId, addedQuantity }];
      }
    });
  };

  const updateCartItemQuantity = (productId, quantity) => {
    setCartItems((prevItems) => 
      prevItems.map((item) =>
        item.productId === productId
          ? { ...item, addedQuantity: quantity }
          : item
      )
    );
  };

  const removeFromCart = (productId) => {
    setCartItems((prevItems) => 
      prevItems.filter((item) => item.productId !== productId)
    );
  };

  const checkStock = async () => {
    for (let item of cartItems) {
      const response = await productApi.getProductStock(item.productId);
      const availableQuantity = response.data.quantity;
      if (item.addedQuantity > availableQuantity) {
        setStockStatus({ productId: item.productId, message: `Not enough stock` });
        return false;
      }
    }
    setStockStatus(null);
    return true;
  };

  return (
    <CartContext.Provider
      value={{
        cartItems,
        addToCart,
        updateCartItemQuantity,
        removeFromCart,
        checkStock,
        stockStatus,
      }}
    >
      {children}
    </CartContext.Provider>
  );
};
