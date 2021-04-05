import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class q9372 {
	static boolean[] check;
	static ArrayList<ArrayList<Integer>> arr;
	static int cnt = 0;
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		check[node] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i = 0; i < arr.get(now).size(); i++) {
				if(check[arr.get(now).get(i)] == false) {
					q.add(arr.get(now).get(i));
					check[arr.get(now).get(i)] = true;
				}
			}
			cnt++;
			System.out.println("Cnt : " + cnt);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m =  Integer.parseInt(st.nextToken());

			arr = new ArrayList<ArrayList<Integer>>();
			check = new boolean[n+1]; // 방문 체크 (false default)
			
			for(int i = 0; i < n+1; i++) 
				arr.add(new ArrayList<Integer>());
			
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int des = Integer.parseInt(st.nextToken());
				
				arr.get(start).add(des);
				arr.get(des).add(start);
			}			
			bfs(1);
			System.out.println(cnt-1);
			
			cnt = 0;
		}
	}

}
