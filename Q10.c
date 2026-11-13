#include <stdio.h>

int main()
{
    int n, i, j = 0;
    int a[100];

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter sorted array elements:\n");

    for(i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    if(n > 0)
    {
        for(i = 1; i < n; i++)
        {
            if(a[i] != a[j])
            {
                j++;
                a[j] = a[i];
            }
        }
    }

    printf("Length = %d\n", j + 1);

    printf("Array after removing duplicates: ");

    for(i = 0; i <= j && n > 0; i++)
    {
        printf("%d ", a[i]);
    }

    printf("\n");

    return 0;
}
