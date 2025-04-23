import { Member } from "@/types/member";
import { createContext, ReactNode, useContext, useState } from "react";

/////todo1. 제공할 상태와 상태를 변경할 함수에 대한 타입 설정하기
interface MemberContextType{
    member: Member | null;
    login: (member: Member) => void;
    logout: () => void;
}

/////todo2. createContext()함수로 제공할 context를 생성하기
/*
    null이 아닌 undefined를 사용 이유: 더 안전하기 때문
        null      : 명시적으로 "없음"
        undefined : 값이 정의되지 않음
*/
// const MemberContext = createContext<MemberContextType | undefined>(undefined);
const MemberContext = createContext<MemberContextType | undefined>(undefined); 

/////todo3. 타입에 해당하는 구현부를 Provider로 작성해서 리턴하기
export const MemberProvider = ({ children }: { children: ReactNode }) => {
    const [member, setMember] = useState<Member | null>(null);

    const logout = () => {
        setMember(null);
    };

    const login = (member: Member) => {
        setMember(member);
    };

    return <MemberContext.Provider value={{ member, logout, login }}>
        {children}
    </MemberContext.Provider>
};

/////type에서 선언한 상태와 함수를 value에 필수로 작성하기
/////todo4 커스텀 훅: useMemberContext
export const useMemberContext = () => {
    const context = useContext(MemberContext);

    if (!context) {
        throw new Error("useMemberContext must be used within a MemberProvider");
    }
    return context;
}