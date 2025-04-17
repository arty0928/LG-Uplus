import { handleApi } from "@/utils/handleApi";
import styles from "./news.module.scss";
import { fetchNews } from "@/service/news";
import { Article } from "@/types/news";
import NewsItem from "@/components/news/NewsItem";

export default async function NewsList() {


  const { data, error } = await handleApi(() => fetchNews());
  if (data) {
    return (
      <div className={styles.newsList}>
        {data.map((article: Article) => (
          <NewsItem key={article.url} article={article}/>
        ))}
      </div>
    );
  }
  else {
    return <div className={styles.newsList}>오늘의 뉴스가 없습니다.</div>;
  }
}