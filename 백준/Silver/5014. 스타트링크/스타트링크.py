from collections import deque  
import sys  
 
f, s, g, u, d = map(int, sys.stdin.readline().split())  
check = [0 for _ in range(f + 1)]  # 층수별로 지금까지 방문한 층 개수 저장


def bfs():  
    queue = deque()  
    queue.append(s)  

    check[s] = 1  #시작점에서 시작했다고 1로 체크 (마지막 출력시 1을 빼야함)
                ## 예를 들어 입력이 10 10 1 0 1로 들어온 경우, 시작지점을 먼저 체크를 하지 않으면 10번 이동한 것으로 출력되지만 실제로는 9번만 이동합니다. 이 경우를 조심해야합니다.

    while queue:  
        y = queue.popleft()  

        if y == g:  ##현재층수 = 목표층수
            return check[y] - 1  
        else:  
            for x in (y + u, y - d):  # 위로 / 아래로 이동 각각 체크
                if (0 < x <= f) and check[x] == 0:  #방문한 적 없는 층이어야 함
                    check[x] = check[y] + 1  
                    queue.append(x)  

    return "use the stairs"  #큐가 모두 종료될때까지 실행하면 use the stairs


print(bfs())