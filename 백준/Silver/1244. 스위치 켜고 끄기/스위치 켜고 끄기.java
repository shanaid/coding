import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] sw = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int a = 0; a < N; a++) {
			sw[a] = Integer.parseInt(st.nextToken());
		}
		
		

		int P = Integer.parseInt(br.readLine());

		
		for (int i = 0; i < P; i++) {
			
			
			st = new StringTokenizer(br.readLine());
			
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken())-1;

			
			if (sex == 1) {
				
				for (int k = num; k < N; k += num+1) {
					if (sw[k] == 1) {
						sw[k] = 0;
					} else {
						sw[k] = 1;}
				}
			} else {
				if (sw[num] == 0) {
					sw[num] = 1;
				} else {
					sw[num] = 0;
				}
				// 여기서 조건
				// 1. N밖을 안벗어나기.
				// 2. 0 안으로 들어오기
				// 3. 서로가 같아야지만 가능
				int b = num - 1;
				int f = num + 1;
				while (b >= 0 && f < N && sw[b] == sw[f]) {
					if (sw[b] == 1) {
						sw[b] = 0;
						sw[f] = 0;
					} else {
						sw[b] = 1;
						sw[f] = 1;
					}
					f++;
					b--;
				}
				

			}


		}
		
		for (int j = 0; j < N; j++) {
			System.out.print(sw[j]+" ");
			if(j%20==19) {
				System.out.println();
			}
		}

	}
}
