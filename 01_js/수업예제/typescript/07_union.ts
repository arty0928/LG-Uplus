/*
 | union    변수의 값이 지정한 타입 중 한개의 타입의 값을 저장할 수 있다. 
*/

let anyVal: number | string | boolean = 10; // ❶ 이 시점에서는 number
printAny(anyVal);
anyVal = "hello";
printAny(anyVal);
anyVal = true;
printAny(anyVal);

let greeting: string|null = null;
greeting = 'hello';


/* 내로잉 타입의 범위를 좁히는 것

   타입의 범위를 좁히는데 사용하는 검사 방법을 타입 가드(type guard)라고 하면
   할당 또는 조건문(typeof, instanceof, in )으로 검사해 타입을 좁힌다. 
*/

function printAny(value: number | string | boolean): void {
  if (typeof value === "number") {
    console.log(value);
  } else if (typeof value === "string") {
    console.log(value.toUpperCase());
  } else if (typeof value === "boolean") {
    console.log(value ? "참" : "거짓"); 
  }
}