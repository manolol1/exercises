import math

# Prime number check from Euler07.py
def is_prime(num):
    divider = 2
    if num <= 1: return False
    while divider <= int(math.sqrt(num)):
        if num % divider == 0:
            return False
        divider += 1
    return True

lb = 1
ub = 2000000 # 2 million
ctr = lb
sum = 0

while ctr < ub:
    if is_prime(ctr):
        sum += ctr
    ctr += 1

print(sum)
