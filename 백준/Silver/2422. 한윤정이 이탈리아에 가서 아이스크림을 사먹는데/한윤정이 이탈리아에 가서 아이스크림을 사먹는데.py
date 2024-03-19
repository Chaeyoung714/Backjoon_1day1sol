import sys
input = sys.stdin.readline

from itertools import combinations #조합 - 중복 허용 x, 순서 고려 x

n, m = map(int, input().split())

icecream = list(range(1, n+1))
avoid = {} # value = key아이스크림과 조합되면 안되는 아이스크림 리스트

for i in range(1, n+1):
    avoid[i] = [i] #자기자신과 조합되면 안되므로 기본적으로 자기자신 추가 (조합하면 안되는 아이스크림이 없는 것도 있을 수 있으므로 미리 설정해야함)

for _ in range(m): 
    a = list(map(int, input().split()))

    avoid[a[0]].append(a[1])
    avoid[a[1]].append(a[0]) #한쪽에만 저장 x 각각 저장해야 함

    # a.sort()

    # avoid[a[0]].append(a[1]) 




cnt = 0
for i in range(1, n): #마지막 맛은 볼 필요 없음
    not_avoid = list(set(icecream) - set(avoid[i])) #아이스크림 리스트에서 피해야하는 아이스크림 리스트 차집합

    not_avoid.sort()

    not_avoid = [elem for elem in not_avoid if elem >= i]

    # for elem in not_avoid:
    #     if elem >= i:
    #         index = not_avoid.index(elem)
    #         del not_avoid[:index] #중복방지

    #         break
    

    comb = list(combinations(not_avoid, 2)) #1개는 고정이므로 2개 조합


    if comb: #comb끼리도 중복체크
        comb = [elem for elem in comb if elem[0] not in avoid[elem[1]]]
        # for elem in comb:
        #     if elem[0] in avoid[elem[1]]:
        #         comb.remove(elem)

    cnt += len(comb)

print(cnt)