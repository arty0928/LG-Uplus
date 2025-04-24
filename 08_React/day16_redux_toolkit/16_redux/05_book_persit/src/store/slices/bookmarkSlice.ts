import { Book } from "@/types/book";
import { createSlice, PayloadAction } from "@reduxjs/toolkit";

//////////TODO B1.Bookmark state를 위한 타입 선언하기
interface BookMarkState {
    books: Book[];
}

//////////TODO B2. slice에서 사용할 초기값 선언하기
const initialState: BookMarkState = {
    books: [],
};

//////////TODO B3. slice선언하기   reducers[registBookMark, removeBookMark, clearBookMark]
const bookMarkSlice = createSlice({
    name: "bookmark",
    initialState,
    reducers: {
        
        //Action 정의하기 
        insertBookMark: (state, action: PayloadAction<Book>) => {
            // const exists = state.books.find((b) => b.isbn == action.payload.isbn);
            // if (!exists) {
            //     state.books.push(action.payload);
            // }
            state.books.push(action.payload);
        },

        removeBookMark: (state, action: PayloadAction<string>) => {
            state.books = state.books.filter((b) => b.isbn != action.payload);
        },

        removeAllBookMark: (state) => {
            state.books = [];
        },
    },
});

//////////TODO B4. slicer가 제공하는 action함수들 export 하기
export const { insertBookMark, removeBookMark, removeAllBookMark } = bookMarkSlice.actions;

//////////TODO B5. reducer export 하기
export default bookMarkSlice.reducer;