import sys
input = sys.stdin.readline

n = int(input())

DP = [0 for _ in range(n+1)]

DP[0] = 1
DP[1] = 3

for i in range(2,n+1):
    """
    DP[i] = (DP[i-2] * 3) + {(DP[i-1] - DP[i-2]) * 2}
    """

    DP[i] = (DP[i-2] + DP[i-1]*2) % 9901

    
print(DP[n])