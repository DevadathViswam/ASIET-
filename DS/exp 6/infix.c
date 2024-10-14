#include <stdio.h>

#define MAX 100


typedef struct {
    char arr[MAX][10]; 
    int top;
} Stack;


void initStack(Stack* s);
int isFull(Stack* s);
int isEmpty(Stack* s);
void push(Stack* s, const char* value);
char* pop(Stack* s);
void evaluatePostfix(char* expression);
void convertToInfix(char* expression);

int main() {
    char postfix[MAX];

    printf("Enter a postfix expression: ");
    scanf("%s", postfix);

    
    evaluatePostfix(postfix);
    
    
    convertToInfix(postfix);

    return 0;
}


void initStack(Stack* s) {
    s->top = -1;
}


int isFull(Stack* s) {
    return s->top == MAX - 1;
}


int isEmpty(Stack* s) {
    return s->top == -1;
}


void push(Stack* s, const char* value) {
    if (!isFull(s)) {
        for (int i = 0; value[i] != '\0' && i < 10; i++) {
            s->arr[s->top + 1][i] = value[i];
        }
        s->arr[s->top + 1][10] = '\0'; 
        s->top++;
    }
}


char* pop(Stack* s) {
    if (!isEmpty(s)) {
        return s->arr[s->top--];
    }
    return NULL;
}


int stringToInt(const char* str) {
    int num = 0;
    while (*str) {
        num = num * 10 + (*str - '0');
        str++;
    }
    return num;
}


void evaluatePostfix(char* expression) {
    Stack s;
    initStack(&s);
    int i;

    for (i = 0; expression[i]; i++) {
        if (expression[i] >= '0' && expression[i] <= '9') {
            char num[2] = {expression[i], '\0'};
            push(&s, num);
        } else {
            char* op2 = pop(&s);
            char* op1 = pop(&s);
            int result;

            switch (expression[i]) {
                case '+':
                    result = stringToInt(op1) + stringToInt(op2);
                    break;
                case '-':
                    result = stringToInt(op1) - stringToInt(op2);
                    break;
                case '*':
                    result = stringToInt(op1) * stringToInt(op2);
                    break;
                case '/':
                    result = stringToInt(op1) / stringToInt(op2);
                    break;
            }

            char resultStr[10];
            sprintf(resultStr, "%d", result);
            push(&s, resultStr);
        }
    }

    printf("Result: %s\n", pop(&s));
}


void convertToInfix(char* expression) {
    Stack s;
    initStack(&s);
    int i;

    for (i = 0; expression[i]; i++) {
        if (expression[i] >= '0' && expression[i] <= '9') {
            char num[2] = {expression[i], '\0'};
            push(&s, num);
        } else {
            char op2[10], op1[10];
            
            char* poppedOp2 = pop(&s);
            char* poppedOp1 = pop(&s);
            
            char infix[30];
            sprintf(infix, "(%s %c %s)", poppedOp1, expression[i], poppedOp2);
            push(&s, infix);
        }
    }

    printf("Infix expression: %s\n", pop(&s));
}



