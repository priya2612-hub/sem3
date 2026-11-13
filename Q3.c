#include <stdio.h>
#include <string.h>

int main()
{
    int n, i, j, duplicate = 0;
    char ids[100][30];

    printf("Enter number of transactions: ");
    scanf("%d", &n);

    printf("Enter transaction IDs:\n");

    for(i = 0; i < n; i++)
    {
        scanf("%29s", ids[i]);
    }

    for(i = 0; i < n; i++)
    {
        for(j = i + 1; j < n; j++)
        {
            if(strcmp(ids[i], ids[j]) == 0)
            {
                duplicate = 1;
                break;
            }
        }

        if(duplicate == 1)
            break;
    }

    if(duplicate == 1)
        printf("Duplicate Found: true\n");
    else
        printf("Duplicate Found: false\n");

    return 0;
}
