package mon03.day7.boj_문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_문자열폭발_이상현 {

	static char[] strChar;
	static char[] bomb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		Stack<Character> temp = new Stack<>();
		
		strChar = br.readLine().toCharArray();
		bomb = br.readLine().toCharArray();

		int sLen = strChar.length;
		int bLen = bomb.length;
		
		// 1번만 수행하면 됨 -> 스택을 이용하면  터지고 나서 새로운 bomb가 생겨도 처리됨!
		for(int i = 0; i < sLen; i++) {
			stack.push(strChar[i]);
			
			// 현재 넣는 문자가 bomb의 맨 끝 문자와 같고 스택의 사이즈가 bomb보다 작지 않을 때
			if(strChar[i] == bomb[bLen-1] && stack.size() >= bLen) {
				for(int j = bLen-1; j >= 0; j--) {
					if(bomb[j] == stack.peek()) 
						temp.push(stack.pop());
					else
						break;
				}
				
				if(temp.size() != bLen) { // 문자열 일치하지 않으면
					while(!temp.isEmpty())
						stack.push(temp.pop()); // 다시 넣기
				}
				temp.clear(); // 문자열이 일치했다면 clear!
			}
		}
		
		if(stack.isEmpty()){ // 남아있는 문자가 없음
			System.out.print("FRULA");
			return;
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		StringBuilder ans = new StringBuilder();
		for(int i = sb.length()-1; i >= 0; i--) {
			ans.append(sb.charAt(i));
		}
		System.out.print(ans);
	}
}
