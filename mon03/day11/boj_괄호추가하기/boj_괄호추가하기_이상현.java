package mon03.day11.boj_괄호추가하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_괄호추가하기_이상현 {

	static int N, size;
	static int[] number;
	static char[] oper;
	static int max = Integer.MIN_VALUE; // 음수도 가능함
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		size = N/2;
		
		char[] str = br.readLine().toCharArray();
		oper = new char[size];
		number = new int[size + 1];
		
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0) number[i/2] = str[i] - '0';
			else oper[i/2] = str[i];
		}
		
		calculate(0, 0, 0, ' ', false);
		System.out.println(max);
	}
	
	public static void calculate(int start, int sum, int tNum, char tOper, boolean flag) {
		// 괄호를 하거나 안하거나  flag = true면 괄호 O, false 괄호 X (가능)
		if(start == size) {
			// 마지막 연산
			if(flag) { // 무조건 닫아야함
				if(tOper == ' ') 
					sum += cal(oper[start-1], tNum, number[start]);
				else { 
					tNum = cal(oper[start-1], tNum, number[start]);
					sum = cal(tOper, sum, tNum);
				}
			}
			else
				sum = cal(oper[start-1], sum, number[start]);	
			
			System.out.println("sum : " + sum);
			max = sum > max ? sum : max;
			return;
		}
		
		System.out.println("sum : " + sum);
		
		if(start > 0) 
			tNum = cal(oper[start-1], tNum, number[start]); // tNum값임
		
		for(int i = start; i < size; i++) {
			// flag : true -> 괄호 열려있음, false -> 괄호 닫혀있음
			if(i == 0) {
				calculate(i+1, sum, number[start], ' ', true); // 열거나
				calculate(i+1, number[start], 0, ' ', false);// 쭉 가거나
				continue;
			}
			if(flag) {
				if(tOper == ' ') calculate(i+1, tNum, 0, ' ', false);// 닫거나
				else calculate(i+1, cal(tOper, sum, tNum), 0, ' ', false);// 닫거나
			}
			else {
				calculate(i+1, sum, number[start], oper[start-1], true);
				calculate(i+1, cal(oper[start-1], sum, number[start]), 0, ' ', false);// 쭉 가거나
			}		
		}
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
