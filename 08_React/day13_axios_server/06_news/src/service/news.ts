import { Article } from "@/types/news";
import axios from "axios";

const BASE_URL = "https://newsapi.org/v2/everything?q=한국&language=ko&sortBy=publishedAt&apiKey=6d7f6d72a8d74df8b2c3928638d2f8b8";
export const fetchNews = async (): Promise<Article[]> => {
    const response = await axios.get(BASE_URL);
    console.log(response.data.articles);
    return response.data.articles;
};

