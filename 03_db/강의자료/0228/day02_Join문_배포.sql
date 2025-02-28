/*
 Join 
 - 두개 이상의 테이블을 연결해서 질의하는 것
 - 종류 
	
    * master 데이터를 기준으로 , detail 정보를 추가로 보여줌 (둘 다 master가 될 수는 없음)
    
    1. 데이타 추출되는 것에 따라 
      Inner Join : 
			완벽하게 맞는 애
        - 조인을 위해 사용하는 비교 조건에 맞는 데이타만 조회
        - 조인 조건에 맞지 않은 데이타는 조회 되지 않는다. 
        - join할 때  outer join으로 표시 하지 않으면 기본적으로 
          Inner join으로 조회된다. 
          
      Outer Join 
        - 조인을 위해 사용하는 비교 조건에 맞지 않는 데이타도 조회된다. 
		- 종류 
          left outer join  : 비교 조건에 맞지 않은 왼쪽 테이블의 데이타도 조회됨
          right outer join : 비교 조건에 맞지 않은 오른쪽 테이블의 데이타도 조회됨
          full outer join  : 비교 조건에 맞지 않은 양쪽 테이블의 모든 데이타가 조회됨
		
			* 기준을 왼쪽으로 뒀다고 해서 left outer join 이 아님 -> 이건 그냥 개발자 편의에 따라
		
    2. 비교 조건에 따라서 
	  Equi join 
        - 비교하는 두 컬럼의 데이타가 정확하게 일치할 경우 
        - join 조건으로 = 비교 연산자를 이용할 경우 
      Non Equi join 
        - 비교하는 두 컬럼의 데이타가 정확하게 일치하지 않는 경우 
        - join 조건으로  >, < , >= , <=, != 등
        
    3. 비교 테이블에 따라서 
	     self join 
        - join할 테이블이 다른 테이블이 아닌 self(한개의 테이블로 join)
        - 테이블을 구별하기 위해 반드시 alias를 사용해야 한다. 
        
    4.Natural join 
    		- 두 테이블에서 동일한 컬럼명을 갖는 컬럼을 조인 조건으로 사용한다. 
    		- inner join과 같은 결과를 갖는다
    		 
    		
    5.카티시안 곱 (Cross join)
      - 조인 조건을 생략했을 때 두 테이블의 모든 row를 연결한 결과가 조회된다. 
	  - N * M의 수만큼 행이 조회된다. 
	
    ==> 실제로 Natural join과 Cross join은 쓰지 않음. sql 시험에서만 나옴.
    
    
	   
*/

-- 카티시안 곱 
select gno, brand, price, goods.cno as cno
     , category.cno as 분류번호 ,  name
from   goods, category; 

/*
 inner join 
 -DB 벤더 전용
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias], 테이블명 [alias] , 
  [where  조건]
  [group by 컬럼명, .. [having 조건]]
  [order by 컬럼명 [asc|desc]], ...]
  
 -ANSI query 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias]
  join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)
  ,...
  [where  조건]
  [group by 컬럼명, .. [having 조건]]
  [order by 컬럼명 [asc|desc]], ...]	
 
  using 
   - 조인을 위한 비교 컬럼명이 동일 할 때 사용 
   - alias 없이 사용해야 한다. => 다른 DB는 alias를 사용할 경우 error발생 
   - 비교 조건은 기본적으로 = 이 적용된다. 
  
  on (where과 비슷)
   - 조인을 위한 비교 컬럼명이 다르거나 비교 조건이 = 이 아닐때 사용한다. 
   - 조인을 위한 비교 컬럼이 같을 경우 alias를 사용해서 구분한다. 
   
*/

-- 상품번호, 상품명, 상품금액, 카테고리번호, 카네고리이름을 조회한다.
-- inner join  벤더 전용
select gno, brand, price, goods.cno, name
from goods, category
where goods.cno = category.cno	-- 조인 조건
order by gno;

-- 테이블에 alias를 적용
select gno, brand, price, g.cno, name
from goods g, category c
where g.cno = c.cno	-- 조인 조건
order by gno;

-- ansi query ( where을 on으로 바꾸면 됨 )
select gno, brand, price, g.cno, name
from goods g
join category c
on g.cno = c.cno	-- 조인 조건
order by gno;

select gno, brand, price, cno, name
from goods
join category
using (cno) -- 조인하려는 컬럼면 cno가 동일하므로 using으로 쓰면 됨. 이때 table alias 쓰지 않음
order by gno;


-- 주문일, 주문 번호, 주문한 상품 번호, 상품명, 주문자, 상품가격, 주문 수량, 주문 금액을 조회하시오.
-- vender 전용
select date_format(odate, '%y-%m-%d') as odate,
	ono, o.gno, brand, id, price, quantity,
    price * quantity as TotalPrice
from orders o, goods g
where o.gno = g.gno
order by odate desc;

-- ansi 
select date_format(odate, '%y-%m-%d') as odate,
	ono, o.gno, brand, id, price, quantity,
    price * quantity as TotalPrice
from orders o
join goods g
using (gno)
order by odate desc;

-- 이번달에 주문한 상품에 대한 정보 조회 
-- 주문일, 주문 번호, 주문한 상품 번호, 상품명, 주문자, 상품가격, 주문 수량, 주문 금액을 조회하시오.
-- vender 전용
select * from orders;
select * from goods;

-- ansi
select date_format(odate, '%y-%m-%d') as odate,
	ono, gno, brand, id, price, quantity,
    price * quantity as TotalPrice
from orders
join goods
using (gno)
where date_format(now(), '%y%m') = date_format(odate, '%y%m');

-- vender 전용
select date_format(odate, '%y-%m-%d') as odate,
	ono, o.gno, brand, id, price, quantity,
    price * quantity as TotalPrice
from orders o, goods g
where o.gno = g.gno and date_format(now(), '%y%m') = date_format(odate, '%y%m');


-- 사원번호, 이름, 업무, 급여, 급여등급을 조회
-- vender
select empno, ename, job, sal, grade
from emp, salgrade
where sal between losal and hisal;


-- ansi
select empno, ename, job, sal, grade
from emp
join salgrade
on sal between losal and hisal;


-- where  sal >= losal and sal<=hisal;
-- ansi


-- 사원번호, 이름, 업무, 급여, 급여등급, 부서번호, 부서명을 조회
-- vender
select empno, ename, job, sal, grade, e.deptno, dname
from emp e, dept d, salgrade 
where e.DEPTNO = d.DEPTNO and sal between LOSAL and HISAL;


-- ansi
select empno, ename, job, sal, grade, deptno, dname
from emp
join dept
using (deptno)
join salgrade
on sal between LOSAL and HISAL
where deptno = 10;

-- 주문번호, 주문일자, 상품명, 주문자명, 가격, 수량, 주문가격을 조회
-- vender 


-- ansi


-- 상품별 주문 수량을 조회하려 한다. 
-- 상품 번호(gno), 상품명(brand), 총 주문된 수량을 조회
-- vender 


/*
 outer join
 
 기준 테이블을 왼쪽에 있음.
 -left join 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias] 
  left [outer] join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)

 기준 테이블이 오른쪽에 있고 왼쪽에 있는 것을 붙임
 - right join 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias] 
  right [outer] join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)
*/
-- inner join으로 deptno가 없는 사원은 조회되지 않음 
insert into emp(empno, ename, sal) values (2, 'uplus', 3000);

select * from emp;

-- emp테이블을 기준으로 left join하면 deptno가 없는 사원도 조회됨. 

select empno, ename, job, deptno, dname
from emp left join dept
using (deptno);

-- goods의 모든 상품에 대해 상품번호, 이름, 가격, 분류번호, 분류명을 조회
select * from goods;
select gno, brand, price, cno, name
from goods left join category
using (cno);

-- 모든 상품에 대하여 상품별 주문 수량을 조회하려 한다. 
-- 상품 번호(gno), 상품명(brand), 총 주문된 수량을 조회'
select * from orders;

select g.gno, g.brand, ifnull(sum(o.quantity), 0) as total -- 3번
from goods g left join orders o using (gno) -- 1번
group by g.gno; -- 2번


/*
self join 
 - 한개의 테이블로 join 
 - 테이블에 alias를 이용해서 구별한다. 
*/
-- 사원번호, 사원이름, 업무, 급여, 상사번호, 상사이름 조회 


-- 모든 사원에 대한 사원번호, 사원이름, 업무, 급여, 상사번호, 상사이름 조회
-- (상사가 없는 사원도 조회)





-- 네이버 면접 질문 
-- weather (ymd : date, temp : int, city : string ) 1년치 데이터가 있다고 할때, 
-- 전날보다 온도가 높아진 날이 가장 많았던 도시를 출력하시오       
			

-- 전날(어제)보다 판매 개수가 많은 날이 가장 많았던 상품을 조회하시오
 


-- Natural join




