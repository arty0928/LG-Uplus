"use client";

import { Book } from "@/types/book";
import { createContext, ReactNode, useCallback, useContext, useEffect, useMemo, useState } from "react";

/////todo1. 제공할 상태와 상태를 변경할 함수에 대한 타입 설정하기
interface BookMarkContextType {
  books: Book[];
  loaded: boolean;
  registBookMark: (book: Book) => void;
  removeBookMark: (isbn: string) => void;
  clearBookMark: () => void;
}

/////todo2. createContext()함수로 제공할 context를 생성하기
const BookMarkContext = createContext<BookMarkContextType | undefined>(undefined);

/////todo3. 타입에 해당하는 구현부를 Provider로 작성해서 리턴하기
/////type에서 선언한 상태와 함수를 value에 필수로 작성하기
export const BookMarkProvider = ({ children }: { children: ReactNode }) => {
  const [books, setBooks] = useState<Book[]>([]);
  const [loaded, setLoaded] = useState<boolean>(false);

  // storage에 데이터가 있으면 load => 처음 1번만 load
  // loaded가 false 인 때는 : 새로고침했을 때, store에서 데이터를 가져오기 전까지
  // store에서 데이터를 가져오면 loaded가 true로 변함
  useEffect(() => {
    const store = localStorage.getItem("bookmark");

    if (store) {
      try {
        setBooks(JSON.parse(store));
      }
      catch {
        setBooks([]);
      }
    }
    setLoaded(true); //npm run dev하면 이때 처음 1번만 loaded가 true가 됨. isLoaded가 없으면 매번 useState로 갱신
  }, []);
  
  // useEffect(()=> {  }) => 이렇게 되면 매번 업데이트
  
  // books의 상태가 변하면 storage에 저장
  useEffect(() => {
    if (loaded) {
      localStorage.setItem("bookmark", JSON.stringify(books));
    }
  }, [books, loaded]);

  const registBookMark = useCallback((book: Book) => {
    setBooks((prev) => (prev.find((item) => item.isbn === book.isbn) ? prev : [...prev, book]));
  }, []);

  const removeBookMark = useCallback((isbn: string) => {
    setBooks((prev) => prev.filter((item) => item.isbn !== isbn));
  }, []);

  const clearBookMark = useCallback(() => {
    setBooks([]);
  }, []);

  const returnValue = useMemo(
    () => ({ books, loaded, registBookMark, removeBookMark, clearBookMark }),
    [books, loaded]);
  return <BookMarkContext.Provider value={returnValue}>{children}</BookMarkContext.Provider>;
};

/////todo4 커스텀 훅: useBookMarkContext 
// provider로 항상 감싸줘야 하는데 매번 하기 귀찮으니 custome hook으로 provider를 감싼 BookMarkContext를 반환
export const useBookMarkContext = () => {
  const context = useContext(BookMarkContext);
  if (!context) throw new Error("useBookMarkContext는 BookMarkProvider 안에서 사용할 수 있다.");
  return context;
};
