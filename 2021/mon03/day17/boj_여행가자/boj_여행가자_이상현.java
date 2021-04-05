package mon03.day17.boj_여행가자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_여행가자_이상현 {

	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "YES";
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1]; // 1번도시 ~ N번도시
		
//		if(N == 0) {
//			str = "NO";
//			System.out.print(str);
//			return;
//		}
	
		for(int i = 1; i <= N; i++) {
			parent[i] = i; // 자기자신을 부모로 함 (초기화)
		}
		
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int connect = Integer.parseInt(st.nextToken());
				if(connect == 1)
					union(i, j);
			}
		}
		
		// 경로가 가능한지 확인 (= 경로에 있는 모든 도시의 부모가 같아야 가능)
		st = new StringTokenizer(br.readLine());
		int city1 = Integer.parseInt(st.nextToken());
		for(int i = 1; i < M; i++) {
			int city2 = Integer.parseInt(st.nextToken());
			
			if(find(city1) != find(city2)) {
				str = "NO";
			}
				
		}
		System.out.print(str);
	}
	
	private static int find(int x) {
		if(parent[x] == x) // 자기자신이 부모라면
			return x;
		return parent[x] = find(parent[x]); // 아니면 가장 최상위 부모를 넣기
	}
	
	private static void union(int city1, int city2) {
		int parent1 = find(city1); // city1의 최고 부모
		int parent2 = find(city2); // city2
		
		if(parent1 < parent2)
			parent[parent2] = parent1; // 작은 부모로 설정 (최고 부모를 바꿔줘야하는것!~~!~)
			// parent[city2] = parent1; (X)
		else if(parent1 > parent2)
			parent[parent1] = parent2;
	}
}
