package mon03.day10.boj_1718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1718_암호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String code = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			int j = i % code.length();
			
			if(str.charAt(i) == ' ') {
				sb.append(' ');
				continue;
			}
			
			int num1 = str.charAt(i) - 'a' - 1; // 평문
			int num2 = code.charAt(j) - 'a' - 1; // 앞호문
			int gap = num1 - num2; // 평문을 기준으로 빼기

			// 기존 평문에서 암호화키를 뱄을 때 0보다 크거나 작다면
			if(gap > 0) 
				sb.append((char)(gap + 97 - 1));
			else
				sb.append((char)(26 - Math.abs(gap) + 97-1));
		}
		System.out.print(sb);
		
	}
}
