/*
 
function 함수명(인자명:타입,...):리턴타입{

}

void : 리턴 값이 없는 경우 
 */
function print(message: string, isCritical?: boolean): void {
  console.log(message);
  
  if (isCritical) {
    alert(message);   //js로 변환후 html에서 사용 가능 
  } 
}

print('hello', false);
print('경고', true);