import axiosClient from "./axiosClient";

const PREFIX = "/provinces";

const provinceApi = {

    getAllProvinces: () => {
        const url = `${PREFIX}`
        return axiosClient.get(url)
    }
    
};  

export default provinceApi;