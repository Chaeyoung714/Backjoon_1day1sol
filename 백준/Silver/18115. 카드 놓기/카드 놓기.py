
from collections import deque

N = int(input())
# 1 ~ N

# cards = [0 for _ in range(N)] #바닥에 내려놓을 카드

# 처음 카드 -> N번 기술 -> 1~N

default_cards = deque()

tactics = list(map(int, input().split()))
tactics.reverse()
# print(tactics)

cards = list(range(1, N+1, 1)) #[N, N-1, ..., 2, 1]

for i in range(N):
    tactic = tactics[i]

    card = cards[i]

    if tactic == 1:
        default_cards.appendleft(card)
    
    elif tactic == 2:
        if i < 1:
            print("전략 2 실패")
            break
        
        first = default_cards.popleft()
        default_cards.appendleft(card)
        default_cards.appendleft(first)
    
    elif tactic == 3:
        if i < 1:
            print("전략 3 실패")
            break

        last = default_cards.append(card)

for elem in default_cards:
    print(elem, end=" ")

