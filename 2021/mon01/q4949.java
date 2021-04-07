package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q4949 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();
			String ans = "yes";
			
			if(str.equals("."))
				break;

			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if(ans.equals("no"))
					break;
				
				switch(c) {
				case '(':
					stack.push(c);
					break;
				case '[':
					stack.push(c);
					break;
				case ')':
					if(!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else
						ans = "no";
					break;
				case ']':
					if(!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else
						ans = "no";
					break;
				}
			}
			
			if(!stack.isEmpty())
				ans = "no";
			
			sb.append(ans + "\n");	
		}
		System.out.println(sb);
	}
}
