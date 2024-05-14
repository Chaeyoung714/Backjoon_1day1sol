import sys
input = sys.stdin.readline

def find_max_total(depth):
    global result

    if depth == 11: #리프노드까지 가면 끝.
        result = max(result, sum(pick_players))
        return
    
    for i in range(11): #i=선수 depth=경기회차
        if visited[i] != 0:
            continue
        
        if players[depth][i] != 0:
            visited[i] = 1
            pick_players.append(players[depth][i])
            find_max_total(depth+1)


            pick_players.pop(-1)
            visited[i] = 0

n = int(input().strip())
for _ in range(n):
    players = []
    for _ in range(11):
        players.append(list(map(int, input().split())))
    
    result = 0
    pick_players = []
    visited = [0 for _ in range(12)] #선수 1~11 저장

    find_max_total(0)

    print(result)