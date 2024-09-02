#include <iostream>

using namespace std;

int main() {
    char ch;
    cin >> ch;  // 사용자가 입력한 문자 하나를 변수 ch에 저장
    
    cout << ch-'0'+'0' << endl;  // ch의 아스키 코드 값을 정수형으로 변환하여 출력
    
    return 0;
}