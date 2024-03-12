import math

# Determine wether num is a prime number and return True/False
def is_prime(num):
    divider = 2
    if num <= 1: return False
    while divider <= int(math.sqrt(num)):
        if num % divider == 0:
            return False
        divider += 1
    return True

prime_number_searched = 10001
prime_number_found = 0
curr_prime_number = 0
curr_num_to_check = 2

# get every single prime number from the 1st to the 10001st
while prime_number_found < prime_number_searched:
    if is_prime(curr_num_to_check): 
        prime_number_found += 1
        curr_prime_number = curr_num_to_check
    curr_num_to_check += 1

print(curr_prime_number)