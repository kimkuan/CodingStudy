package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class q2504_2 {
	
	static char[] arr;
	static Stack<Character> stack = new Stack<>();
	static int i = 0, val = 0;
	
	public static int check(int val) {
		char c = arr[i++];
		
		if(c== '(' || c == '[') {
			stack.push(c);
			System.out.println("push : " + c);

			val += check(val);
		}
		
		else if(c == ')') {
			if(!stack.isEmpty() && stack.peek() == '('){ // 올바름
				System.out.println("pop : " + c);
				stack.pop();
				val = val * 2;
			}
		}
		else {
			if(!stack.isEmpty() && stack.peek() == '['){ // 올바름
				System.out.println("pop : " + c);
				stack.pop();
				val = val * 3;
			}
		}
		return val;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		boolean flag = false;
	
		String str = br.readLine();
		arr = str.toCharArray();

		while(i < str.length()) {
			ans += check(val);
		}
		
		System.out.println(ans);
	}
}
