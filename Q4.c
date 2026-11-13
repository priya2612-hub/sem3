#include <stdio.h>
#include <string.h>

struct Employee
{
    char id[20];
    char department[30];
};

int main()
{
    struct Employee emp[100];
    int n, i, found = 0;
    char searchId[20];

    printf("Enter number of employees: ");
    scanf("%d", &n);

    for(i = 0; i < n; i++)
    {
        printf("Enter employee ID: ");
        scanf("%19s", emp[i].id);

        printf("Enter department: ");
        scanf("%29s", emp[i].department);
    }

    printf("Enter employee ID to search: ");
    scanf("%19s", searchId);

    for(i = 0; i < n; i++)
    {
        if(strcmp(emp[i].id, searchId) == 0)
        {
            printf("Department: %s\n", emp[i].department);
            found = 1;
            break;
        }
    }

    if(found == 0)
    {
        printf("Unknown\n");
    }

    return 0;
}
