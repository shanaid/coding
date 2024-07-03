
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] girl = new int[6];
		int[] boy = new int[6];

		// 리스트에 다 연결
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			if (Integer.parseInt(st.nextToken()) == 0) {
				girl[Integer.parseInt(st.nextToken()) - 1]++;
				continue;
			}
			boy[Integer.parseInt(st.nextToken()) - 1]++;
		}

		for (int i = 0; i < 6; i++) {
			
			cnt += girl[i]/K;
			cnt += boy[i]/K;
			if(girl[i] % K !=0) cnt++; 
			if(boy[i] % K !=0) cnt++; 
			
			}
		System.out.print(cnt);
		}
		
	}
