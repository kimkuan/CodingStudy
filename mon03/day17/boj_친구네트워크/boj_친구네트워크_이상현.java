package mon03.day17.boj_친구네트워크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_친구네트워크_이상현 {

	static HashMap<String, String> parent = new HashMap<String, String>(); 
	static HashMap<String, Integer> friends = new HashMap<String, Integer>(); 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			int F = Integer.parseInt(br.readLine()); // 친구 수
			
			for(int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				
				if(!parent.containsKey(name1)) {
					parent.put(name1, name1); // 상위 친구는 자신
					friends.put(name1, 1); // 친구는 1명
				}
				if(!parent.containsKey(name2)) {
					parent.put(name2, name2); // 상위 친구는 자신
					friends.put(name2, 1); // 친구는 1명
				}
				
				union(name1, name2);
				sb.append(friends.get(find(name1))).append("\n");
				// sb.append(friends.get(parent.get(name1))).append("\n"); (X)
				// name1과 name2 중 어떤 것이 더 사전순으로 앞에오는 애인지 모르기 때문에
			}
			parent.clear();
			friends.clear();
		}
		System.out.print(sb);
	}
	
	private static String find(String name) {
		if(name == parent.get(name)) // 최상위 부모가 자신이면
			return name;
		parent.put(name, find(parent.get(name))); // 최상위 부모로 갱신
		return parent.get(name); // 최상위 부모 반환
	}
	
	private static void union(String name1, String name2) {
		name1 = find(name1);
		name2 = find(name2);

		if(name1.compareTo(name2) < 0) { // name1이 사전에서 더 앞에 위치
			friends.put(name1, friends.get(name1) + friends.get(name2)); // 친구 수 합치기
			parent.put(name2, name1); // 부모 갱신
		}
		else if(name1.compareTo(name2) > 0) {
			friends.put(name2, friends.get(name1) + friends.get(name2)); // 친구 수 합치기
			parent.put(name1, name2); // 부모 갱신
		}
	}
}
