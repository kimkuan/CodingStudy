package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q10828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			
			if(cmd.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				continue;
			}
			else if(cmd.equals("top")) 			
				sb.append(stack.isEmpty() ? "-1" : stack.peek());

			else if(cmd.equals("size"))
				sb.append(stack.size());
				
			else if(cmd.equals("empty"))
				sb.append(stack.isEmpty() ? "1" : "0");
			else 
				sb.append(stack.isEmpty() ? "-1" : stack.pop());
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
