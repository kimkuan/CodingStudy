package com.mon08.day15.prog_큰수만들기;

import java.util.Stack;

public class prog_큰수만들기 {

	static String number = "8";
	static int k = 1;
	
	public static void main(String[] args) {
		
		Stack<Character> before = new Stack<>();
		Stack<Character> after = new Stack<>();
		StringBuilder sb = new StringBuilder(); // 만들 수 있는 가장 큰 숫자

		for(int i = number.length()-1; i >= 0; i--) { // 맨 앞 숫자가 가장 맨 위로 올라오
			before.push(number.charAt(i));
		}
		
		while(!before.isEmpty() && k > 0) {
			char pop = before.pop(); // 맨 위에 있는 값을 하나 꺼냄

			// after에 있는 값들 중에서 자신보다 작은값이면 out 
			while(!after.isEmpty() && k > 0) {
				if(after.peek() < pop) { // 현재 뽑은 수가 더 크면 after에 있는 값을 뺌
					after.pop();
					k--;
				}
				else
					break;
			}
			after.push(pop);
		}
		
		// before에 남아있는 값을 모두 push
		while(!before.isEmpty()) {
			after.push(before.pop());
		}
		
		while(!after.isEmpty() && k > 0) {
			after.pop();
            k--;
		}
		
		while(!after.isEmpty()) {
			sb.append(after.pop());
		}
		System.out.println(sb.reverse().toString());
		
	}
}
