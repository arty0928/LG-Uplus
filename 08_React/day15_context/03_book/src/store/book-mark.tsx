"use client";

import { Book } from "@/types/book";
import { createContext, ReactNode, useContext, useState } from "react";

/////todo1. 제공할 상태와 상태를 변경할 함수에 대한 타입 설정하기
interface BookMarkContextType{
    books: Book[];
    insert: (book: Book) => void
    remove: (isbn : string) => void
    removeAll : () => void
}

/////todo2. createContext()함수로 제공할 context를 생성하기
const BookMarkContent = createContext<BookMarkContextType | undefined>(undefined);

/////todo3. 타입에 해당하는 구현부를 Provider로 작성해서 리턴하기
/////type에서 선언한 상태와 함수를 value에 필수로 작성하기
export const BookMarkProvider = ({ children }: { children: ReactNode }) => {
    const [books, setBooks] = useState<Book[]>([]);

    const insert = (book: Book) => {
        setBooks((pre) => {
            const exist = pre.find((b) => b.isbn === book.isbn);
            if (exist) return pre;
            return [...pre, book];
        });
    };

    const remove = (isbn: string) => {
        setBooks(books.filter((b) => b.isbn != isbn));
    }

    const removeAll = () => {
        setBooks([]);
    }

    return <BookMarkContent.Provider value={{books, insert, remove, removeAll}}>
        {children}
    </BookMarkContent.Provider>
};

/////todo4 커스텀 훅: useMemberContext
export const useBookMarkContext =() => {
    const context = useContext(BookMarkContent);

    if (!context) {
        throw new Error("useBookMarkContext must be used within a BookMarkProvider")
    }

    return context;
}
