American Express numbers start with 34 or 37 -> 15-digit numbers

MasterCard numbers start with 51, 52, 53, 54, or 55 -> 16-digit numbers

Visa numbers start with 4 -> Visa uses 13 and 16 digit numbers


4003600000000014

4003600000000014 % 10 = 4
4003600000000014 / 100 = 40036000000000

1st case: 4 + 3 + 0 = 7
2nd case: 1 * 2 + 6 * 2 + 0 + 2 * 4 = 2 + 12 + 0 + 8 = 2 + 1 + 2 + 0 + 8 = 13
Final sum = 7 + 13 = 20

20 % 10 = 0
5 % 2 = 1


1st case:
1. Iterate through the CC number
2. Use modulo to get the last digit
3. Add last digit to sum
4. Divide the CC number by 100
5. Repeat

2nd case:
1. Divide the CC number by 10
2. Iterate through the CC number
3. Use modulo to get the last digit
4. Add last digit mutiplied by 2 to the sum
    4.1 Use modulo for the last digit
    4.2 Use division for the 1st digit
    4.3 Sum these up
5. Divide the CC number by 100
6. Repeat

12 % 10 = 2
12 / 10 = 1


length = 4
divisor = 10

1234
/ 1000 = 1
/ 100 = 12

1234
123
12
1
0