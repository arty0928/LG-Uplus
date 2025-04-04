/*자주 사용하는 유니온 타입들을 별칭으로 지정
  type 타입명 = 타입|타입|..


*/

type nsb = number | string | boolean;

let anyV: nsb = 10;
anyV = "hello";
anyV = true;
//anyV = null;      //컴파일 에러

// 타입 별칭에 null, undefined 추가
type nullableNsb = nsb | null;

let nullableValue: nullableNsb = null;
nullableValue = 20;
nullableValue = "nullable";
nullableValue = false;
//nullableValue = undefined; // 컴파일 에러