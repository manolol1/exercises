def reverse_num(num):
    rev = 0
    while num > 0:
        rev = (rev * 10) + (num % 10)
        num //= 10
    return rev

lb = 100
ub = 999

factor1 = lb
factor2 = lb
largestPalindrome = 0
temp_product = 0

while factor1 <= ub:
    factor2 = lb
    while factor2 <= ub:
        temp_product = factor1 * factor2

        if temp_product == reverse_num(temp_product):
            if temp_product > largestPalindrome: largestPalindrome = temp_product

        factor2 += 1

    factor1 += 1    


print(largestPalindrome)
