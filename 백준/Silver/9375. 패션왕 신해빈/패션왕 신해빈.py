import sys
input = sys.stdin.readline

global clothes

def count_clothes():
    global clothes

    total_cases = 1
    for elem in clothes.keys():
        # print(clothes[elem])
        c = len(clothes[elem]) + 1 #선택하지 않는 경우도 있음
        total_cases *= c

        # print(total_cases)

    total_cases -= 1 #아무것도 안 입은 케이스 제외

    return total_cases



k = int(input().strip())

result = []
for _ in range(k):
    clothes = dict()

    n = int(input().strip())

    for _ in range(n):
        name, sort = input().strip().split()

        if sort in clothes.keys():
            clothes[sort].append(name)
        else:
            clothes[sort] = [name]

    result.append(count_clothes())


for elem in result:
    print(elem)