
//맨 상단에 뜨는 상세 화면을 만들것임.

import React from "react";
import "../styles/BookDetail.css";

const BookDetail = ({ book }) => {
  return (
    <div className="book-card">
      <img
        src={require(`../assets/images/${book.img}`)}
        alt={book.title}
        className="book-image"
      ></img>
      <div className="book-info">
        <h2 className="book-title">{book.title}</h2>
        <h4 className="author">{book.author}</h4>
        <h4 className="price">{book.price}</h4>
      </div>
    </div>
  );
};

export default BookDetail;