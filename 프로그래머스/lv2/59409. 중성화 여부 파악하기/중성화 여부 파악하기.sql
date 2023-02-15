-- 코드를 입력하세요
SELECT animal_id, name,
if(sex_upon_intake like '%Neutered%' or sex_upon_intake like '%Spayed%', 'O', 'X')
as sex_upon_intake
from animal_ins
order by animal_id