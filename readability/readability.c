#include <stdio.h>
#include <string.h>
#include <math.h>

long calculate_letters(char text[]);
long calculate_words(char text[]);
long calculate_sentences(char text[]);

int main(void)
{
    // get input text
    char text[500];
    do
    {
        printf("Input text:");
        fgets(text, sizeof(text), stdin);
    }
    while (strlen(text) - 1 == 0);

    // run the functions
    long letters = calculate_letters(text);
    long words = calculate_words(text);
    long sentences = calculate_sentences(text);

    // run the calculations
    float letter_count = 0.0588 * (float) letters / words * 100;
    float sentence_count = 0.296 * (float) sentences / words * 100;
    float index = letter_count - sentence_count - 15.8;
    int grade = round(index);

    // output
    if (grade < 1)
    {
        printf("Before Grade 1\n");
    }
    else if (16 <= grade) 
    {
        printf("Grade 16+\n");
    }
    else 
    {
        printf("Grade %i\n", grade);
    }
}

// calculate the letters
long calculate_letters(char text[])
{
    long letters = 0;
    for (long i = 0; i < strlen(text); i++)
    {
        if ((64 < text[i] && text[i] < 91) || (96 < text[i] && text[i] < 123))
        {
            letters++;
        }
    }
    return letters;
}

// calculate the words
long calculate_words(char text[])
{
    long words = 1;
    for (long i = 0; i < strlen(text); i++)
    {
        if (text[i] == 32)
        {
            words++;
        }
    }
    return words;
}

// calculate the sentences
long calculate_sentences(char text[])
{
    long sentences = 0;
    for (long i = 0; i < strlen(text); i++)
    {
        if (text[i] == 33 || text[i] == 46 || text[i] == 63)
        {
            sentences++;
        }
    }
    return sentences;
}