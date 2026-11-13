#include <stdio.h>

int main()
{
    int n, target, i, j, found = 0;
    int a[100];

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter array elements:\n");

    for(i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    printf("Enter target sum: ");
    scanf("%d", &target);

    for(i = 0; i < n; i++)
    {
        for(j = i + 1; j < n; j++)
        {
            if(a[i] + a[j] == target)
            {
                printf("Pair Found: %d + %d = %d\n",
                       a[i], a[j], target);
                found = 1;
                break;
            }
        }

        if(found == 1)
            break;
    }

    if(found == 0)
    {
        printf("No Pair Found\n");
    }

    return 0;
}
