"use client";
import React, { useCallback, useRef, useState } from "react";
import styles from "./regist.module.scss";
import { useRouter } from "next/navigation";
import { Book } from "@/types/book";
import { insertBook } from "@/service/books";
import { handleApi } from "@/utils/handleApi";
import { useMutation } from "@tanstack/react-query";
import { error } from "console";

const BookRegist = () => {
  const isbnRef = useRef<HTMLInputElement>(null);
  const titleRef = useRef<HTMLInputElement>(null);
  const authorRef = useRef<HTMLInputElement>(null);
  const priceRef = useRef<HTMLInputElement>(null);
  const describRef = useRef<HTMLTextAreaElement>(null);
  const router = useRouter();
  //todo1. useMutation에서 관리하므로 error state는 삭제
  //todo2. useMutation 작성
  const { mutate } = useMutation({
    mutationFn: insertBook,
    onSuccess: (data) => {
      alert(data)
      router.push("/books")
    },
    onError: (error) => {
      alert('등록 실패');
    },
  });

  const handleRegist = useCallback(async () => {
    const isbn = isbnRef.current?.value.trim() || "";
    const title = titleRef.current?.value.trim() || "";
    const author = authorRef.current?.value.trim() || "";
    if (!isbn) {
      alert("책 일련 번호를 입력하세요");
      isbnRef.current?.focus();
      return;
    }
    if (!title) {
      alert("제목을 입력하세요");
      titleRef.current?.focus();
      return;
    }
    if (!author) {
      alert("저자를 입력하세요");
      authorRef.current?.focus();
      return;
    }
    const book: Book = {
      isbn,
      title,
      author,
      price: Number(priceRef.current?.value || "0"),
      describ: describRef.current?.value || "",
      img: "",
    };
    //todo3. mutate 실행
    mutate(book)
  }, [mutate]); //[]안에 감시할 대상 넣기

  // todo4. error는 userMutation 에서 처리했으므로 삭제
  // if (error) return <h1>{error}</h1>;
  
  return (
    <div className={styles.container}>
      <h2 className={styles.title}>도서 등록</h2>
      <table className={styles.table}>
        <tbody>
          <tr>
            <td>책 일련 번호</td>
            <td>
              <input type="text" ref={isbnRef} name="isbn" />
            </td>
          </tr>
          <tr>
            <td>제목</td>
            <td>
              <input type="text" ref={titleRef} name="title" />
            </td>
          </tr>
          <tr>
            <td>저자</td>
            <td>
              <input type="text" ref={authorRef} name="author" />
            </td>
          </tr>
          <tr>
            <td>가격</td>
            <td>
              <input type="text" ref={priceRef} name="price" />
            </td>
          </tr>
        </tbody>
      </table>

      <div className={styles.infoLabel}>책 정보</div>
      <textarea name="describ" ref={describRef} className={styles.textarea}></textarea>

      <div className={styles.buttonGroup}>
        <button onClick={handleRegist}>등록</button>
      </div>
    </div>
  );
};

export default BookRegist;
