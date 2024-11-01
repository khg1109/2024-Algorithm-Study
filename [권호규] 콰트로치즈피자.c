#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(void) {
    int number;
    scanf("%d", &number);
    char topping[101][101];

    for (int i = 0; i < number; i++) {
        scanf("%s", topping[i]);
    }

    char ch[10] = "Cheese";
    int cnt = 0;
    bool inspect = true;

    char cheeseTopping[101][101];

    for (int i = 0; i < number; i++) {
        inspect = true;

        // 문자열이 "Cheese"로 끝나는지 확인
        for (int j = 0; j < 6; j++) {
            if (topping[i][strlen(topping[i]) - 6 + j] != ch[j]) {
                inspect = false;
            }
        }

        // 중복 확인
        bool Duplicate = false;
        if (inspect) {
            for (int k = 0; k < cnt; k++) {
                if (strcmp(cheeseTopping[k], topping[i]) == 0) {
                    Duplicate = true;
                    break;
                }
            }

            // 중복이 아닌 경우에만 추가
            if (!Duplicate) {
                strcpy(cheeseTopping[cnt], topping[i]);
                cnt++;
            }
        }
    }
    if(cnt >= 4) {
        printf("yummy");
    }
    else {
        printf("sad");
    }
    return 0;
}
