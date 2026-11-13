#include <stdio.h>

int main()
{
    int n, i, target;
    int a[100];
    int low, high, mid, position;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter sorted array elements:\n");

    for(i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    printf("Enter target value: ");
    scanf("%d", &target);

    low = 0;
    high = n - 1;
    position = n;

    while(low <= high)
    {
        mid = (low + high) / 2;

        if(a[mid] == target)
        {
            position = mid;
            break;
        }
        else if(a[mid] < target)
        {
            low = mid + 1;
        }
        else
        {
            position = mid;
            high = mid - 1;
        }
    }

    printf("Insert Position = %d\n", position);

    return 0;
}
