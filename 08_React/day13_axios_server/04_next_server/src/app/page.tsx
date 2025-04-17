import styles from "@/app/page.module.scss";
import ClientComponent from "@/components/books/ClientComponent";
import SelectBox from "@/components/common/SelectBox";
import { Book } from "@/types/book";
import { localAxios } from "@/utils/http-commons";
import { resolve } from "path";

/*
  SSR로 axios 통신 하기
  1. Component 선언부에 async를 선언해야 한다.
  2. use client 선언하면 안된다
  3. useXXXX [ex) useState, useRef,,] 사용하면 안된다.
  4. 선언한 함수를 컴포넌트의 속성으로 전달하면 안된다 ==? hydration 이므로 안됨.

*/
export default async function Home() {
  const axios = localAxios();

  //Home을 async로 선언했기 때문에 ServerComponent이므로 useXXX 사용하면 에러 발생
  
  const getBooks = async () => {
    console.log("fetch getBooks...............", Date.now());
    await new Promise((resolve) => setTimeout(resolve, 5000)); //5초 동안 로딩
    const response = await axios.get("/book");
    //SSR이므로 console.log는 브라우저에 출력되지 않고 terminal에 출력
    console.log(response.data);
    return response.data.books;
  };
  
  const getBook = async () => {
      console.log("fetch getBooks...............", Date.now());
      await new Promise((resolve) => setTimeout(resolve, 5000)); //5초 동안 로딩
      const response = await axios.get("/book/2025-04-15");
      //SSR이므로 console.log는 브라우저에 출력되지 않고 terminal에 출력
      console.log(response.data);
      return response.data;
  };

  const options = [
    { value: "all", text: "---선택하세요---" },
    { value: "title", text: "제목" },
    { value: "author", text: "작성자" },
  ];

  const handleSelect = (key: string) => {
    console.log("key.....", key);
  };

  // const books: Book[] = await getBooks();  5초
  // const book : Book = await getBook();     5초 => 총 10초 기다림림
  const [books, book] = await Promise.all([getBooks(), getBook()]); // 동시에 둘다 실행, 총 5초 소요

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>Home</h1>
      <h1 className={styles.title}>{JSON.stringify(books)}</h1>
      <h1 className={styles.title}>{JSON.stringify(book)}</h1>
      {/* Server Component에서는 자식 컴포넌트에 속성으로 함수를 전달할 수 없다. (이 아래 handleSelect 함수를 속성으로 넣으면 에러남)
        <h1 className={styles.title}>
          <SelectBox selectOptions={options} onKeySelect={handleSelect} />
        </h1> */}
      <h1 className={styles.title}>
        {/* client component를 import해서 사용하는 것은 가능 */}
        <ClientComponent />
      </h1>
    </div>
  );
}
