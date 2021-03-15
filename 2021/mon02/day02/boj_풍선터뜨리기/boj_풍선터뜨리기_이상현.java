package mon02.day02.boj_풍선터뜨리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class balloon{
	int value;
	int idx;
	public balloon(int value, int idx){
		this.value = value;
		this.idx = idx;
	}
}

public class boj_풍선터뜨리기_이상현 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<balloon> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			q.add(new balloon(Integer.parseInt(st.nextToken()), i));
		}
		
		while(!q.isEmpty()) {
			balloon b = q.poll(); // 현재 뽑는 값이 제일 처음에 오게 함
			int val = b.value;
			int idx = b.idx;
			sb.append(idx).append(" ");
			
			if(q.isEmpty())
				break;
			
			if(val > 0) { // 양수
				for(int i = 0; i < val-1; i++) { // 현재 뽑은 값까지 포함이라서 val-1
					q.addLast(q.pollFirst());
				}
			}
			else { // 음수
				for(int i = val; i < 0; i++) {
					q.addFirst(q.pollLast());
				}
			}
		}
		System.out.println(sb);
	}
}
