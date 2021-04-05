package mon03.day8.boj_집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_집합의표현_이상현 {
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i = 1; i <= n; i++) 
			parent[i] = i; // 부모를 자신으로 초기화 
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
		
			if(cmd == 0) 
				union(num1, num2);
			else
				sb.append(getParent(num1) == getParent(num2) ? "YES" : "NO").append("\n");
			System.out.println(Arrays.toString(parent));
		}
		System.out.print(sb);
	}
	
	private static int getParent(int x) {
		if(x == parent[x]) return x; // 부모가 자기 자신 (자신이 루트임)
		return parent[x] = getParent(parent[x]); // 아니라면 현재 부모의 부모로 올라감, 그리고 부모 갱신
												 // 결국 현재 노드의 루트에서 같은 부모를 갖는지 확인하는 것
	}
	
	private static void union(int a, int b) {
		int aParent = getParent(a);
		int bParent = getParent(b);
		
		if(aParent == bParent) return; // 부모가 같으면 (더이상 합칠 필요 없음)
		else if(aParent < bParent) parent[bParent] = aParent; // 하나의 부모를 갖도록 합치기 (작은 수 기준)
		else parent[aParent] = bParent; 
	}
}
