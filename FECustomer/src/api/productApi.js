import axiosClient from "./axiosClient";

const PREFIX = "/products";

const productApi = {
    random20Products: () => {
        const url = `${PREFIX}/random`;
        return axiosClient.get(url);
    },
    getProduct: (id) => {
        const url = `${PREFIX}/${id}`
        return axiosClient.get(url)
    },
    getProductDetail: (id) => {
        const url = `${PREFIX}/detail/${id}`
        return axiosClient.get(url)
    },
    getProductStock: (id) => {
        const url = `${PREFIX}/stock/${id}`
        return axiosClient.get(url)
    }
    
};  

export default productApi;