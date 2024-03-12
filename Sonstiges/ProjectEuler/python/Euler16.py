num = 2
power = 1000

power_result = pow(num, power)
digit_sum = 0

print(power_result)

# calculate digit sum of power_result
while power_result > 0:
    digit_sum += power_result % 10
    power_result //= 10

print(digit_sum)