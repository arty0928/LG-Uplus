import React, { createContext, useContext, useState } from "react";

/*
    context 사용 방법 (항상 동일)
        1. store에 context 선언, 선언, provider, hook 작성
        2. 사용하는 부분을 provider로 감싸기
        3. 사용 시 hook을 통해 사용
    
    context 의 단점:
        F5를 누르거나 브라우저를 껐다 켜면 새로고침 되어 앱이 다시 시작되어 context에 선언된 기본값으로 돌아감 
        -> 만약 계속 유지하고 싶다면 sessionStorage 혹은 localStorage에 저장해야 함
*/


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

