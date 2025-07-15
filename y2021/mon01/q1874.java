package y2021.mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q1874 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		boolean flag = false;
		int num = 1;

		for(int i = 1; i <= n ; i++) {
			int k = Integer.parseInt(br.readLine()); // 수열 값
			
			while(true) {
				if(k >= num) {
					stack.push(num);
					sb.append("+\n");
					num++;
				}
				else if(k <= num) {
					if(!stack.isEmpty() && stack.peek() == k) {
						stack.pop();
						sb.append("-\n");					
					}
					else // 스택이 비어있거나 수열이 불가능할 때
						flag = true;
					break;
				}
			}
			if(flag) { // 불가능한 수열이면
				sb.setLength(0);
				sb.append("NO\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
