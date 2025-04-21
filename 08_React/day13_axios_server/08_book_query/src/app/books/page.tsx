"use client";
import styles from "@/app/books/book.module.scss";
import SelectBox from "@/components/common/SelectBox";
import Link from "next/link";
import BookItem from "@/components/books/BookItem";
import React, { useCallback, useEffect, useRef, useState } from "react";
import { localAxios } from "@/utils/http-commons";
import { Book, BookSearchParams } from "@/types/book";
import { handleApi } from "@/utils/handleApi";
import { searchAllBooks } from "@/service/books";
import { useQuery } from "@tanstack/react-query";
// metadata는 server component
// export const metadata = {
//   title: "Book List",
// };
export default function Books() {
  ////////////////////////todo5. 검색을 위한 상태 선언하기
  const [selectedKey, setSelectedKey] = useState<string>("all");
  ////////////////////////todo6. input(검색어)을 위한 ref 선언하기
  const wordRef = useRef<HTMLInputElement>(null);

  const options = [
    { value: "all", text: "---선택하세요---" },
    { value: "title", text: "제목" },
    { value: "author", text: "작성자" },
  ];
  /////////////todo1. useQuery를 다시 수행 시키기 위한 상태 값 선언
  const [queryKeyState, setQueryKeyState] = useState({key:'all', word:''})

  ///////// todo2. useQuery 선언하기
  const { data: books = [], isLoading, error } = useQuery<Book[]>({
    queryKey: ["books", queryKeyState], // queryKeyState가 변하면 useQuery를 다시 수행시켜서 books를 갱신
    queryFn: ()=> searchAllBooks({key: queryKeyState.key, word: queryKeyState.word, pageNo: 1})
  });

  ////////////////////////todo7. SelectBox를 위한 함수 선언하기
  const handleSelect = useCallback(
    (key: string) => {
      console.log("key......", key);
      setSelectedKey(key);
    },
    [selectedKey]
  );
  ////////////////////////todo3. 
  const handleSearch = useCallback(() => {
    const word = wordRef.current?.value.trim() || "";
    setQueryKeyState({ key: selectedKey, word });
  }, [selectedKey]);

  ////////////////////////todo4. loading, error에 대한 화면
  if (isLoading) return <h1>Loading.....</h1>;
  if (error) return <h1>오류 발생 : {(error as Error).message}</h1>;

  /*
    {error.message} 와 뭐가 다르지?
        에러가 항상 Error 타입일 경우엔 문제 없이 동작합니다.
        하지만 TypeScript는 error의 타입을 unknown 또는 any로 추론하는 경우가 많아요.

        특히 try/catch나 useQuery의 error는 기본적으로 unknown 타입이에요.

        이 경우 error.message에 접근하려 하면 에러 발생:
  */

  return (
    <div className={styles.bookList}>
      <div className={styles.header}>
        <div className={styles.searchArea}>
          {/* todo8. SelectBox 사용하기  */}
          <SelectBox selectOptions={options} onKeySelect={handleSelect} />
          <input
            type="text"
            ref={wordRef}
            placeholder="검색어를 입력하세요"
            className={styles.searchInput}
          />
          {/* todo10. 버튼에 이벤트 달기 */}
          <button className={styles.searchButton} onClick={handleSearch}>
            검색
          </button>
        </div>
      </div>
      <table className={styles.table}>
        <thead>
          <tr>
            <th>이미지</th>
            <th>책 일련 번호</th>
            <th>제목</th>
            <th>저자</th>
            <th>가격</th>
          </tr>
        </thead>
        <tbody>
          {books?.map((book) => (
            <BookItem key={book.isbn} book={book} />
          ))}
        </tbody>
      </table>

      <div className={styles.pagination}>
        <button>이전</button>
        <button>다음</button>
      </div>
    </div>
  );
}
