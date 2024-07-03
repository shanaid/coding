import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
// static으로 설정
	static int min = Integer.MAX_VALUE;
	static char[][] b;

	public static void main(String[] args) throws IOException {
//버퍼 리더, 토크나이저 설정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//가로 세로 길이 설정
		int rr = Integer.parseInt(st.nextToken());
		int cc = Integer.parseInt(st.nextToken());
//해당 설정 길이로 배열 만들기
		b = new char[rr][cc];
//해당 값을 그대로 받아와서 집어 넣기
		for (int k = 0; k < rr; k++) {
			b[k] = br.readLine().toCharArray();
		}

// 8칸을 비교해야 하므로, 시작점을 맨 왼쪽 끝으로 넣어서 다 돌리려면
// 배열 어레이 초과를 막기 위해 -8, -8 한다
		for (int r = 0; r <= rr - 8; r++) {
			for (int c = 0; c <= cc - 8; c++) {
//bw 만든 메소드와 여태의 min값과 비교해서 최소값 제출
				min = Math.min(bw(r, c), min);
			}
		}
		System.out.println(min);
	}
//해당 좌표를 받으면
	static int bw(int r, int c) {

		int cnt = 0;
		char f;
		char s;

// 첫 값이 W인지 B인지 확인합니다.

			f = 'W';
			s = 'B';

//그에 따라 f, s 값이 정해집니다.

		int jj=0;
		int hh=0;		
		if (c%2==1){jj++;}
		if (hh%2==1){hh++;}
//맵의 x축과 y축이 홀수면 +1을 해줍니다.		

//8칸을 돌고
		for (int k = r; k < r + 8; k++) {
			// 만약에 행이 짝수일때 (jj가 홀수라면 )
			if (k % 2 == jj) {
				// 0,2,4,6

				for (int j = c; j < c+8; j++) {

					if (j % 2 == hh) {
						if (b[k][j] == s) {
							cnt++;
						}
					} else {
						if (b[k][j] == f) {
							cnt++;
						}
					}
				}
				// 만약에 행이 홀수일때
			} else {
				for (int j = c; j < c+8; j++) {

					if (j % 2 == hh) {
						if (b[k][j] == f) {
							cnt++;
						}
					} else {
						if (b[k][j] == s) {
							cnt++;
						}
					}
				}
			}
		}

		return Math.min(cnt, 64 - cnt);// 시작이 다르니까

	}

}