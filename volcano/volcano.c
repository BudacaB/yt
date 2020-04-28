#include <stdio.h>

int render_row_pounds (int n);

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
        render_row_pounds (i);

        printf("  ");

        render_row_pounds (i);

        printf("\n");
    }
}

int render_row_pounds (int n) {
    for (int i = 0; i <= n; i++) {
        printf("#");
    }
}