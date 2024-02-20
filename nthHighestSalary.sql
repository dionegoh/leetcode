CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  IF N <= 0 THEN
  RETURN QUERY (
      SELECT NULL::INT AS Salary
  );
  ELSE 
    RETURN QUERY (
        -- Write your PostgreSQL query statement below.
        SELECT DISTINCT Employee.salary FROM Employee 
        ORDER BY Employee.salary DESC
        LIMIT 1 OFFSET (N-1)  
    );
  END IF;
END;
$$ LANGUAGE plpgsql;