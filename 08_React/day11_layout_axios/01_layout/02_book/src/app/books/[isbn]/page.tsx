"use client";

import React, { useCallback, useRef, useState } from 'react';
import { Book } from "@/types/book";
import styles from './detail.module.scss';

const BookDetail = ({ params: { isbn } }: { params: { isbn: string } }) => {
    
    //isEditMode : false readOnly,  true !readOnly 
    const [isEditMode, setIsEditMode] = useState(false);

    //입력 form에 ref 달기 위해 선언 (양방향)
    const titleRef = useRef<HTMLInputElement>(null);
    const authorRef = useRef<HTMLInputElement>(null);
    const priceRef = useRef<HTMLInputElement>(null);
    const describRef = useRef<HTMLTextAreaElement>(null);

    const handleUpdate = useCallback(() => {
        
        if (isEditMode) {
            //edit mode에서 수정버튼을 클릭했다면 
            //필수 입력 값 검증
            const title = titleRef.current?.value.trim() || ""; 
            const author = authorRef.current?.value.trim() || ""; 
            
            // title 데이터가 없다면
            if (!title) {
                alert("제목을 입력하세요")
                titleRef.current?.focus();
                return;
            }

            if (!author) {
                alert("저자를 입력하세요")
                authorRef.current?.focus();
                return;
            }

            const updateBook: Book = {
                isbn,
                title,
                author,
                price: Number(priceRef.current?.value || '0'),
                describ: describRef.current?.value || "",
                img: ''
            };
            console.log(updateBook);
        }

        // 수정 모드 토글
        setIsEditMode((prev) => !prev);
    }, [isEditMode]);

    return (
        <div className={styles.container}>
            <h2 className={styles.title}>도서 상세 정보</h2>
            <table className={styles.table}>
                <tbody>
                    <tr>
                        <td>책 일련 번호</td>
                        <td>
                            <input
                                className={styles.readonly}
                                type="text"
                                name="isbn"
                                value={isbn}
                                readOnly
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td>
                            <input
                                className={`${!isEditMode ? styles.readonly : styles.input}`}
                                ref={titleRef}
                                type="text"
                                name="title"
                                readOnly={!isEditMode}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>저자</td>
                        <td>
                            <input
                                className={`${!isEditMode ? styles.readonly : styles.input}`}
                                ref={authorRef}
                                type="text"
                                name="author"
                                readOnly={!isEditMode}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td>가격</td>
                        <td>
                            <input
                                className={`${!isEditMode ? styles.readonly : styles.input}`}
                                ref={priceRef}
                                type="number"
                                name="price"
                                readOnly={!isEditMode}
                            />
                        </td>
                    </tr>
                </tbody>
            </table>

            <div className={styles.infoLabel}>책 정보</div>
            <textarea
                name="describ"  // 변수명은 유지하지만 실제 데이터 처리할 땐 description 등 권장
                ref={describRef}
                className={`${styles.textarea} ${!isEditMode ? styles.treadonly : ""}`}
                readOnly={!isEditMode}
            ></textarea>

            <div className={styles.buttonGroup}>
                <button onClick={handleUpdate}>
                    {isEditMode ? "저장" : "수정"}
                </button>
                <button>삭제</button>
            </div>
        </div>
    );
};

export default BookDetail;
