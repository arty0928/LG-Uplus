//이미지,제목, 가격, 저자, 비교 이렇게 있음.
//함수형 컴포넌트로 만들것임 rsc

//북에대한 정보를 받아올것음. book이라는 객체로 받아올 것.
/*
북을 선택했을때 디테일에서 변경이 되는 훅을 설정해야한다.
어떤 정보를 넘겨줘야할까? 북리스트는 북 정보를 가지고 있을꺼고, 선택버튼을 클릭했을때 props를 통해서 북 정보를 넘겨주는 작업을 진행해야함

북 아이템에서 선택한 정보가 app.js에 가게하고 app.js에서 디테일과 리스트에서 셀렉된거를 머시기머시기?
*/
import React from "react";
import "../styles/BookItem.css"; //스타일도 임포트하기

//props를 쉽게 쓰기위해 구조분해 할당할건데 인자로 받을때부터 구조분해 할당을 진행할 것.
const BookItem = ({ book, bookSelect }) => {
  return (
    <tr className="book-row">
      <td>
        {/* 원래 서버에서 받아오는건데 일단 지금 Books.js에 북 정보들이 저장되어있어서 img 이름을 가져오고 asset에서 그 이미지를 가져 올 것. */}
        <img
          className="book-thumbnail"
          src={require(`../assets/images/${book.img}`)}
          alt={book.title}
        />
      </td>
      <td>{book.title}</td>
      <td>{book.price}</td>
      <td>{book.author}</td>
      <td>
        <button
          className="select-button"
          onClick={() => {
            bookSelect(book);
          }}
        >
          선택하시오.
        </button>
      </td>
    </tr>
  );
};

export default BookItem;