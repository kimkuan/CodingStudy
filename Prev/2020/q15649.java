import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15649 {

	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] check; // 1~9까지
	static int[] answer;
	
	static void dfs(boolean[] checked, int cnt) { // cnt : 현재까지 저장한 원소의 갯수		
		if(cnt == m) {
			for(int i = 0; i < m; i++) 
				sb.append(answer[i]).append(' ');
			sb.append('\n');
		}
		
		for(int i = 1; i <= n; i++) {
			if(checked[i] == false) { // 조건 : 방문하지 않았을 경우만
				answer[cnt] = i; 
				checked[i] = true; // 중요! 
				dfs(checked, cnt+1);
				checked[i] = false; // 중요! 
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		check = new boolean[n+1];
		answer = new int[n+1];
		
		dfs(check, 0);
		System.out.print(sb);
	}
}

/*
 * 백트래킹 (Backtracking)
 * : 조건이 만족할 때의, 모든 조합의 수를 살피는 것  
 * : 해를 찾아가는 도중, 지금 경로가 해가 될 것 같지 않으면 그 경로를 더이상 가지 않고 되돌아오는 것
 * 
 * => 일반적으로 DFS를 통하여 구현한다. (BFS의 경우 상대적으로 많은 메모리가 필요하기 때문에)
 *
*/