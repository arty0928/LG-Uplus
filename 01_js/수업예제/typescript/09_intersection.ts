/*
인터섹션 타입은 타입 A가 있고 타입 B가 있다면 A이면서 B인 타입을 정의합니다. 
그래서 기호도 and를 뜻하는 &를 사용해 A & B로 표현합니다.

type 타입명 = { 
  속성명: 타입;
}

주의점)
인터섹션 타입을 복잡하게 만들면, 타입 검사 시 에러가 나는 경우 여러 개의 타입을 동시에 표시해야 하므로 
에러 메시지를 이해하기가 힘들어집니다.==> 간결함을 유지해 사용하는 것이 좋습니다.

*/

type cup = {
  size: string;
};

type brand = {
  brandName: string;
};

type brandedCup = cup & brand; // ❶ cup이면서 brand가 있는 타입

let starbucksGrandeSizeCup: brandedCup = {
  brandName: "스타벅스",
  size: "grande",
};

console.log(starbucksGrandeSizeCup)

