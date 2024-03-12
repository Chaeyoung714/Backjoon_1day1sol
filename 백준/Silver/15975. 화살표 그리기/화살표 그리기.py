import sys
input = sys.stdin.readline

n = int(input().strip())

blank = dict() #색깔 : 좌표


for _ in range(n):
    point, color = map(int, input().split())

    if color in blank.keys():
        blank[color].append(point)
    else:
        blank[color] = [point]

    
# for i in range(len(blank.keys())):

total_len = 0
for c in blank.keys(): # 색깔 : [좌표1, 좌표2...]
    blank[c].sort()

    for i in range(len(blank[c])): #매번 점들에서 가까운 길이 저장
        if len(blank[c]) == 1:
            continue
        
        elif i == 0:
            len_arrow = blank[c][i+1] - blank[c][i]
        
        elif i == len(blank[c]) - 1:
            len_arrow = blank[c][i] - blank[c][i-1]

        else:
            len_arrow = min(blank[c][i+1]-blank[c][i], blank[c][i]-blank[c][i-1])

        total_len += len_arrow

print(total_len)