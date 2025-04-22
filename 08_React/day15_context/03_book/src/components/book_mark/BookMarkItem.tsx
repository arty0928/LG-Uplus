"use client";

import { useBookMarkContext } from '@/store/book-mark';
import { Book } from '@/types/book';
import Link from 'next/link';
import React, { useCallback } from 'react'

export default function BookMarkItem({book} : {book : Book}) {

  const { books, remove } = useBookMarkContext();

  const handleBookMarkRemove = useCallback(() => {
    remove(book.isbn);
    alert("선택한 북마크가 삭제되었습니다.");
  }, [books]);
  

  return (
      <tr className="book-row">
        <td>
          <img src={`/assets/images/${book.img}`} className="book-thumbnail" />
        </td>
        <td>{book.isbn}</td>
        <td>
          <Link href={`/books/${book.isbn}`}>{book.title}</Link>
        </td>
        <td>{book.author}</td>
        <td>{book.price}</td>
        <td>
          <button className="select-button" onClick={handleBookMarkRemove}>삭제</button>
        </td>
      </tr>
    
  )
}


