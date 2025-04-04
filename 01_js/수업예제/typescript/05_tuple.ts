// ❶ 튜플은원소개수만큼타입정의가필요
const myTuple: [string, number] = ["seungkyoo", 179];

// ❷ 튜플은 함수의 매개변수가 여러개일때 유용
function printMyInfo(label: string, info: [string, number]): void {
  console.log(`[${label}]`, ...info);
}

// 결괏값 : [튜플 테스트] seungkyoo 179
printMyInfo("튜플 테스트", myTuple);

// 튜플을 반환하는 함수
function fetchUser(): [string, number] {
  return ["seungkyoo", 179];
}
console.log(fetchUser())

// ❸ 결괏값을 분해해서 받을 수 있음
const [name24, height24] = fetchUser(); 
console.log(name24, height24);