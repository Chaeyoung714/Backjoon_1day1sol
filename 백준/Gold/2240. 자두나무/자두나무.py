import sys
input = sys.stdin.readline

t, w = map(int, input().split())
tree = [0]

for _ in range(t):
    tree.append(int(input().strip()))

# tree = [0, 2, 1, 1, 2, 2, 1, 1]

#초기화    
DP = [[0 for _ in range(w+1)] for _ in range(t+1)]

for i in range(1, t+1): #자두 위치가 나무1에서 변하지 않음
    if tree[i] == 2:
        DP[i][0] = DP[i-1][0]
    else:
        DP[i][0] = DP[i-1][0] + 1

#DP테이블 채우기
for i in range(1, t+1):
    target = tree[i] #자두를 먹을 수 있는 나무 위치
    for j in range(1, w+1):
        if j % 2 == 0:
            where = 1
        else:
            where = 2
        
        #자두를 먹을 수 있는 위치와 내 현위치 비교
        if target == where: #먹음. 따라서 DP[n] = max(DP[n-1]) + 1!
            # 내가 where에 서 있을 수 있는 경우는 2가지 <- 직전에 이동함 or 직전에 이동하지 않음
            
            DP[i][j] = max(DP[i-1][j-1], DP[i-1][j]) + 1
        
        else: #먹을 수 없음. 따라서 DP[n] = max(DP[n-1])에서 변화 없음
            DP[i][j] = max(DP[i-1][j-1], DP[i-1][j])
        
print(max(DP[t]))