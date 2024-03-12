lb = 1
ub = 1000
ctr = lb
sum = 0

while ctr < ub:
    if ctr % 3 == 0 or ctr % 5 == 0:
        sum += ctr
    ctr += 1

print(sum)
