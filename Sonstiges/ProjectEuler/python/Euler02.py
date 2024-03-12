lb = 1
ub = 4000000
curr = lb
previous = lb
temp = 0
sum_even = 0

while curr < ub:
    temp = curr
    curr = curr + previous
    previous = temp

    if curr % 2 == 0:
        sum_even += curr

print(sum_even)