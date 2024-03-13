# 그리디
import sys
input = sys.stdin.readline

global coins, k

def get_min_coins(i, rest, total):
    global coins, k

    if i > len(coins) - 1 or rest < 0:
        return -1
    
    # if rest == 0:
    #     # print('yes', total)
    #     return total

    coin = coins[i]
    
    cnt = (rest // coin)
    rest -= (cnt * coin)

    total += cnt

    if rest == 0:
        return total

    #이거 return 안넣으면 안됨 조심
    return get_min_coins(i+1, rest, total)


n, k = map(int, input().split())

coins = []
for _ in range(n):
    coins.append(int(input().strip()))

coins.reverse() #가치가 큰 것부터

cnt = get_min_coins(0, k, 0)

print(cnt)