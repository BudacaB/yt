#include <stdio.h>
#include <stdbool.h>
#include <string.h>

// create a constant
#define MAX 9

// create a structure
typedef struct
{
    char name[50];
    int votes;
}
candidate;

candidate candidates[MAX];

int candidates_count;

bool vote (char name[]);
void print_winner(void);

int main(int argc, char *argv[])
{
    // check for arguments count
    if (argc < 3)
    {
        printf("Usage: ./plurality [candidate ... ]\n");
        return 1;
    }

    // check for max candidates
    candidates_count = argc - 1;
    if (candidates_count > MAX)
    {
        printf("Max of 9 candidates allowed\n");
        return 2;
    }

    // populate candidates
    for (int i = 0; i < candidates_count; i++)
    {
        strcpy(candidates[i].name, argv[i + 1]);
        candidates[i].votes = 0;
    }

    // get number of voters
    int voters_count;
    printf("Number of voters: ");
    scanf("%i", &voters_count);

    for (int i = 0; i < voters_count; i++)
    {
        // get vote
        char name[50];
        printf("Vote: ");
        scanf("%s", name);

        // validate the vote
        if (!vote(name))
        {
            printf("Invalid vote\n");
        }
    }
    // print the winners
    print_winner();
}

bool vote (char name[])
{
    for (int i = 0; i < candidates_count; i++)
    {
        // checking if there's a match for the candidate name
        if (strcmp(candidates[i].name, name) == 0)
        {
            // increment the votes
            candidates[i].votes++;
            return true;
        }
    }
    return false;
}

void print_winner(void)
{
    // check for most votes
    int most_votes= 0;
    for (int i = 0; i < candidates_count; i++)
    {
        if (candidates[i].votes > most_votes)
        {
            most_votes = candidates[i].votes;
        }
    }

    // check for the candidates with the most votes
    for (int i = 0; i < candidates_count; i++)
    {
        if (candidates[i].votes == most_votes)
        {
            printf("%s\n", candidates[i].name);
        }
    }
}