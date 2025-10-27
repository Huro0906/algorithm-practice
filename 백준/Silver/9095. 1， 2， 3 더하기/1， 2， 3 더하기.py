import sys
from collections import deque

input = sys.stdin.readline

t = int(input())
dx = [1,2,3]
result = [0 for _ in range(t)]
for i in range(t):
    x = int(input())   
    q = deque()
    
    q.append(1)
    q.append(2)
    q.append(3)
    
    while len(q)!=0:
        cur = q.popleft()
        if cur == x:
            result[i] += 1
        for j in dx:
            nx = cur+j
            if nx <= x:
                q.append(nx)
    
for i in range(t):
    print(str(result[i]))
        


