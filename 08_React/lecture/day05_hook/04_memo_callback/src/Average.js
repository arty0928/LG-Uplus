/*
  array.reduce(callback, initialValue)
    callback(accumulator, current, currentIndex, array)
      accumulator : reduce를 한 이전 결과, 처음인 경우  initialValue가 있으면 initialValue 
      current : 처리할 현재 요소
      currentIndex : 처리할 현재 요소의 index,  initialValue가 있으면 0, 없으면 1부터 시작
      array : reduce를 시작한 배열 
*/

import React, { useCallback, useMemo, useRef, useState } from 'react';

/*
  render 함수에서 호출되고 있기 때문에 list가 변하지 않았는데도 
  input 양식의 값이 변경되면 (값을 입력, 수정만 해도) number state가 변경되므로 
  render 함수가 호출된다 -> getAverage 함수도 호출된다.

  ==> useMemo로 변경됐을 때만 호출되게 수정
*/

const getAverage = (numbers) => {
  if (numbers.length === 0) return 0;
  if (numbers.length === 1) return numbers[0];
  const sum = numbers.reduce((a, b) => {
    console.log('a : ', a, "b : ", b);
    return a + b;
  });

  return sum / numbers.length;
};

const Average = () => {
  
  // input으로 입력 받은 데이터를 저장하는 list ==> 평균을 구할 대상
  const [list, setList] = useState([]);
  //input 양식과 양방향 binding할 
  const [number, setNumber] = useState("");

  /*
    useMemo(Callback, [state])
    - 처음에 한번 수행되고, state가 변했을 때만 callback이 호출되어 다시 계산
    - component 내에서 state에 대한 계산 처리를 할 때 변경됐을 때만 다시 계산하고
      변경되지 않은 경우에만 기존의 값을 재사용
    - 처음에 한번 수행되고, state가 변했을 때만 callback이 호출되어 다시 계산한다.
  */
  const avg = useMemo(() => getAverage(list), [list]);
  const prevOnChange = useRef();
  const prevOnClick = useRef();

  /*
    react 에서는 함수형 Component는 렌더링될 때마다 컴포넌트 함수를 실행시키므로
    onChange, onClick 함수는 렌더링될 때마다 매번 생성

    ==> useCallBack 사용해야 한다.
  */
  
  /**
    useCallBack(callback)
    - callback 함수를 재사용
    - 렌더링 성능을 최적화할 때 사용
    - useCallBack (callback, []) : 컴포넌트가 처음 렌더링될 때만 함수 생성
    - useCallBack (callback, [state]) : 지정한 state가 변경될 때만 함수 생성

  */
  const onChange = useCallback((e) => {
    setNumber(e.target.value);
  },
    [list]
  );

  const onClick = (params) => {
    const nextList = list.concat(parseInt(number))
    setList(nextList)
    setNumber("");
  };
  
  console.log("onChange : ", prevOnChange.current === onChange);
  console.log("onClick : ", prevOnClick.current === onChange);
  prevOnChange.current = onChange;
  prevOnClick.current = onClick;

  return (
    <div>
      <input value={number} onChange={onChange} />
      <button onClick={onClick}>등록</button>
      <ul>
        {list.map((value, index) => (
          <li key={index}> {value} </li>
        ))}
      </ul>

      <div> 평균값 : {avg} </div>

    </div>
  );
};

export default Average;