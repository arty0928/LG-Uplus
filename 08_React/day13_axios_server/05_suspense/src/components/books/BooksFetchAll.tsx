import { Book } from '@/types/book';
import { localAxios } from '@/utils/http-commons';
import React from 'react';
import styles from '@/app/page.module.scss';

const BooksFetchAll = async () => {
  const axios = localAxios();

  const getBooks = async () => {
    console.log("fetch getBooks...............", Date.now());
    await new Promise((resolve) => setTimeout(resolve, 5000)); //5초 동안 로딩
    const response = await axios.get("/book");
    //SSR이므로 console.log는 브라우저에 출력되지 않고 terminal에 출력
    console.log(response.data);
    return response.data.books;
  };
    
  const books: Book[] = await getBooks();  // 5초

    return <h1 className={styles.title}>{JSON.stringify(books)}</h1>;
};

export default BooksFetchAll;