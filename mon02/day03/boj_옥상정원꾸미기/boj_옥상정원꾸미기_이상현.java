package mon02.day03.boj_옥상정원꾸미기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_옥상정원꾸미기_이상현 {
	
	static int[] ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		ans = new int[n+1];
		
		for(int i = 1; i <= n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 1; i <= n; i++) {
			while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
				int idx = stack.pop();
				ans[idx] = i - idx - 1; // 지금까지 볼 수 있었던 빌딩의 개수
			}
			stack.push(i); // 인덱스를 넣음
		}
		
		if(!stack.isEmpty()) { // 더 높은 빌딩이 나오지 않은 빌딩 처리
			int idx = stack.pop();
			while(!stack.isEmpty()) {
				ans[stack.peek()] = idx - stack.peek();
				stack.pop();
			}
		}
		
		long sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += ans[i];
		}
		System.out.println(sum);
	}
}
