#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

int main (int argc, char *argv[])
{
    // check for arguments and key length
    if (argc == 2 && strlen(argv[1]) == 26)
    {
        // check for non-duplicate alphabet letters
        bool valid = false;
        for (int i = 0; i < strlen(argv[1]); i++)
        {
            for (int j = i + 1; j < strlen(argv[1]) + 1; j++)
            {
                if (isalpha(argv[1][i]) && tolower(argv[1][i]) != tolower(argv[1][j]))
                {
                    valid = true;
                }
                else
                {
                    printf("Usage ./substitution key\n");
                    return 1;
                }
                
            }
        }

        // get plaintext
        char input[500];
        printf("plaintext: ");
        fgets(input, sizeof(input), stdin); 
        printf("\n");

        // encrypt letter
        for (int i = 0; i < strlen(input); i++)
        {
            if (islower(input[i]))
            {
                input[i] = tolower(argv[1][input[i] - 97]);
            }
            else if (isupper(input[i]))
            {
                input[i] = toupper(argv[1][input[i] - 65]);
            }
        }

        // output ciphertext
        printf("ciphertext: %s", input);
        printf("\n");
        return 0;
    }
    else
    {
        printf("Usage ./substitution key\n");
        return 1;
    }
    
}