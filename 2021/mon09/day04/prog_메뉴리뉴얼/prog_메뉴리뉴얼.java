package com.mon09.day04.prog_메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class prog_메뉴리뉴얼 {

	static HashMap<String, Integer> log = new HashMap<>();
	static String[] orders = {"XYZ", "XWY", "WXA"};
	static int[] course = {2,3,4};
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		// orders에 대해서 sort
		for (int i = 0; i < orders.length; i++) {
			orders[i] = sort(orders[i]);
		}
		
		for (int i = 0; i < orders.length; i++) {
			combination(0, 0, orders[i]);
		}

		// 각 코스에 대한 메뉴 개수마다 나올 수 있는 인기 메뉴만 list에 저장
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 0; i < course.length; i++) {
			int max = 0;
			ArrayList<String> temp = new ArrayList<>();
			
			for(Entry<String, Integer> entry : log.entrySet()) {
				// 문자열의 길이가 course[i]이고
				// 그 개수가 2개 이상인 메뉴에 대해서 최댓값 구하기
				if(entry.getKey().length() == course[i] && entry.getValue() >= 2) {
					if(max < entry.getValue()) {
						temp.clear();
						temp.add(entry.getKey());
						max = entry.getValue();
					}
					else if(max == entry.getValue()) {
						temp.add(entry.getKey());
					}
				}
			}
		
			for (String str : temp) {
				list.add(str);
			}
		}
		
		list.sort(null);
		System.out.println(list.toString());
		
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
	}
	
	private static void combination(int depth, int start, String order) {
		if(depth > order.length()) {
			return;
		}
		if(sb.length() > 1) {
			String menu = sb.toString();
			if(!log.containsKey(menu))
				log.put(menu, 1);
			else
				log.put(menu, log.get(menu)+1);
		}
		
		
		for (int i = start; i < order.length(); i++) {
			sb.append(order.charAt(i));
			combination(depth+1, i+1, order);
			sb.setLength(sb.length()-1);
		}
	}
	
	private static String sort(String order) {
		StringBuilder sb = new StringBuilder();
		char[] chars = order.toCharArray();
		
		Arrays.sort(chars);
		for (int i = 0; i < chars.length; i++) {
			sb.append(chars[i]);
		}
	
		return sb.toString();
	}

}
