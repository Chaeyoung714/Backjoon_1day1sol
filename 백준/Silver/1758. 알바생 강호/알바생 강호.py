N = int(input())
tips = [int(input()) for i in range(N)]
result = 0

# 내림차순으로 정렬함으로써 큰 값부터 처리시작
for i, tip in enumerate(sorted(tips, reverse=True)):
    if tip - i > 0:
        result += tip - i
print(result)