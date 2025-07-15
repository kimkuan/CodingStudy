package y2021.mon06.day16.boj_괄호의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class boj_괄호의값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		boolean pass = false;
		int total = 0;
		int sub = 1;
		
		if(!isRight(str)) { // 올바르지 못한 문자열이면 0 출력
			System.out.println(0);
			return;
		}
		
		ArrayDeque<Character> q = new ArrayDeque<Character>();
		for (int i = 0; i < str.length; i++) {
			q.add(str[i]);
		}
		while(!q.isEmpty()){
			char c = q.poll();
			
			if(c == '(') {
				sub *= 2;
				pass = false;
			}
			else if(c == '[') {
				sub *= 3;
				pass = false;
			}
			else if(c == ')') {
				if(!pass) {
					total += sub;
					pass = true;
				}
				sub /= 2;
			}
			else {
				if(!pass) {
					total += sub;
					pass = true;
				}
				sub /= 3;
			}
		}
		System.out.println(total);
	}
	
	private static boolean isRight(char[] str) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < str.length; i++) {
			if(str[i] == '(' || str[i] == '[') 
				st.push(str[i]);
			else if(str[i] == ')') {
				if(!st.isEmpty() && st.peek() == '(') st.pop();
				else return false;
			}
			else {
				if(!st.isEmpty() && st.peek() == '[') st.pop();
				else return false;
			}
		}
		if(!st.isEmpty()) return false;
		else return true;
	}
}
