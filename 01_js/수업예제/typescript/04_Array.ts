/*
배열 선언
1.  변수명:타입[] = [값,...]
2.  변수명:Array<타입> = [값,...]
*/


// 1 숫자 배열 
const numbers: number[] = [1, 2, 3, 4, 5]; 
const numbers2: number[]= [6,7,8];

// 2 문자열 원소
const stringArray: Array<string> = ["a", "b", "c", "d", "e"];

// 4 객체의배열타입
const idols: { name: string; birth: number }[] = [
   { name: "minji", birth: 2004 },
   { name: "hani", birth: 2004 },
   { name: "danielle", birth: 2005 },
   { name: "haerin", birth: 2006 },
   { name: "hyein", birth: 2008 },
];
// 5 배열의 원소가 객체인 타입
const gameConsoleArray: Array<{ name: string; launch: number }> = [
{ name: "플레이스테이션5", launch: 2020 },
{ name: "엑스박스 시리즈 X/S", launch: 2020 },
{ name: "닌텐도 스위치", launch: 2017 },
{ name: "스팀덱", launch: 2021 },
];