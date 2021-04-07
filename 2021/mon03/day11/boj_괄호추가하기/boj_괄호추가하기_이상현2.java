package mon03.day11.boj_괄호추가하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_괄호추가하기_이상현2 {

	static int N;
	static char[] str;
	static int max = Integer.MIN_VALUE; // 음수도 가능함
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = br.readLine().toCharArray();
		
		calculate(1, str[0]-'0');
		
		System.out.println(max);
	}
	
	public static void calculate(int idx, int sum) {
		// 괄호를 하거나 안하거나  flag = true면 괄호 O, false 괄호 X (가능)
		if(idx == N) {
			max = Math.max(max, sum);
			return;
		}

		if(idx + 4 <= N) { // 현재 연산자에서 괄호를 묶거나
			int res = cal(str[idx+2], str[idx+1]-'0', str[idx+3]-'0');
			calculate(idx+4, cal(str[idx], sum, res));
		}
		// 묶지 않거나
		calculate(idx+2, cal(str[idx], sum, str[idx+1]-'0'));
		
	}
	
	public static int cal(char c, int num1, int num2) {
		switch(c) {
		case '+': return num1+num2;
		case '-': return num1-num2;
		case '*': return num1*num2;
		}
		return 0;
	}
	

}
