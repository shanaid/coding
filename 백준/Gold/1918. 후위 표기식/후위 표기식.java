import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 작성자: 박예본
 * 이메일: goodyebon123@naver.com
 * 생성일: 25. 10. 17. 오후 4:14
 * 파일명: BJ_1918_후위표기식
 */
public class Main {
    static HashMap<Character,Integer> level = new HashMap();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        level.put('*',2);
        level.put('/',2);
        level.put('+',1);
        level.put('-',1);

        char[] word = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>(); // 연산자

        for(int i =0; i< word.length; i++){

            if('A'<= word[i] && word[i] <= 'Z'){
                sb.append(word[i]);
                continue;
            }

           switch(word[i]){
               case '(':
                   stack.add('(');
                   continue;
               case ')':
                   while( !stack.isEmpty() && stack.peek() != '(' ){
                       sb.append(stack.pop());
                   }
                   if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                   continue;
               case '*':
               case '/':
                   while (!stack.isEmpty()
                           && stack.peek() != '('
                           && level.get(stack.peek()) >= level.get(word[i])) {
                       sb.append(stack.pop());
                   }
                   stack.push(word[i]); // ✅ 빠져있던 부분 추가
                   continue;
                   /*
                   * [ 1 * 2 + 3 ] 12*3+
                   * [ 1 + 2 * 3 ] 123*+
                   * */
               case '+':
               case '-':
                   while (!stack.isEmpty()
                           && stack.peek() != '('
                           && level.get(stack.peek()) >= level.get(word[i])) {
                       sb.append(stack.pop());
                   }

                   stack.push(word[i]); // ✅ 빠져있던 부분 추가

           }


        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
