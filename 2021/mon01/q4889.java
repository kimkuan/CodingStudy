package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		
		while(true) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			boolean flag = false; 
			int ans = 0;
		
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(c == '-') {
					flag = true;
					break;
				}
				else if(c == '}'&& !stack.isEmpty() && stack.peek()=='{') 
					stack.pop();
				else 
					stack.push(c); // { 또는 짝이 안맞는 }
			}
			
			if(flag)  // true 이면 while문 종료
				break;
			
			while(!stack.isEmpty()) {
				char c = stack.pop();
			
				if(c == '{'){
					stack.push('}');
					ans++;
				}
				else if(c == '}' ) {
					if(stack.pop() == '}') {
						stack.push('{');
						stack.push(c); // 다시 넣음
						ans++;
					}
				}	
			}
			sb.append(++tc + ". " + ans + "\n");
		}
		System.out.println(sb);
	}
}

/*
 * 빈문자열 : 안정적
 * S가 안정적이면 {S}도 안정적
 * S와 T가 안적적이면 ST도 안정적
 *
 * 1. 여는괄호 --> 닫는괄호로 변경
 * 2. 닫는괄호 --> 여는 괄호로 변경
 * 
 * 안정적인 문자열로 만드는 최소 연산
 */