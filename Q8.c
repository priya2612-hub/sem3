#include <stdio.h>

int main()
{
    int a[100][100];
    int m, n, i, j;
    int top, bottom, left, right;

    printf("Enter number of rows and columns: ");
    scanf("%d %d", &m, &n);

    printf("Enter matrix elements:\n");

    for(i = 0; i < m; i++)
    {
        for(j = 0; j < n; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }

    top = 0;
    bottom = m - 1;
    left = 0;
    right = n - 1;

    printf("Spiral Order: ");

    while(top <= bottom && left <= right)
    {
        for(i = left; i <= right; i++)
            printf("%d ", a[top][i]);
        top++;

        for(i = top; i <= bottom; i++)
            printf("%d ", a[i][right]);
        right--;

        if(top <= bottom)
        {
            for(i = right; i >= left; i--)
                printf("%d ", a[bottom][i]);
            bottom--;
        }

        if(left <= right)
        {
            for(i = bottom; i >= top; i--)
                printf("%d ", a[i][left]);
            left++;
        }
    }

    printf("\n");

    return 0;
}
