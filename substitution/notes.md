Write a program that implements a substitution cipher.

1. Key must be 26 characaters long
2. Key must be only letters - and no duplicates
3. Plaintext letter cases must be maintained when converting to ciphertext

---

abcdefghijklmnopqrstuvwxyz


JTREKYAVOGDXPSNCUIZLFBMWHQ / jtrekyavogdxpsncuizlfbmwhq
HELLO -> VKXXN

YTNSHKVEFXRBAUQZCLWDMIPGJO
HELLO -> EHBBQ

VCHPRZGJNTLSKFBDQWAXEUYMOI
hello, world -> jrssb, ybwsp

---

1. Check for arguments
2. Check key validity
    2.1 Check that it's 26 characters long
    2.2 Check that it's only letters
    2.3 Check that there are no duplicates
3. Get the plaintext from the user
4. Iterate through the plaintext and convert
    4.1 Map to the substitution alphabet
    4.2 Maintain lower or upper case for the plaintext
5. Output the ciphertext
