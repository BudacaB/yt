Implement a program that encrypts messages using Caesar’s cipher


E(x) = (x+n) mod 26
D(x) = (x-n) mod 26

#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>


1. Check that we have a command line argument
2. Check that the command line argument is a number
3. Convert the key to an integer
4. Request the plaintext
5. Check for upper and lower case letters
6. Apply the formula
7. Output the ciphertext
