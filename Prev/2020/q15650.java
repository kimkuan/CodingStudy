import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15650 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] check;
	static int[] answer;
	
	static void dfs(int cnt, int pre) {
		if(cnt == m) {
			for(int i = 0; i < m; i++)
				sb.append(answer[i]).append(' ');
			sb.append('\n');
		}
		
		for(int i = pre; i <= n; i++) {
			if(check[i] == false) { // 이전에 선택한 보다 클 때
				answer[cnt] = i;
				check[i] = true;
				dfs(cnt+1, i);
				check[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		check = new boolean[n+1];
		answer = new int[n+1];
	
		dfs(0, 1);
		
		System.out.print(sb);
	}
}
