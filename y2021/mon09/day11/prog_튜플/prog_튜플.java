package com.mon09.day11.prog_튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class prog_튜플 {
	
	static String s = "{{123}}";

	public static void main(String[] args) {
		String tuple = s.substring(1, s.length()-1); // 맨 바깥의 중괄호는 제거
		ArrayList<String> list = new ArrayList<String>(); // 중괄호를 제거한 상태로 만든 문자열 배열 -> 2 / 2,1 / 2,1,3 / 2,1,3,4
		StringBuilder sb = new StringBuilder();// 문자들을 모아서 숫자로 만들기 위한 SB
		
		boolean start = false; // 중괄호가 열렸는지 유무 (그래야 밖에있는 쉼표와 안에있는 쉼표를 구분)
		for (int i = 0; i < tuple.length(); i++) {
			char c = tuple.charAt(i);
			
			if(c == '{') { // 중괄호 열림
				start = true;
			}
			else if(c == '}') { // 중괄호 닫힘 -> 하나의 튜플 원소를 완성 시킴
				list.add(sb.toString()); // list에 저장
				sb.setLength(0);
				start = false;
			}
			else {
				if(start) // 중괄호가 열린 상태에서만 쉼표와 숫자를 저장
					sb.append(c);
			}
		}

		// 문자열의 길이가 작은 순서가 튜플 원소들이 만들어진 순서이므로 
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length()); // 문자열의 길이가 작은 순서대로 정렬
			}
		});
		
		// 정렬된 순서를 그대로 지키기 위해 LinkedHashMap 사용
		LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<>();
		for (int i = 0; i < list.size(); i++) {
			String[] elements = list.get(i).split(","); // 중괄호 안에있는 쉼표를 기준으로
			
			for (int j = 0; j < elements.length; j++) {
				map.put(Integer.parseInt(elements[j]), true); // 정수로 변환 & map에 저장(중복되는 숫자 없기에 가능)
			}
		}
		
		int idx = 0;
		int[] answer = new int[map.size()];
		for(Entry<Integer, Boolean> e : map.entrySet()) {
			answer[idx++] = e.getKey();
		}
		System.out.println(Arrays.toString(answer));
	}
}
