package mon02.day02.boj_키로거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 좌우로 덱을 나눠서 계산하자!
 */

public class boj_키로거_이상현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		while(tc++ < T) {
			Deque<Character> left = new ArrayDeque<>();
			Deque<Character> right = new ArrayDeque<>();
			char[] arr = br.readLine().toCharArray();
			int len = arr.length;
			int idx = 0;
			
			for(int i = 0; i < len; i++) {
				if(arr[i] == '<') {   // 원래 있던 값 오른쪽으로 이동
					if(!left.isEmpty()) right.addFirst(left.pollLast());
				}
				else if(arr[i] == '>') {// 원래 있던 값 왼쪽으로 이동
					if(!right.isEmpty()) left.addLast(right.pollFirst());
				}
				else if(arr[i] == '-') { // 현재 커서의 앞에있는 알파벳 삭제
					if(!left.isEmpty()) left.pollLast();
				}
				else // 알파벳
					left.addLast(arr[i]);		
				
			}
			while(!right.isEmpty()) { // 한쪽으로 모으기
				left.addLast(right.pollFirst());
			}
			
			for(Character c : left) 
				sb.append(c);

			sb.append("\n");
		}	
		System.out.print(sb);
	}
}
