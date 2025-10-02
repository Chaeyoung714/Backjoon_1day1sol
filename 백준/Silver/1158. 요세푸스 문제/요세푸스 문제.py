class Queue:
    def __init__(self):
        self.items = []
        self.front_index = 0
        
    def enqueue(self, val):
        self.items.append(val)
    def dequeue(self):
        if self.front_index == len(self.items):
            print("Q is empty")
        else:
            x = self.items[self.front_index]
            self.front_index += 1
            return x


def josephus_permutation(N, K):
    josephus_p = []
    q = Queue()
    for i in range(N):
        q.enqueue(i+1)
    while q.front_index != len(q.items):
        for i in range(K-1):
            x = q.dequeue()
            q.enqueue(x)
        kill = q.dequeue()
        josephus_p.append(kill)

    return josephus_p
        
N, K = list(map(int, input().split()))
result = josephus_permutation(N, K)

print("<", end="")
for i in range(len(result)):
    print(result[i], end="")
    if i < len(result)-1:
        print(", ", end="")
print(">")

        
        
        

        