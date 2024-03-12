num = 600851475143
divisor = 2

while num >= divisor * divisor:
    if num % divisor != 0:
        divisor += 1
    else:
        num /= divisor

print(num)