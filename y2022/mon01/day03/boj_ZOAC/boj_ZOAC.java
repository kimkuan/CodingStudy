package y2022.mon01.day03.boj_ZOAC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class boj_ZOAC {

	static StringBuilder answer = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		makeOpening(str.toCharArray());
		System.out.print(answer);
	}
	
	private static void makeOpening(char[] str) {
		int count = 0, len = str.length;
		ArrayDeque<Integer> left = new ArrayDeque<Integer>();
		ArrayDeque<Integer> right = new ArrayDeque<Integer>();
		boolean[] selected = new boolean[len];

		while(count < len) {
			int start = left.isEmpty() ? -1 : left.peekLast();
			int idx = findSmallestIdx(str, selected, start, len);
			
			// start 이후로 str[start]보다 작은 알파벳이 없다면 
			if(idx == -1) {
				// left에 넣은 값을 right로 옮김
				if(!left.isEmpty()) 
					right.addFirst(left.pollLast());
			}
			else {
				left.addLast(idx);
				selected[idx] = true;
				count++;
				answer.append(makeString(str, selected, len) + "\n");
			}
		}
	}
	
	private static int findSmallestIdx(char[] str, boolean[] selected, int start, int len) {
		int smallestIndex = -1;
		
		// start+1 부터 시작하는 이유 -> start 이후로 가장 작은 값을 찾기 위해!
		for(int i = start+1; i < len; i++) {
			if(!selected[i]) {
				if(smallestIndex == -1 || str[i] < str[smallestIndex])
					smallestIndex = i;
			}
		}
		return smallestIndex;
	}
	
	private static String makeString(char[] str, boolean[] selected, int len) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++) {
			if(selected[i])
				sb.append(str[i]);
		}
		return sb.toString();
	}
}
