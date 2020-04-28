#include <stdio.h>

int main(void)
{
    int number;
    int reversed = 0;

    do
    {
        printf("Please provide the number to be reversed\n");
        scanf("%i", &number);
    }
    while (number == 0);

    while (number != 0)
    {
        reversed = reversed * 10;
        reversed = reversed + number % 10;
        number /= 10;
    }

    printf("The reversed number is %i\n", reversed);
}