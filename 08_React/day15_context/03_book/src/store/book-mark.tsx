"use client";

import { Book } from "@/types/book";
import { createContext, ReactNode, useCallback, useContext, useMemo, useState } from "react";

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

    const insert = useCallback((book: Book) => {
        setBooks((pre) => {
            const exist = pre.find((b) => b.isbn === book.isbn);
            if (exist) return pre;
            return [...pre, book];
        });
    },[]);

    const remove = useCallback((isbn: string) => {
        setBooks(books.filter((b) => b.isbn != isbn));
    }, []);

    const removeAll = useCallback(() => {
        setBooks([]);
    }, []);

    const returnValue = useMemo(
        () => ({ books, insert, remove, removeAll }),
        [books]
    );

    // return <BookMarkContent.Provider value={{books, insert, remove, removeAll}}>
    //     {children}
    // </BookMarkContent.Provider>
    
    /*
        BookMarkContent.Provider의 value로 넘기는 객체의 참조값이 books가 바뀔 때만 변경되도록 
        위의 코드처럼 작성하면 렌더링될 때마다 value 객체가 새로 만들어져, 그 컨텍스트를 사용하는 하위 컴포넌트들이 불필요하게 리렌더링 됨.
        
        반면, useMemo로 묶어서 참조값이 안정적으로 유지되도록 하여 불필요한 리렌더 방지하여 성능 최적화

        => 
    */
    return <BookMarkContent.Provider value={returnValue}>
        {children}
    </BookMarkContent.Provider >
        
};

/////todo4 커스텀 훅: useMemberContext
export const useBookMarkContext =() => {
    const context = useContext(BookMarkContent);

    if (!context) {
        throw new Error("useBookMarkContext must be used within a BookMarkProvider")
    }

    return context;
}
