package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class Info{
	int idx;
	int value;
	
	public Info(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}

public class q17298 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Info> stack = new Stack<>();
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Arrays.fill(arr, -1);

		stack.push(new Info(0, Integer.parseInt(st.nextToken()))); // 일단 첫번째 수는 넣음
		
		for(int i = 1; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty() && stack.peek().value < num) {
				Info info = stack.pop(); 
				arr[info.idx] = num;
			}
			stack.push(new Info(i, num));
		}
		
		for(int i : arr) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}
