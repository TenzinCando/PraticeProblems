# Problem
Write a function that will return the median number for a application that collects movie reviews. This number will be real-time value as it will be called everytime a review is collected.

# Assumptions:
- The input will range between 1-10
- Reviews can have duplicate inputs
- If the collected reviews has a even size array, then pick either size/2

# Example
Input: 	1
Output: 1
Reviews:[1]

Input: 	4
Output: 1
Reviews:[1,4]

Input: 	6
Output: 4
Reviews:[1,4,6]

Input: 	3
Output: 3
Reviews:[1,3,4,6]

Input: 	3
Output: 3
Reviews:[1,3,3,4,6]

# Solution
Will be using two PriorityQueue to calculate the median number.

Test
- Test for negative inputs or out of range
- Test with 1 input size
- Test with 2 input size
- Test with 500 input size
