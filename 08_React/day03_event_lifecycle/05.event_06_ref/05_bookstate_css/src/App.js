import { useState } from "react";
import "./App.css";
import Books from "./Books.js";
import BookList from "./component/BookList";
import BookDetail from "./component/BookDetail.js";

function App() {
  const [books] = useState(Books);
  //디테일에 넘겨줄
  const [book, setBook] = useState(books[0]);
  return (
    <div className="container">
      <BookDetail book={book}></BookDetail>
      <BookList
        books={books}
        bookSelect={(selectBook) => {
          setBook(selectBook);
        }}
      ></BookList>
      {/* 북아이템에서 셀렉된 북의 정보를 가져오는 것. */}
    </div>
  );
}

export default App;