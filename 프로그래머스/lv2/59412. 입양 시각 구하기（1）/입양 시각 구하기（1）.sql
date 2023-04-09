-- 코드를 입력하세요
SELECT hour(datetime) hour, count(datetime) count
from animal_outs
where 9 <= hour(datetime) and hour(datetime) <= 19
group by hour
order by hour