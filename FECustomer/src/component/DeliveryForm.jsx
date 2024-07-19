import React, { useEffect, useState, useContext } from 'react';
import provinceApi from '../api/provinceApi';
import productApi from '../api/productApi';
import { CartContext } from '../context/CartContext';

const DeliveryForm = ({ onSubmit, onProvinceChange, onRushOrderChange }) => {
  const{cartItems} = useContext(CartContext);
  
  const [provinces, setProvinces] = useState([]);
  const [selectedProvince, setSelectedProvince] = useState('');
  const [recipientName, setRecipientName] = useState('');
  const [email, setEmail] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [address, setAddress] = useState('');
  const [rushOrder, setRushOrder] = useState(false);
  const [formValid, setFormValid] = useState(false);
  const [rushOrderItems, setRushOrderItems] = useState([]);
  console.log(rushOrderItems)
  const [regularItems, setRegularItems] = useState([]);


  useEffect(() => {
    const fetchProvinces = async () => {
      try {
        const response = await provinceApi.getAllProvinces();
        setProvinces(response.data);
      } catch (error) {
        console.error('Error fetching provinces:', error);
      }
    };

    fetchProvinces();
  }, []);

  // Function to handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    if (formValid) {
      onSubmit({
        recipientName,
        email,
        phoneNumber,
        address,
        selectedProvince,
        rushOrder,
      });
    } else {
      alert('Please fill in all fields before submitting.');
    }
  };

  const handleRushOrderChange = async (isRushOrder) => {
    setRushOrder(isRushOrder);

    // Separate rush order items and regular items
    const rushOrderItems = [];
    const regularItems = [];

    for (const item of cartItems) {
      const response = await productApi.getProduct(item.productId);
      if (response.data.rushOrderSupport) {
        rushOrderItems.push(response.data.title);
      } else {
        regularItems.push(response.data.title);
      }
    }

    setRushOrderItems(rushOrderItems);
    setRegularItems(regularItems);

    // Callback to parent component if needed
    onRushOrderChange(isRushOrder);
  };

  // Function to validate form fields
  useEffect(() => {
    const isFormValid =
      recipientName !== '' &&
      email !== '' &&
      phoneNumber !== '' &&
      address !== '' &&
      selectedProvince !== '';

    setFormValid(isFormValid);
  }, [recipientName, email, phoneNumber, address, selectedProvince]);

  return (
    <div className="mt-10 p-4 bg-gray-100 rounded-lg">
      <h2 className="text-2xl font-bold mb-4">Delivery Form</h2>
      <form className="space-y-4" onSubmit={handleSubmit}>
        <div>
          <label className="block text-gray-700">Recipient Name</label>
          <input
            type="text"
            className="w-full p-2 border border-gray-300 rounded"
            required
            value={recipientName}
            onChange={(e) => setRecipientName(e.target.value)}
          />
        </div>
        <div>
          <label className="block text-gray-700">Email</label>
          <input
            type="email"
            className="w-full p-2 border border-gray-300 rounded"
            required
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
        <div>
          <label className="block text-gray-700">Phone Number</label>
          <input
            type="text"
            className="w-full p-2 border border-gray-300 rounded"
            required
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
          />
        </div>
        <div>
          <label className="block text-gray-700">Address</label>
          <input
            type="text"
            className="w-full p-2 border border-gray-300 rounded"
            required
            value={address}
            onChange={(e) => setAddress(e.target.value)}
          />
        </div>
        <div>
          <label className="block text-gray-700">Province</label>
          <select
            className="w-full p-2 border border-gray-300 rounded"
            value={selectedProvince}
            onChange={(e) => {
              setSelectedProvince(e.target.value);
              onProvinceChange(e.target.value);
            }}
            required
          >
            <option value="" disabled>Select a province</option>
            {provinces.map((province) => (
              <option key={province.provinceId} value={province.provinceName}>
                {province.provinceName}
              </option>
            ))}
          </select>
        </div>
        <div className="flex items-center">
          <input
            type="checkbox"
            className="mr-2 leading-tight"
            id="rushOrder"
            checked={rushOrder}
            onChange={(e) => {
              setRushOrder(e.target.checked);
              onRushOrderChange(e.target.checked);
              handleRushOrderChange(e.target.checked);
            }}
          />
          <label htmlFor="rushOrder" className="text-gray-700">
            Rush Order
          </label>
        </div>


            {/* Display rush order items if rushOrder is true */}
        {rushOrder && rushOrderItems.length > 0 && (
          <div>
            <h3 className="text-lg font-semibold mt-4">Rush Order Items:</h3>
            <ul>
              {rushOrderItems.map((item, index) => (
                <li key={index}>{item}</li>
              ))}
            </ul>
            {/* {rushOrderItems} */}
          </div>
        )}

        {/* Display regular items */}
        {regularItems.length > 0 && (
          <div>
            <h3 className="text-lg font-semibold mt-4">Regular Items:</h3>
            <ul>
              {regularItems.map((item, index) => (
                <li key={index}>{item}</li>
              ))}
            </ul>
            {/* {regularItems} */}
          </div>
        )}


        <button
          type="submit"
          className={`w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded ${formValid ? '' : 'opacity-50 cursor-not-allowed'}`}
          disabled={!formValid}
        >
          Submit Order
        </button>
      </form>
    </div>
  );
};

export default DeliveryForm;
