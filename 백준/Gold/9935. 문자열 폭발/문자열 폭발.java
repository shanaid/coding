import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] text = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        int boomSize = boom.length;
        char[] stack = new char[text.length];
        int top = 0;
        for(char i : text ){
            stack[top++] = i;

            a:if(top >= boomSize){ //boom을 버티면
                if(boom[boomSize-1] == stack[top-1]){ // 만약 끝에가 같다하믄
                    for(int t = 1; t<boomSize; t++){ // 전에 부터 쏵 비교해
                        if(stack[top-1-t] != boom[boomSize-1-t]){ //비교해서 하나라도 틀리면
                            break a; //break
                        }
                    }
                    // 여기있다는건 터졌다는 거
                    top -= boomSize;
                }
            }


        }
        if (top == 0) {
            System.out.print("FRULA");
        } else {
            StringBuilder sb = new StringBuilder(top);
            for (int i = 0; i < top; i++) sb.append(stack[i]);
            System.out.print(sb.toString());

        }

    }
}
