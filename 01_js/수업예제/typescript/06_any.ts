// let anyValue = 10;   // ❶ number 타입으로 추론
//anyValue = "hello";  // ❷ 컴파일 에러
//anyValue = true;     // ❸ 컴파일 에러

//변수에 타입을 변경해야 한다면...?  any 또는 union 타입으로 지정
let anyValue: any = 10;
console.log(typeof anyValue)
anyValue = "hello";
console.log(typeof anyValue)
anyValue = true;
console.log(typeof anyValue)
