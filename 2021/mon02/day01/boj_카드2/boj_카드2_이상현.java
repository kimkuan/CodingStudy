package mon02.day01.boj_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_카드2_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) 
			q.add(i);
			
		while(q.size() > 1) {
			q.poll(); // 버림
			q.add(q.poll());
		}
		System.out.println(q.peek());
	}
}
