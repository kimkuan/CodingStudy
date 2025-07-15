package com.mon08.day22.prog_위장;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class prog_위장 {
	
	static String[][] clothes = {{"yellowhat", "0"}, {"bluesunglasses", "1"}, {"green_turban", "0"}};

	static LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
	static int result = 0;
	
	public static void main(String[] args) {
		for (int i = 0; i < clothes.length; i++) {
			String category = clothes[i][1];

			if(map.containsKey(category))
				map.put(category, map.get(category)+1);
			else
				map.put(category, 1);
		}
		
		int i = 0;
		for(Entry<String, Integer> entry :  map.entrySet()) {
			if(i == 0)
				result += entry.getValue()+1;
			else
				result *= entry.getValue()+1;
			i++;
		}
		
		System.out.println(result-1); // 모두 다 입지 않을 경우 빼주기
		
	}


}

// 1. 카테고리별로 모으기
// (key-의상의 종류, value-개수)

// 2.조합 구하기 
