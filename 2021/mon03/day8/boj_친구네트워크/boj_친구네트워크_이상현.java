package mon03.day8.boj_친구네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class boj_친구네트워크_이상현 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static HashMap<String, String> parent = new HashMap<>();
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			int F = Integer.parseInt(br.readLine());
			String person1, person2;
			
			for(int i = 0; i < F; i++) {
				st = new StringTokenizer(br.readLine());
				person1 = st.nextToken();
				person2 = st.nextToken();
				
				union(person1, person2);
				
				sb.append(ans).append("\n");
			}
			parent.clear();
		}
		System.out.print(sb);
	}
	
	private static String getParent(String x) {
		if(!parent.containsKey(x)) {
			parent.put(x, x);
			return x;
		}
		else if(x.equals(parent.get(x))) return x;
		parent.put(parent.get(x), getParent(parent.get(x))); // 자신이 루트가 아니면 부모 노드로 올라가고 부모노드의 부모노드로 갱신
		return parent.get(x);
	}
	
	private static void union(String a, String b) {
		String aParent = getParent(a);
		String bParent = getParent(b);
		
		if(aParent.equals(bParent)) return;
		else if(aParent.compareTo(bParent) < 0) {
			parent.put(bParent, aParent);
			getTotal(aParent); // 작은 값 기준
		}
		else {
			parent.put(aParent, bParent);
			getTotal(bParent);
		}
	}
	
	// 친구 네트워크에 몇 명이 있는지 -> 작은 값 기준으로 탐색 
	private static void getTotal(String x) {
		int cnt = 0;
		for(Entry<String, String> p : parent.entrySet()) {
			if(p.getValue().equals(x)) cnt++;
			else if(getParent(p.getValue()).equals(x)) cnt++;
		}
		ans = cnt;
	}
}

/*
[반례]

1
8
a b
b c
d e
e f
g h
h i 
a f 
c i

1
8
a b
b c
d e
e f
g h
h i 
a f <- 여기서 f, d, e는 a로 변해야함
c i <- 여기서 i, g, h는 a로 변해야함 

[답]
2
3
2
3
2
3
6
9
*/