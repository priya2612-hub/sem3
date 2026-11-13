#include <stdio.h>

int main()
{
    int n, target, i;
    int a[100];
    int left, right, sum, found = 0;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter sorted array elements:\n");

    for(i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    printf("Enter target sum: ");
    scanf("%d", &target);

    left = 0;
    right = n - 1;

    while(left < right)
    {
        sum = a[left] + a[right];

        if(sum == target)
        {
            printf("Pair Found: (%d, %d)\n", a[left], a[right]);
            found = 1;
            break;
        }
        else if(sum < target)
        {
            left++;
        }
        else
        {
            right--;
        }
    }

    if(found == 0)
    {
        printf("Not Found\n");
    }

    return 0;
}
