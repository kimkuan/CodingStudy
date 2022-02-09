package mon02.day09.boj_로마숫자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj_로마숫자 {

	static HashMap<String, Integer> number = new HashMap<String, Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		init();
		
		int result = convertToNumber(str1) + convertToNumber(str2);
		String result2 = convertToString(result);
		
		System.out.println(result);
		System.out.println(result2);
	}

	private static int convertToNumber(String str) {
		int result = 0;
		int len = str.length();
		boolean[] visited = new boolean[len];
		
		for(int i = 0; i < len-1; i++) {
			String current = String.valueOf(str.charAt(i));
			String next = String.valueOf(str.charAt(i+1));
			
			// 작은 숫자가 먼저 오는 경우
			if(number.get(current) < number.get(next)) {
				visited[i] = true;
				visited[i+1] = true;
				result += number.get(current+next);
				i++;
			}
			else {
				visited[i] = true;
				result += number.get(current);
			}
		}
		
		if(!visited[len-1]) {
			String last = String.valueOf(str.charAt(len-1));
			result += number.get(last);
		}
		
		return result;
	}
	
	private static String convertToString(int num) {

		StringBuilder temp = new StringBuilder();	
		
		// 천의 자리
		int value = num / 1000;
		num = num % 1000;
		
		for(int i = 0; i < value; i++){
			temp.append("M");
		}
		
		// 백의 자리
		value = num / 100;
		num = num % 100;
		if(value == 4) { // CD의 경우
			temp.append("CD");
		}
		else if(value == 9) { // CM의 경우
			temp.append("CM");
		}
		else {
			if(value >= 5) {
				temp.append("D");
				value -= 5;
			}
			
			for(int i = 0; i < value; i++) {
				temp.append("C");
			}
		}
		
		// 십의 자리
		value = num / 10;
		num = num % 10;
		if(value == 4) { // XL의 경우
			temp.append("XL");
		}
		else if(value == 9) {
			temp.append("XC");
		}
		else {
			if(value >= 5) {
				temp.append("L");
				value -= 5;
			}
			
			for(int i = 0; i < value; i++) {
				temp.append("X");
			}
		}
		
		// 일의 자리
		value = num;
		if(value == 4) { // XL의 경우
			temp.append("IV");
		}
		else if(value == 9) {
			temp.append("IX");
		}
		else {
			if(value >= 5) {
				temp.append("V");
				value -= 5;
			}
			
			for(int i = 0; i < value; i++) {
				temp.append("I");
			}
		}
		
		return temp.toString();
	}

	private static void init() {
		number.put("M", 1000);
		number.put("D", 500);
		number.put("C", 100);
		number.put("L", 50);
		number.put("X", 10);
		number.put("V", 5);
		number.put("I", 1);
		number.put("IV", 4);
		number.put("IX", 9);
		number.put("XL", 40);
		number.put("XC", 90);
		number.put("CD", 400);
		number.put("CM", 900);
	}
}
