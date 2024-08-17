#include <stdio.h>

#define MAX 100 

typedef struct {
    int row;
    int col;
    int value;
} Element;

int main() {
    int n;  
    Element sparse[MAX], transpose[MAX];

    
    printf("Enter the number of non-zero elements: ");
    scanf("%d", &n);

    
    printf("Enter the row, column, and value of each non-zero element:\n");
    for (int i = 0; i < n; i++) {
        printf("Element %d: ", i + 1);
        scanf("%d %d %d", &sparse[i].row, &sparse[i].col, &sparse[i].value);
    }

    
    int t = 0; 
    for (int i = 0; i < n; i++) {
        transpose[t].row = sparse[i].col;
        transpose[t].col = sparse[i].row;
        transpose[t].value = sparse[i].value;
        t++;
    }

    
    printf("Transpose of the sparse matrix:\n");
    for (int i = 0; i < t; i++) {
        printf("Element %d: Row=%d, Col=%d, Value=%d\n", i + 1, transpose[i].row, transpose[i].col, transpose[i].value);
    }

    return 0;
}

