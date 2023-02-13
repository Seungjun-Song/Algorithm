-- 코드를 입력하세요
SELECT a.rest_id, rest_name, food_type, favorites, address, round(avg(review_score), 2) as score
from rest_info a, rest_review b
where a.rest_id = b.rest_id
group by a.rest_id
having address like "서울%"
order by avg(review_score) desc, favorites desc