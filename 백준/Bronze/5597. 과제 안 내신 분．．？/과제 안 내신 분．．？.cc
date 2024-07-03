#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main()
{
    bool stu[31];               //stu 학생수로써 31명 선언 왜냐면 stu0 은 쓰지 않을 예정
    int yes = 0;               // yes = 과제 한 숫자 번호

    for (int a = 1;a <= 30;a++) { stu[a] = false; }   // 학생수 초기화

    for (int s = 1;s < 29;s++) {                        //숙제 한 사람 입력 받기 저요!
        scanf("%d", &yes);                              // 숙제 한 사람 번호 외치기 (단 1~30번, 중복 X)
        while (1 > yes || yes > 30 || stu[yes] == true) {
            scanf("%d", &yes);
        }
          
        stu[yes] = true;
    }

    for (int k = 1;k <= 30;k++) {
        if (stu[k] == false) {
            printf("%d\n",k);
        }
    }
                                    
    return 0;
}