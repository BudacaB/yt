#include <stdio.h>

int main(void) {

    int h;

    do
    {
        printf("Height: ");
        scanf("%i", &h);
    }
    while (h < 1 || 8 < h);

    for (int i = 0; i < h; i++) {

        // blanks loop
        for (int k = 1; k < h - i; k++) {
            printf(" ");
        }

        // # loop
        for (int j = 0; j < i + 1; j++) {
            printf("#");
        }

        printf("\n");
    }

}