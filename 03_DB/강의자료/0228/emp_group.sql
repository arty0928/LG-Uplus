-- 부서별   사원수,  급여 평균, 커미션을 받는 사원 수를 조회 하시오
select * from emp;
select deptno, count(*) as 인원, round(avg(sal),2) as AvgSal, count(comm)
from emp
group by deptno;

-- 업무별   평균 급여, 최저 급여, 최고 급여를 조회 하시오
select job, round(avg(sal)) as AvgSal,
		round(min(sal)) as MinSal,
        round(max(sal)) as MaxSal
from emp
group by job;

-- 부서별, 업무별 통계  : 사원수,  급여 평균, 커미션을 받는 사원 수를 조회 하시오
select deptno, job, count(*) as '사원 수', 
		round(avg(sal)) as AvgSal,
        count(comm) as Comm
from emp
group by deptno, job
order by deptno, '사원 수';

-- 부서별 총 급여가 10000이하인 부서의 총 사원수, 총 급여를 조회
select deptno,
	count(*) as '사원 수',
     round(sum(sal)) as total_sal
from emp
group by deptno having total_sal <= 10000;


-- 부서별 총 급여를 조회,  급여가 1000이상인 사원들의 급여 합계를 구함.
select deptno, round(sum(sal)) as total_Sal
from emp
group by deptno having total_Sal >= 1000
order by DEPTNO ;


-- 상품별 수량이 10개 초과인 제품에 대해 상품별 총 판매 수량 조회
select * from orders;
select gno, round(sum(quantity)) as total_q
from orders
group by gno having total_q > 10;

-- 건당 판매 수량이 2개 이상인 판매 건수를 상품별 조회
select * from orders;

select gno, round(sum(quantity)) as '판매 건수'
from orders
group by gno;

