import React, { useState, useEffect, useContext } from 'react';
import { useParams, useLocation } from 'react-router-dom';
import productApi from '../api/productApi';
import { CartContext } from '../context/CartContext';
const ProductDetail = () => {
    const location = useLocation();
    const { item } = location.state; //product entity
    // console.log(item)
    const { id } = useParams(); // Lấy id từ URL
    const [productDetail, setProductDetail] = useState(null);
    const [loading, setLoading] = useState(true);
    const [quantity, setQuantity] = useState(1); // Default quantity is 1
    
    const { addToCart } = useContext(CartContext);
    const handleAddToCart = () => {
        addToCart(item.productId, quantity);
    };

    useEffect(() => {
        const fetchProductDetail = async () => {
            try {
                const response = await productApi.getProductDetail(id);
                setProductDetail(response.data);
                setLoading(false);
            } catch (error) {
                console.error('Error fetching product detail:', error);
            }
        };

        fetchProductDetail();
    }, [id]); // Khi id thay đổi, useEffect sẽ được gọi lại

    if (loading) {
        return <p className="text-center mt-4">Loading...</p>;
    }

    // Hàm render thông tin sản phẩm theo loại
    const renderProductInfo = () => {
        const { product, book, cd, dvd, lp } = productDetail;

        return (
            <div className="max-w-4xl mx-auto px-4 py-8">
                <h2 className="text-3xl font-bold mb-4 content-center text-center">{product.title}</h2>
                <div className="grid grid-cols-1 md:grid-cols-2 gap-8 mt-10">
                    <div>
                        <img src={product.image} alt={product.title} className="w-full h-auto mb-4" />
                    </div>
                    <div>
                        <p className="text-gray-600 text-lg mb-2">Category: {product.categoryName}</p>
                        <p className="text-gray-600 text-lg mb-2">Value: {product.value} k</p>
                        <p className="text-gray-600 text-lg mb-2">Current Price: {product.currentPrice} k</p>
                        <p className="text-gray-600 text-lg mb-2">Barcode: {product.barcode}</p>
                        <p className="text-gray-600 text-lg mb-2">Description: {product.description}</p>
                        <p className="text-gray-600 text-lg mb-2">Quantity: {product.quantity}</p>
                        <p className="text-gray-600 text-lg mb-2">Warehouse Entry Date: {product.warehouseEntryDate}</p>
                        <p className="text-gray-600 text-lg mb-2">Dimensions: {product.dimensions}</p>
                        <p className="text-gray-600 text-lg mb-2">Weight: {product.weight}</p>
                        <p className="text-gray-600 text-lg mb-2">Rush Order Support: {product.rushOrderSupport ? 'Yes' : 'No'}</p>

                        {book && (
                            <div>
                                <h3 className="text-xl font-bold mt-4 mb-2">Book Details</h3>
                                <p className="text-gray-600 text-lg mb-2">Author: {book.authorName}</p>
                                <p className="text-gray-600 text-lg mb-2">Cover Type: {book.coverType}</p>
                                <p className="text-gray-600 text-lg mb-2">Publisher: {book.publisherName}</p>
                                <p className="text-gray-600 text-lg mb-2">Publication Date: {book.publicationDate}</p>
                                <p className="text-gray-600 text-lg mb-2">Number of Pages: {book.numberOfPages}</p>
                                <p className="text-gray-600 text-lg mb-2">Language: {book.lang}</p>
                                <p className="text-gray-600 text-lg mb-2">Genre: {book.genre}</p>
                            </div>
                        )}

                        {cd && (
                            <div>
                                <h3 className="text-xl font-bold mt-4 mb-2">CD Details</h3>
                                <p className="text-gray-600 text-lg mb-2">Artist: {cd.artist}</p>
                                <p className="text-gray-600 text-lg mb-2">Record Label: {cd.recordLabel}</p>
                                <p className="text-gray-600 text-lg mb-2">Tracklist: {cd.tracklist}</p>
                                <p className="text-gray-600 text-lg mb-2">Release Date: {cd.releaseDate}</p>
                            </div>
                        )}

                        {dvd && (
                            <div>
                                <h3 className="text-xl font-bold mt-4 mb-2">DVD Details</h3>
                                <p className="text-gray-600 text-lg mb-2">Director: {dvd.director}</p>
                                <p className="text-gray-600 text-lg mb-2">Disc Type: {dvd.discType}</p>
                                <p className="text-gray-600 text-lg mb-2">Runtime: {dvd.runtime}</p>
                                <p className="text-gray-600 text-lg mb-2">Studio: {dvd.studio}</p>
                                <p className="text-gray-600 text-lg mb-2">Language: {dvd.lang}</p>
                                {dvd.subtitles && <p className="text-gray-600 text-lg mb-2">Subtitles: {dvd.subtitles}</p>}
                                <p className="text-gray-600 text-lg mb-2">Release Date: {dvd.releaseDate}</p>
                                <p className="text-gray-600 text-lg mb-2">Genre: {dvd.genre}</p>
                            </div>
                        )}

                        {lp && (
                            <div>
                                <h3 className="text-xl font-bold mt-4 mb-2">LP Details</h3>
                                <p className="text-gray-600 text-lg mb-2">Artist: {lp.artist}</p>
                                <p className="text-gray-600 text-lg mb-2">Record Label: {lp.recordLabel}</p>
                                <p className="text-gray-600 text-lg mb-2">Tracklist: {lp.tracklist}</p>
                                <p className="text-gray-600 text-lg mb-2">Release Date: {lp.releaseDate}</p>
                            </div>
                        )}
                    </div>
                </div>
            </div>
        );
    };

    return (
        <div>
            <h1 className="text-4xl font-bold text-center mb-8 mt-10">Product Detail</h1>
            <div>

                {renderProductInfo()}
                <div className="mt-4 flex justify-center items-center">
                    <input
                        className="shadow appearance-none border rounded w-24 py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                        type="number"
                        min="1"
                        value={quantity}
                        onChange={(e) => setQuantity(parseInt(e.target.value))}
                    />
                    <button
                        className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 ml-4 rounded focus:outline-none focus:shadow-outline"
                        onClick={handleAddToCart}
                    >
                        Add to Cart
                    </button>
                </div>
            </div>

        </div>
    );
};

export default ProductDetail;
