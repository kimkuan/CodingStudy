import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* [S3] 스택수열   */

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
					num++; // stack에 num을 넣을 때마다 증가 
				}
				else if(k <= num) {
					if(!stack.isEmpty() && stack.peek() == k) { // 현재 num보다 작은 수면 stack에 존재
						stack.pop();
						sb.append("-\n");					
					}
					else // 스택이 비어있거나 수열이 불가능할 때
						flag = true;
					break; // 다음 k값으로 넘어감 
				}
			}// while문
			
			if(flag) { // 불가능한 수열이면
				sb.setLength(0); // sb 초기화
				sb.append("NO\n");
				break;
			}
		}// for문
		System.out.println(sb);
	}
}
