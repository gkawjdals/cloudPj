import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api",
});

export const getSummaries = () => api.get("/summaries");
export const postSummary = (data) => api.post("/summaries", data);
