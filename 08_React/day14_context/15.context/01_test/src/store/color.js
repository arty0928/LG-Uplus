import React, { createContext, useContext, useState } from "react";

/////todo1. createContext()함수로 제공할 context(관리할 state, state를 변경할 함수)를 생성하기
const ColorContext = createContext({
    color: "black", 
    subcolor: "red",
    changeColor: () => { },
    changeSubColor : () => {}
});

/////todo3. 타입에 해당하는 구현부를 Provider로 작성해서 리턴하기
///// type에서 선언한 상태와 함수를 value에 필수로 작성하기
export const ColorProvider = ({ children }) => {
    const [color, setColor] = useState("black");
    const [subcolor, setSubcolor] = useState("red");

    const changeColor = (c) => {
        setColor(c);
    };

    const changeSubColor = (c) => {
        setSubcolor(c);
    };

    return (
        <ColorContext.Provider value={{ color, subcolor, changeColor, changeSubColor }}>
            {children}
        </ColorContext.Provider> //{필수} 만든 context를 사용하기위해서는 provider를 전달해줘야, 가운데는 children
    )
};

/////todo4. 사용하기 편하도록 커스텀 훅을 만들기
///// error 처리도 함께하기
export const useColorContext = () => {
    const context = useContext(ColorContext);
    if (!context) {
        throw new Error("ColorContext must be used within a ColorProvider");
    }
    return context;
};

