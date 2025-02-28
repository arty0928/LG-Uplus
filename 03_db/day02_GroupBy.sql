/*
집계함수(aggregation), 그룹함수(group)함수 
 - 지정한 group에 함수 기능 처리한 결과가 1개가 조회된다. 
 - group by로 그룹을 지정하지 않으면 전체 데이타가 한개의 group으로 지정된다.
 
 - 주의) group의 수와 다른 데이터를 같이 조회하면 mysql은 의미 없는 결과가 나오지만 
        oracle, db2,... 다른 DB는 error가 발생한다. 
        
 - max(컬럼명), min(컬럼명), avg(컬럼명), sum(컬럼명) : null값을 제외하고 연산 처리 
   count(*) : 모든 행의 개수를 count한다. 
   count(컬럼명) : null이 아닌 행의 개수를 count한다. 
   
 - 집계함수(all | distinct  컬럼명) 
    all 	   모든 값을 처리 ==> 생략시 기본적으로 all로 처리된다. 
    distinct   중복된 값을 제거하고 처리 
*/

-- 전체 직원 수 조회
select count(*) from emp;

-- 커미션을 받는 사원 수를 조회
select count(comm) from emp;

select * from emp;

-- 최소 급여, 최대 급여, 평균 급여 조회
select min(sal), max(sal), avg(sal) 
from emp;

/*
 * 다중행 함수 , 집계함수, group 함수
  -  지정한 group에 함수 기능을 처리한 결과가 1개가 조회된다. 
  -  group을 goupy by로 지정하지 않으면 전체 행이 1개의 group으로 지정된다. 
  -  주의) group의 수와 다른 데이타 개수가 조회되는 컬럼을 같이 조회하면
          oralce, db2.... 다른 DB는 error가 발생한다. 
          *** Mysql은 ONLY_FULL_GROUP_BY 설정이 기본으로 안되어 있어서 다른 컬럼과 
              같이 조회해도 error는 안나지만 의미 없는 데이타가 추출 
             
             - ONLY_FULL_GROUP_BY 설정 
             set @@session.sql_mode='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION,ONLY_FULL_GROUP_BY';
    
			 edit>preperance>modeling>mysql>sql_mode 에서도 설정 가능 
  - 사용방법
    집계함수(all | distinct  컬럼명)  
       - distinct : 중복된 값을 제거하고 집계한다. 
       - all : 모든 값에 대해 집계한다. 생략시 all로 처리된다. 
	
  - 함수 종류 
	min, max, sum, avg : null을 제외하고 처리한다. 
	count(*)    : 해당 테이블의 모든 행의 객수를 count한다. 
    count(컬럼명) : null이 아닌 행의 개수를 count한다. 
 */
   

--  group의 수와 다른 데이터를 같이 조회하면 mysql은 의미 없는 결과가 나온다.

/*
   데이타를 특정 컬럼의 데이타를 기준으로 group을 나눠서 group함수적용
   group by 컬럼명    지정한 컬럼의 데이타를 분류해서 group을 생성 

   *** Mysql은 ONLY_FULL_GROUP_BY 설정이 기본으로 안되어 있어서 
   select employee_id, sum(salary)  from    employees;  쿼리에서 오류가 발생하지 않는다 

   set @@session.sql_mode='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION,ONLY_FULL_GROUP_BY';
   
   edit>preperance>modeling>mysql>sql_mode 에서 설정 가능 
   
   ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION
*/



-- count(*) : 모든 행의 개수를 count한다.  count(컬럼명) : null이 아닌 행의 개수를 count한다. 


/*
 집계함수(all | distinct  컬럼명) 
    all 	   모든 값을 처리 ==> 생략시 기본적으로 all로 처리된다. 
    distinct   중복된 값을 제거하고 처리 
*/


/*
	group by 
    - 데이타를 특정 컬럼의 데이타 종류를 기준으로 group 으로 데이타를 분류한다. 
    - group by와 함께 집계함수를 사용하면 집계함수의 결과는 group개수로 조회된다. 
*/


-- 부서별 인원수와, 평균 급여를 조회 
select deptno, count(*), avg(sal)
from emp 
group by deptno
order by deptno;

-- 업무별 인원수와, 평균 급여를 조회
select job, count(*) as 인원, round(avg(sal))
from emp
group by job
order by job;

-- 부서별 / 업무별 인원수와, 평균 급여 조회 
select deptno, job, count(*) as 근무인원, round(avg(sal),2) as sal
from emp
group by deptno, job
order by deptno, job;

/* having
   - group 집계한 결과에 대한 조건은 having절에서 한다. ( 얘는 탈락, 얘는 선택할 거야! )
   - 형식]  
     select   집계함수
     from     테이블
     where    레코드 각각에 대한 조건
     group by 컬럼(알리아스), ...
     having   집계한 결과에 대한 조건(알리아스)
     
 where => 행 하나 하나에 대한 조건 처리  
 
 행에 대한 조건은 where, 그룹의 조건은 having에서
*/

-- 부서별 평균 급여가 2000이상인 부서를 조회
select deptno, avg(sal) as AvgSal
from emp
group by deptno having AvgSal >= 2000 ;

select * from emp where empno = 1;
insert into emp(empno, ename, sal, deptno) values(1, 'eureka',5000, 40);

-- 사원의 급여가 1000이상 사원들이 근무하는 부서 중 평균 급여가 5000이상인 부서를 조회
select deptno, min(sal), round(avg(sal),2) as AvgSal
from emp
group by deptno having min(sal) >= 1000 and AvgSal >= 5000;

-- 사원의 급여가 1000이상 사원들이 근무하는 부서 중 평균 급여가 5000이상인 부서를 조회
select deptno, round(avg(sal),2) as AvgSal
from emp
where sal >= 3000
group by deptno
having AvgSal >= 5000;


-- 알리아스를 where에서 사용할 수 없다. 

-- 업무별 급여 평균이 2500이상이 업무 조회 
select * from emp;

select ifnull(JOB, '프리랜서'), round(avg(sal),2) as AvgSal
from emp
group by JOB having AvgSal >= 2500;

-- 카테고리별 가격 평균을 조회 단, 가격 평균이 500000이상인 카테고리는 제외하고 조회한다. 
select * from goods;

select ifnull(cno,'미분류') as cno, round(avg(price),2) as AvgPrice
from goods
group by cno having AvgPrice < 500000;

-- 급여가 1500이상인 사원들의 부서별 급여 평균을 조회
-- 단 급여 평균이 2000이상인 부서만 조회 
select deptno , round(avg(sal)) as AvgSal
from emp
where sal >= 1500 
group by deptno having AvgSal >= 2000;


/*rollup 
		: group별 통계에  전체 통계를 추가로 조회
          
          그룹으로 나눈 전 단계에 대한 rollup을 해준다.
          
  형식] group by 컬럼명 with rollup;
 */
-- 업무별 근무 인원, 급여 평균과, 최소 급여, 최대 급여를 조회



/**oralce 버전
select ifnull(job,'total'), count(*), round(avg(sal),2), min(sal), max(sal)
from   emp
group by rollup(job);
*/

/*grouping()
  rollup에 의해 조회된 데이타는 1 그렇지 않은 데이타는 0이 조회된다. 
*/



-- cno가 null인 경우 미분류로 표시, 그렇지 않으면 카테고리 번호로 표시 
-- rollup에 의해 null인 경우 total 
 


-- 부서별, 업무별 근무 인원을 조회, 전체 근무 인원 

select * from orders;

