/*
타입을 명시하기 

형식]   const let var   변수명:타입 =값

null:null은 의도적으로 값이 없음을 나타낼때 사용합니다.
undefined : undefined는 변수에 값이 할당되지 않은 경우를 뜻합니다. 즉 의도하지 않은 값의 부재를 의미합니다.
boolean: true와 false 두 가지 값을 가지고 있는 타입입니다.
string: “타입스크립트” 같은 문자열을 의미합니다.
number: 이름처럼 숫자를 의미합니다. 숫자는 123과 같은 정수, 1.23 같은 부동소수점, 16진수, 8진수도 숫자 타입입니다.
bigint :매우 큰 숫자도 할당할 수. 있는 타입입니다. 숫자 뒤에 n을 붙여서 123n으로 표시합니다.   ES 2020부터 지원
symbol: 불변이면서 유니크한 값을 표현하는 자료형입니다.

*/
let one: number = 1;                    // 숫자 타입
// one = null;                          // strictNullChecks 설정으로 반드시 값이 설정되야 한다. 
const myName: string = "seungkyoo";       // 문자열 타입
const trueOrFalse: boolean = true;        // boolean 타입
let unIntended: undefined = undefined;    // undefined 타입
//unIntended = 1                          // undefined 타입으로 값을 대입할 수 없다.  ==> 뒤에서 유니온에서 사용
                                          //let myName: string | null | undefined;  ==> 유니온 
let nullable: null = null;              // null 타입
//nullable = 'ㅁ';                       // null 이므로 값을 대입 할 수 없다.         ==> 뒤에서 유니온에서 사용
// const bigNumber: bigint = 1234n;       // bigint 타입
const symbolValue: symbol = Symbol("symbol");   // symbol 타입

console.log(one + 1); // 2
console.log(myName + " is my name");            // seungkyoo is my name
console.log(trueOrFalse ? "true" : "false");    // true

// 모든 값이 유일하므로 같은 값을 넣어도 false
console.log(symbolValue === Symbol("symbol"));

