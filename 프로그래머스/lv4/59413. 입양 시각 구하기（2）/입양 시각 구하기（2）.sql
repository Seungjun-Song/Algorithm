set @hour := -1;

SELECT (@hour := @hour + 1) hour,
(select count(*) from animal_outs where hour(datetime) = @hour) count
from animal_outs
where @hour < 23