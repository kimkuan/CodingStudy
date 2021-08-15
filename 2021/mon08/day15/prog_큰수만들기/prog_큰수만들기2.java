package com.mon08.day15.prog_ū�������;

import java.util.ArrayDeque;

public class prog_ū�������2 {

	static String number = "41";
	static int k = 1;
	
	public static void main(String[] args) {
		
		ArrayDeque<Character> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder(); // ���� �� �ִ� ���� ū ����
		
		for(int i = 0; i < number.length(); i++) {
			while(k > 0 && !q.isEmpty()) {
				if(number.charAt(i) > q.peekLast()) {
					q.pollLast();
					k--;
				}
				else
					break;
			}
			q.addLast(number.charAt(i));
		}
		
		while(k > 0 && !q.isEmpty()) {
			k--;
			q.pollLast();
		}
		
		while(!q.isEmpty()) {
			sb.append(q.pollFirst());
		}
		System.out.println(sb.toString());
	}
}
