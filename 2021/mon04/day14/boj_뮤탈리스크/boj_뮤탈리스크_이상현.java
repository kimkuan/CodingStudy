package mon04.day14.boj_뮤탈리스크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_뮤탈리스크_이상현 {

	static int INF = 987654321;
	static int min;
	static int[] scv, hp;
	static int[][][] visited; // 미방문한 체력 -> 0, 방문한 체력 -> 1

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		scv = new int[3]; // 3개의 SCV의 HP 
		hp = new int[3];
        visited = new int[61][61][61]; // 체력 60
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			scv[i] = Integer.parseInt(st.nextToken());
		}
	
		min = INF;
		attack(scv[0], scv[1], scv[2], 0);
		System.out.println(min);
	}
	
	public static void attack(int a, int b, int c, int cnt) {
		a = Math.max(a, 0); // 음수면 0으로 변경
		b = Math.max(b, 0);
		c = Math.max(c, 0);

		if(a == 0 && b == 0 && c == 0) {
			min = Math.min(min, cnt);
			return;
		}
		hp[0] = a; 
		hp[1] = b; 
		hp[2] = c;
		
		Arrays.sort(hp); // 오름차순 정렬
		a = hp[2]; 
		b = hp[1]; 
		c = hp[0]; // 정렬된 순서로 다시 저장 (큰 수가 앞으로 오게)
		
		if(visited[a][b][c] == 1)  // 방문했으면 반환
			return;
		else 
			visited[a][b][c] = 1; // 방문하지 않았으면 방문처리
		
		if(min < cnt) // cnt가 min보다 이미 크다면 더 볼 필요 없음 
			return;
		
		attack(a-9, b-3, c-1, cnt+1);
		attack(a-9, b-3, c-1, cnt+1);
		attack(a-3, b-9, c-1, cnt+1);
		attack(a-3, b-1, c-9, cnt+1);
		attack(a-1, b-9, c-3, cnt+1);
		attack(a-1, b-3, c-9, cnt+1);
		
		return;
	}
}
