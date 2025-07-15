package y2021.mon04.day14.boj_약수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_약수_이상현 {

	static int n; // 약수의 개수
	static int[] factors;
	
	public static void main(String[] args) throws IOException {
		input();
		if(n % 2 == 0) // 짝수이면 -> N은 양 끝의 곱
			System.out.println((long)factors[0] * (long)factors[n-1]); 
		else  // 홀수이면 -> N은 가운데 수의 제곱
			System.out.println((long)factors[n/2] * (long)factors[n/2]);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		factors = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			factors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(factors); // 오름차순 정렬
	}
}
