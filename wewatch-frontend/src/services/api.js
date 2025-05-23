import axios from "axios";

const API_URL = "http://localhost:8080/api";


const api = axios.create({
    baseURL: API_URL,
    headers : {
        "Content-Type" : "application/json",
    },
});

api.interceptors.request.use(
    (config) => {
      const token = localStorage.getItem("authToken");
      if (token && token !== "null") {
        config.headers.Authorization = `Bearer ${token}`;
      }
      return config;
    },
    (error) => Promise.reject(error)
  );

export default api;

