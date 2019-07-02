# Problem
Write code that will perform division without using any multiplication, division and mod operator.

# Assumptions:
- Both dividend and divisor will be 32-bit signed integers.
- The divisor will never be 0.
- Your function returns 2^31 − 1 when the division result overflows.

# Example
Input: 	dividend = 10, divisor = 3
Output: 3

Input: 	dividend = 7, divisor = -3
Output: -2

# Solution

Consider
- when dividend is the max_int OR min_int
- DONE when dividend and divisor is the same number but one is negative
- DONE negative divisor
- DONE negative dividend
- DONE negative divisor and dividend 
- DONE divisor is 0 OR dividend is 0
- DONE divisor is 0 AND dividend is 0
- DONE divisor and dividend are the same
