import { useCallback } from "react";
import { useAppDispatch, useAppSelector } from "../hooks"
import { Book } from "@/types/book";
import { insertBookMark, removeAllBookMark, removeBookMark } from "../slices/bookmarkSlice";

export const useBookMark = () => {
    //////////TODO B6. useAppDispatch 함수로 부터 dispatch 전달받기
    const dispatch = useAppDispatch();
    
    //////////TODO B7. useAppSelector 함수로 부터 books State 전달받기
    const bookMarkState = useAppSelector((state) => state.bookmark.books)

    //////////TODO B8. dispatch함수로 registBookMark  선언하기
    // const regist = useCallback((book: Book) => dispatch(insertBookMark(book)), [dispatch]);
    const safeInsertBookMark = (book: Book) => {
        const exists = bookMarkState.find((b) => b.isbn === book.isbn)
        if (exists) {
            alert("이미 북마크에 등록된 도서입니다.");
        } else {
            dispatch(insertBookMark(book));
            alert("북마크에 추가합니다.");
        }
    };

    //////////TODO B9. dispatch함수로 removeBookMark  선언하기
    const removew = useCallback((isbn: string) => dispatch(removeBookMark(isbn)), [dispatch]);

    //////////TODO B10. dispatch함수로 clearBookMark  선언하기
    const clearBookMark = useCallback(() => dispatch(removeAllBookMark()), [dispatch]);

    //////////TODO B11. 상태와 action 함수들 리턴하기
    return { bookMarkState, insertBookMark: safeInsertBookMark, removeBookMark: removew, removeAllBookMark: clearBookMark };
}