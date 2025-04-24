import { Member } from "@/types/member";
import { createSlice, PayloadAction } from "@reduxjs/toolkit";

//////////TODO M1.member state를 위한 타입 선언하기
interface MemberState {
    member: Member | null;
}

//////////TODO M2. slice에서 사용할 초기값 선언하기
const initialState: MemberState = {
    member: null,
};

//////////TODO M3. slice선언하기 {슬라이스이름, 초기값, reducers}
// createSlice : action + reducer 상태를 한 번에 정의하는 Redux Toolkit 함수
const memberSlice = createSlice({
    name: "member",
    initialState,
    reducers: {

        // Action 정의하기 : login, logout 
        login: (state, action: PayloadAction<Member>) => {
            state.member = action.payload;
        },
        
        logout: (state) => {
            state.member = null;
        },
    },
});

//////////TODO M4. slicer가 제공하는 action함수들 export 하기 (구조분해할당)
export const { login, logout } = memberSlice.actions

//////////TODO M5. reducer export 하기
export default memberSlice.reducer;
