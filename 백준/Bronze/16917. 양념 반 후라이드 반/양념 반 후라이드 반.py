
# 양념, 후라이드, 반반, num양념, num후라이드
A, B, C, X, Y = tuple(map(int, input().split()))

# 양 X + 후 Y
# 반반*2 < X + Y인 경우 반반 + 남은양 or 전부 반반

total = 0
if C * 2 >= A + B:
    total += (A * X) + (B * Y)

    # print("case 1", total)

else:
    if X <= Y: #후라이드가 더 많음
        cnt_half, cnt_rest, price_rest = X, Y - X, B
    else: #양념이 더 많음
        cnt_half, cnt_rest, price_rest = Y, X - Y, A

    # print(cnt_half, cnt_rest, price_rest)

    #후라이드, 양념치킨 공통된 개수만큼 반반으로 구매
    # ex. 후라이드 3 양념 5 -> 후라이드 3 + 양념 3 구매
    total += C * (cnt_half * 2)

    if C * 2 * cnt_rest >= price_rest * cnt_rest:
        total += price_rest * cnt_rest

        # print("case 2", total)
    else: #잉여가 생겨도 반반으로 구매하는 게 나음
        total += C * 2 * cnt_rest

        # print("case 3", total)

    

print(total)
