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

    char cheese[10] = "Cheese";
    int cnt = 0;

    char cheeseTopping[101][101];

    for (int i = 0; i < number; i++) {
        bool inspect = true;

        int toplen = strlen(topping[i]);
        // 문자열이 "Cheese"로 끝나는지 확인
        for (int j = 0; j < 6; j++) {
            if (topping[i][toplen - 6 + j] != cheese[j]) {
                inspect = false;
            }
        }

        // 중복 확인
        bool checkDuplicate = false;
        if (inspect) {
            for (int k = 0; k < cnt; k++) {
                if (strcmp(cheeseTopping[k], topping[i]) == 0) {
                    checkDuplicate = true;
                    break;
                }
            }

            // 중복이 아닌 경우에만 추가
            if (!checkDuplicate) {
                strcpy(cheeseTopping[cnt], topping[i]);
                cnt++;
            }
        }
    }


    if(cnt >= 4) {
        printf("yummy");
        return 0;
    }

    printf("sad");

    return 0;
}
