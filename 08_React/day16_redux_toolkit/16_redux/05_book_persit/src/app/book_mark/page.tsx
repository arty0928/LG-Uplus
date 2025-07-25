"use client";

import styles from "./book_mark.module.scss";
import BookMarkItem from "@/components/book_mark/BookMarkItem";
import { useBookMark } from "@/store/hooks/bookmarkHook";
import React, { useCallback } from "react";

export default function Bookmark() {
  //////////TODO 18. 커스텀 훅을 통해 bookmark 상태와 clearBookMark함수 전달 받기
  const {bookMarkState, removeAllBookMark} = useBookMark();

  //////////TODO 20. 모두 삭제 버튼을 위한 이벤트 함수 작성하기
  const handleRemoveAllBookMark = useCallback(() => {
      removeAllBookMark();
  }, []);

  return (
    <div className={styles.bookList}>
      <div>
        {/* //////////TODO 21. 이벤트 등록하기  */}
        <button className={styles.registerButton} onClick={handleRemoveAllBookMark}>모두 삭제</button>
      </div>
      <table className={styles.table}>
        <thead>
          <tr>
            <th>이미지</th>
            <th>책 일련 번호</th>
            <th>제목</th>
            <th>저자</th>
            <th>가격</th>
            <th>비고</th>
          </tr>
        </thead>
        <tbody>{/* //////////TODO 19. bookmark 상태를 이용해서 bookmark  목록 만들기   */}</tbody>
        <tbody>
          {bookMarkState.length > 0 ? (
            bookMarkState.map((book) => <BookMarkItem key={book.isbn} book={book} />)
          ) : (
              <tr>
                <td colSpan={6} style={{textAlign : "center", padding: "1rem"}}>
                  북마크 내용이 비었습니다.
                </td>
            </tr>   
          )}
        </tbody>
      </table>

      <div className={styles.pagination}>
        <button>이전</button>
        <button>다음</button>
      </div>
    </div>
  );
}
