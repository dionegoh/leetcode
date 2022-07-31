-- Write your MySQL query statement below

select case 
    when count(distinct salary) < 2 then null
    else (select distinct salary from Employee
          order by salary desc
          limit 1
          offset 1)
    end as SecondHighestSalary
    from Employee


-- limit needs to come before offset, if not will throw error