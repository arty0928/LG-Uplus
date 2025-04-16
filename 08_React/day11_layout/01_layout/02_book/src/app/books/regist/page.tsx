"use client";

import React, { useCallback, useRef } from 'react';
import  styles  from './regist.module.scss';
import { Book } from '@/types/book';
import { useRouter } from 'next/navigation';

const BookRegister = () => {

    const isbnRef = useRef<HTMLInputElement>(null); 
    const titleRef = useRef<HTMLInputElement>(null);
    const authorRef = useRef<HTMLInputElement>(null);
    const priceRef = useRef<HTMLInputElement>(null);
    const describRef = useRef<HTMLInputElement>(null);
    const router = useRouter(); //라우터에 어디로 이동할지 push

    const handleSudmit = useCallback(() => {

        const title = titleRef.current?.value.trim() || "";
        const author = authorRef.current?.value.trim() || "";
        const isbn = isbnRef.current?.value.trim() || "";

        if (!isbn) {
            alert("일련 번호를 입력하세요");
            isbnRef.current?.focus();
            return;
        }

        if (!title) {
            alert("제목을 입력하세요");
            titleRef.current?.focus();
            return;
        }

        if (!author) {
            alert("저자를 입력해주세요.");
            authorRef.current?.focus();
            return;
        }

        const registBook: Book = {
            isbn,
            title,
            author,
            price: Number(priceRef.current?.value || '0'),
            describ: describRef.current?.value || "",
            img: ''
        }
        console.log(registBook);
        router.push("/books");
      
    },[]);
    
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
            <button onClick={handleSudmit}>등록</button>
        </div>
        </div>

    );
};

export default BookRegister;
