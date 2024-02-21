import sys

n = int(sys.stdin.readline())


# DP = [0 for _ in range(n+1)]

# DP[1], DP[2] = 1, 3

DP = []
DP.append(1)
DP.append(3)

for i in range(2, n):
    DP.append(DP[i-1] + 2 * DP[i-2])

print(DP[n-1] % 10007)