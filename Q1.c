cat > Q1.c <<'EOF'
#include <stdio.h>
#include <string.h>

struct Book {
    char isbn[20];
    char title[100];
};

int findBook(struct Book catalog[], int n, char target[]) {
    int low = 0, high = n - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        int result = strcmp(catalog[mid].isbn, target);

        if (result == 0)
            return mid;
        else if (result < 0)
            low = mid + 1;
        else
            high = mid - 1;
    }

    return -1;
}

int main() {
    struct Book catalog[] = {
        {"0001112223", "Introduction to Algebra"},
        {"0002223334", "Beginning Python"},
        {"0003334445", "Classic Mythology"},
        {"0004445556", "Data and Society"},
        {"0005556667", "European History"}
    };

    int n = 5;
    char target[20];

    printf("Enter ISBN to search: ");
    scanf("%19s", target);

    int result = findBook(catalog, n, target);

    if (result != -1)
        printf("Book Found: %s\n", catalog[result].title);
    else
        printf("Not Found\n");

    return 0;
}
EOF
