/* 
              타입 선언부           객체
  let 변수명:{속성명:타입,... } = { 속성:값,...}
*/


let myInfoWithGender: {

  name: string,
  height: number,
  isConditionGood: boolean,
  gender?: string,               // 선택적 속성, 해당 속성이 없을 경우 undifined
} = {
  name: "seungkyoo",
  height: 179,
  isConditionGood: true,
};

console.log(myInfoWithGender)
console.log('gender', myInfoWithGender.gender)

/*인터페이스는 타입을 정의한 규칙을 의미합니다. */

interface User {
 age: number;
 name: string;
}

var person: User = {
 age: 30,
 name: 'aa'
}

function getUser(user: User) {
 console.log(user);
}

/* 인터페이스 확장
*/
interface Vip extends User{
 hobby: string;
}

var cust: Vip = {
 age: 30,
 name: 'aa',
 hobby:'coding'
}
console.log(cust);