package y2021.mon02.day02.boj_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_덱_이상현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			switch(st.nextToken()) {
			case "push_front":
				q.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				q.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(!q.isEmpty()) sb.append(q.pollFirst());
				else  sb.append(-1);
				sb.append("\n");
				break;
			case "pop_back":
				if(!q.isEmpty()) sb.append(q.pollLast());
				else  sb.append(-1);
				sb.append("\n");
				break;
			case "front":
				if(!q.isEmpty()) sb.append(q.peekFirst());
				else  sb.append(-1);
				sb.append("\n");
				break;
			case "back":
				if(!q.isEmpty()) sb.append(q.peekLast());
				else  sb.append(-1);
				sb.append("\n");
				break;
			case "size":
				sb.append(q.size());
				sb.append("\n");
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0);
				sb.append("\n");
				break;
			}
		}
		System.out.print(sb);
	}
}
