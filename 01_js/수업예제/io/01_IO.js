const fs = require('fs');

const filePath = process.platform === 'linux'?'/dev/stdin':__dirname+'/input.txt';
const input = fs.readFileSync(filePath).toString().trim().split("\n");

const tc = Number(input[0]);
const testcases =[];

for(let i=1; i<=tc; i++){
  // i번째 라인의 데이타를 공백을 기준으로 분리하고 
  // .map(Number)를 이용해서 바로 숫자로 변경
  const temp = input[i].split(" ").map(Number)

  const testcase ={ N : temp[0], data:temp.slice(1)}

  testcases.push(testcase);
}

console.log(testcases);

