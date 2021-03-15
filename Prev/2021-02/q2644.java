import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [S2] 촌수계산 */

public class q2644 {
	
	static int n, from, to;
	static int[][] relation;
	static boolean[] visited;
	static int result = -1;
	
	public static void countChon() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {from, 0});
		
		while(!q.isEmpty()) {
			int now = q.peek()[0];
			int len = q.peek()[1];
			q.poll();
			
			if(visited[now]) continue;
			visited[now] = true;
			
			for(int i = 1; i <= n; i++) {
				if(relation[now][i] == 1 && !visited[i]) { 
					if(i == to) {
						result = len+1;
						return;
					}
					q.add(new int[] {i, len+1});
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 사람의 수
		relation = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine()); // 관계 개수
		for(int i = 0 ; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			relation[p1][p2] = 1;
			relation[p2][p1] = 1;
		}
		countChon();
		System.out.print(result);
	}
}
