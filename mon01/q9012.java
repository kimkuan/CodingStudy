package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
				
		for(int i = 0; i < n; i++) {	
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			boolean can = true;
			
			for(int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				
				if(c == '(')
					stack.push(c);
				else { 			
					if(stack.isEmpty() || stack.pop() == ')') { // 스택이 비어있거나 그 전 값이'(' 아니면 안됨.		
						can = false; // 불가능
						break;
					}
				}
			}
			if(stack.isEmpty() && can) 
				sb.append("YES\n");
			else // 만약 스택이 비어있지 않으면 NO 
				sb.append("NO\n"); 
		}
		System.out.println(sb);
	}
}
