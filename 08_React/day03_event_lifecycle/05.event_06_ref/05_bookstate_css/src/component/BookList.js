// rsc
import React from "react";
import "../styles/BookList.css";
import BookItem from "./BookItem";

//app에 있는 book정보를 받아와야하니까
const BookList = ({ books, bookSelect }) => {
  return (
    <table className="book-table">
      <thead>
        <tr className="book-header">
          <th>이미지</th>
          <th>제목</th>
          <th>가격</th>
          <th>저자</th>
          <th>비고</th>
        </tr>
      </thead>
      <tbody>
        {/* 아이템을 반복하면서 사용할거니까 map을 이용하면 된다. */}
        {books.map((book) => (
          <BookItem key={book.isbn} book={book} bookSelect={bookSelect}></BookItem>
        ))}
      </tbody>
    </table>
  );
};

export default BookList;