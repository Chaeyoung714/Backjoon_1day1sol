MAX_N, MAX_PRICE = 100, 1000

N, M = tuple(map(int, input().split()))

min_price_package, min_price_item = MAX_PRICE + 1, MAX_PRICE + 1

for _ in range(M):
    price_package, price_item = tuple(map(int, input().split()))
    min_price_package = min(min_price_package, price_package)
    min_price_item = min(min_price_item, price_item)

total = 0
if min_price_item * 6 < min_price_package:
    total = min_price_item * N

else: #패키지 +낱개 혼합 or 패키지 단독 가능
    cnt_package = N // 6 
    cnt_item = N % 6 
    total += cnt_package * min_price_package

    # print(total)
    
    #남은 N%6(<6)개의 줄 처리
    if min_price_item * cnt_item <= min_price_package:
        total += min_price_item * cnt_item
    else:
        total += min_price_package
    # print(total)

print(total)