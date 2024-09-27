select sum(g.score) as score, e.emp_no, e.emp_name, e.position, e.email
from hr_employees e, hr_grade g
where e.emp_no = g.emp_no
and g.year = 2022
group by e.emp_no, e.emp_name, e.position, e.email
order by score desc
limit 1