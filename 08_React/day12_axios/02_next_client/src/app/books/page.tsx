"use client";
import styles from "@/app/books/book.module.scss";
import SelectBox from "@/components/common/SelectBox";
import Link from "next/link";
import BookItem from "@/components/books/BookItem";
import React, { useEffect, useRef, useState } from "react";
import { localAxios } from "@/util/http-commons";
import { Book, BookSearchParams } from "@/types/book";
// metadata는 server component
// export const metadata = {
//   title: "Book List",
// };
export default function Books() {
  ////////////////////////todo1. 비동기 통신을 통해 전달 받을 데이타를 위한 상태 선언하기
  /// books, loading, error

  ////////////////////////todo5. 검색을 위한 상태 선언하기

  ////////////////////////todo6. input(검색어)을 위한 ref 선언하기
  const books = [
    {
      isbn: "9917-1",
      title: "처음하는 리액트",
      author: "ureca",
      price: 30000,
      describ: "",
      img: "domain.jpg",
    },
  ];

  const options = [
    { value: "all", text: "---선택하세요---" },
    { value: "title", text: "제목" },
    { value: "author", text: "작성자" },
  ];

  ////////////////////////todo2. axios를 이용해 book 목록을 가져올 함수 선언하기

  ////////////////////////todo3. useEffect로 비동기 통신 함수 호출하기

  ////////////////////////todo7. SelectBox를 위한 함수 선언하기

  ////////////////////////todo4. loading, error에 대한 화면

  ////////////////////////todo9. 검색 버튼을 위한 이벤트 처리 함수 만들기
  return (
    <div className={styles.bookList}>
      <div className={styles.header}>
        <div className={styles.searchArea}>
          {/* todo8. SelectBox 사용하기  */}

          <input
            type="text"
            ref={wordRef}
            placeholder="검색어를 입력하세요"
            className={styles.searchInput}
          />
          {/* todo10. 버튼에 이벤트 달기 */}
          <button className={styles.searchButton}>검색</button>
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
