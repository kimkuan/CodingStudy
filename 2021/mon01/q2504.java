package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class q2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int ans = 0;
	
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
			
			if(c == ')') {
				if(!stack.isEmpty()) {
				}
			}
			
		}
		
		System.out.println(ans);
	}	
}
