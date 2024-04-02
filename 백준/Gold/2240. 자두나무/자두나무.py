import sys
input = sys.stdin.readline

t, w = map(int, input().split())

trees = [0]
for _ in range(t):
    trees.append(int(input()))

DP = [[0] * (w + 1) for _ in range(t + 1)]

for i in range(t + 1):

    #한 번도 안 움직인 상태 값(DP[*][0]) 채움 (초기화)
    if trees[i] == 1:
        DP[i][0] = DP[i-1][0] + 1 #i초까지 한번도 안 움직였을 때 자두 개수
    
    else:
        DP[i][0] = DP[i-1][0] #이전과 변함없는 상태


    #1번 이상 움직이는 경우에 대해 탐색
    for j in range(1, w+1):
        
        #i초에 2번나무에서 자두가 떨어짐 + 2번나무에 위치
        if trees[i] == 2 and j % 2 == 1:
            DP[i][j] = max(DP[i-1][j-1], DP[i-1][j]) + 1

        #i초에 1번나무에서 자두가 떨어짐 + 1번나무에 위치
        elif trees[i] == 1 and j % 2 == 0:
            DP[i][j] = max(DP[i-1][j-1], DP[i-1][j]) + 1

        #i초에 자두가 떨어지는 나무번호와 현재 나무위치가 다른 경우
        else:
            DP[i][j] = max(DP[i-1][j-1], DP[i-1][j])

#마지막 행 (마지막까지 자두를 다 받음) 에서의 최대값 
print(max(DP[t]))