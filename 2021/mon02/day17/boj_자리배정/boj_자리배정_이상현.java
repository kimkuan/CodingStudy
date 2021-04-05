package mon02.day17.boj_자리배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_자리배정_이상현 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()); // 7 
		int C = Integer.parseInt(st.nextToken()); // 6
		int[][] arr = new int[R+1][C+1];
		boolean[][] visited = new boolean[R+1][C+1]; // 1,1을 기준으로 생각
		
		int K = Integer.parseInt(br.readLine()); // K번 대기번호를 가진 손님이 앉을 좌석은?
		int cnt = 1, dir = 0;
		int x = 1, y = 1;

		if(C*R < K) { // K를 만들 수 없는 경우
			System.out.println(0);
			return;
		}
		
		visited[1][1] = true; // 시작점
		
		while(cnt < K) {	
			while(y+1 <= C && !visited[x][y+1] && cnt != K) {visited[x][y++] = true; cnt++;}
			while(x+1 <= R  && !visited[x+1][y] && cnt != K) {visited[x++][y] = true; cnt++;}
			while(y-1 > 0 && !visited[x][y-1] && cnt != K) {visited[x][y--] = true; cnt++;}
			while(x-1 > 0 && !visited[x-1][y] && cnt != K) {visited[x--][y] = true; cnt++;}

		}
		System.out.print(x +" "+ y);
	}
}
