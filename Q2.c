#include <stdio.h>

int main()
{
    int m, n, i, j;
    int grid[100][100];
    int total = 0, max, row = 0, col = 0;

    printf("Enter number of rows and columns: ");
    scanf("%d %d", &m, &n);

    printf("Enter grid elements:\n");

    for(i = 0; i < m; i++)
    {
        for(j = 0; j < n; j++)
        {
            scanf("%d", &grid[i][j]);

            total += grid[i][j];

            if(i == 0 && j == 0)
            {
                max = grid[i][j];
            }

            if(grid[i][j] > max)
            {
                max = grid[i][j];
                row = i;
                col = j;
            }
        }
    }

    printf("Total items = %d\n", total);
    printf("Maximum items = %d\n", max);
    printf("Maximum bin coordinate = (%d, %d)\n", row, col);

    return 0;
}
