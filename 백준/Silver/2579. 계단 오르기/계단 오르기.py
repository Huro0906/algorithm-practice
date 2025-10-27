import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
scores = [0 for _ in range(n+1)]

for i in range(n):
    scores[i+1] = int(input())

q = deque()

dp = [0 for _ in range(n+1)]

dp[1] = scores[1]
if n>=2:
    dp[2] = dp[1]+scores[2]

for i in range(3,n+1):
    case1 = dp[i-2] + scores[i]
    case2 = dp[i-3]+ scores[i-1] + scores[i]

    dp[i] = max(case1, case2)
    

print(dp[n])


    
    
    
    