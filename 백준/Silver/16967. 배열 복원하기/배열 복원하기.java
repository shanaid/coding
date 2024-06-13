import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W, X, Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

//		int[][] tmp = new int[H][W]; // 복사할 배열
		int[][] map = new int[H + X][W + Y];  // 맵
		
		for (int r = 0; r < H + X; r++) { //map에다 매핑 시키는 과정
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < W + Y; c++) {
				map[r][c]= Integer.parseInt(st.nextToken());
			}
		}
		
		for (int r = X; r < H; r++) {
			for (int c = Y; c < W ; c++) {
				map[r][c] = map[r][c] - map[r-X][c-Y];
			}
		}
	
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				System.out.print(map[r][c]+ " ");
			}
			System.out.println();
		} 

	}
}
