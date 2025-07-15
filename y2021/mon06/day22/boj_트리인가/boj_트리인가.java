package y2021.mon06.day22.boj_트리인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class boj_트리인가 {

	static HashMap<Integer, Integer> comeInEdge = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> comeOutEdge = new HashMap<Integer, Integer>();
	static HashSet<Integer> node = new HashSet<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean isTree = true;
		int tc = 1, edgeCount = 0;

		exit:
		while(true) {
			String str = br.readLine();	
			if(str.equals("")) 
				continue;
			
			String[] edge = str.split("  ");
			for(int i = 0; i < edge.length; i++) {
				st = new StringTokenizer(edge[i]);
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());	
				
				if(u == -1 && v == -1) 
					break exit;
				
				if(u == 0 && v == 0) { // 테스트 케이스가 끝나는 시점
					// 2. 루트의 개수가 1개 인지 체크
					if(isTree)
						isTree = isThatTree(edgeCount);
	
					// 트리인지 아닌지에 따라, 결과값 가져오기
					sb.append(getResult(tc++, isTree)).append("\n"); 
					
					isTree = true; // 초기화
					edgeCount = 0;
					comeOutEdge.clear(); 
					comeInEdge.clear(); 
					node.clear();
					break;
				}
				
				if(u == v) // 사이클이 생기면 안됨
					isTree = false;
				
				// 1. 루트를 제외한 모든 노드가 들어오는 간선이 1개인지 체크 && 노드의 수-1 == 간선의 수
				node.add(u);
				node.add(v);
				edgeCount++;

				comeOutEdge.put(u, 1);
				if(comeInEdge.containsKey(v)) {  
					isTree = false;
					comeInEdge.put(v, comeInEdge.get(v));
				}else 
					comeInEdge.put(v, 1);
			}		
		}
		System.out.print(sb.toString());
	}
	
	private static boolean isThatTree(int edgeCount) {
		int count = 0;
		
		// 빈 트리는 트리이다
		if(edgeCount == 0)
			return true;
		
		// 간선의 개수 = 노드의 개수 - 1
		if(node.size() - 1 != edgeCount)
			return false;
		
		// 나가는 간선은 있는데, 들어오는 간선은 없다면 -> 루트노드
		for(Entry<Integer, Integer> set : comeOutEdge.entrySet()) {
			if(!comeInEdge.containsKey(set.getKey()))
				count++;
		}
		if(count == 1) return true;
		return false;
	}

	private static String getResult(int tc, boolean isTree) {
		StringBuilder sb = new StringBuilder();
		if(!isTree) sb.append("Case " + tc + " is not a tree.");
		else sb.append("Case " + tc + " is a tree.");
		return sb.toString();
	}
}
