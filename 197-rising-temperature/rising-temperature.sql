# Write your MySQL query statement below
select w1.id from weather w1 JOIN weather w2 on DATEDIFF(w1.recordDate,w2.recordDate)=1 where w1.temperature >w2.temperature