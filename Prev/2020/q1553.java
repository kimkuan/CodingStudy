import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1553 {

	static int[][] arr = new int[8][7];
	
	// 으론쪽 or 아래와 비교
	public static void checkDomino(int x, int y, boolean[][] check) {

		int now = arr[x][y];
		
		// 오른쪽
		int right = arr[x][y+1];
		
		if(check[now][right] == false){
			check[now][right] = true;
			checkDomino(x, y+2, check);
		}
		if(check[right][now] == false) {
			check[right][now] = true;
			checkDomino(x, y+2, check);
		}
		
		// 아래
		int down = arr[x+1][y];

		if(check[now][down] == false){
			check[now][down] = true;
			checkDomino(x+1, y, check);
		}
		if(check[down][now] == false) {
			check[down][now] = true;
			checkDomino(x+1, y, check);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] check = new boolean[7][7]; // false 디폴트 
		
		for(int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 7; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		checkDomino(0, 0, check);
	}
}
