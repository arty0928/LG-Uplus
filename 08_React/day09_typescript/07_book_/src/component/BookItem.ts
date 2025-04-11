import "./BookItem.scss";
import { Book } from '../types/book';
import { useCallback } from "react";

interface BookItemProps {
  book: Book;
  bookSelect: (book: Book) => void;
}

const BookItem = ({ book, bookSelect } : BookItemProps) => {
  
  const handleSelect = useCallback(() => {
    bookSelect(book);
  }, [book, bookSelect]);

  return (
    <tr className="book-row">
      <td>
        <img
          src={require(`../assets/images/${book.img}`)}
          alt={book.title}
          className="book-thumbnail"
        />
      </td>
      <td>{book.title}</td>
      <td>{book.price}</td>
      <td>{book.author}</td>
      <td>
        <button className="select-button" onClick={() => bookSelect(book)}>
          선택
        </button>
      </td>
    </tr>
  );
};

export default BookItem;
