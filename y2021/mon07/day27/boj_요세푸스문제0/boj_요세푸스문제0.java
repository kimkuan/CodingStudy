package mon07.day27.boj_요세푸스문제0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_요세푸스문제0 {

	static int N, K;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int start = 0;
		
		sb.append("<");
		while(list.size() > 0) {
			int target = start+K-1;
			if(target >= list.size())
				target = target % list.size();
			start = target;
		
			sb.append(list.get(target) + ", ");
			list.remove(target);
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
	}
}
