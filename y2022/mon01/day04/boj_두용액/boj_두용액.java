package y2022.mon01.day04.boj_두용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_두용액 {

	static int N;
	static int value1, value2, answer = Integer.MAX_VALUE;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);		
		mixLiquid(0, N-1);
		
		System.out.println(value1 + " " + value2);
	}
	
	private static void mixLiquid(int left, int right) {
		
		while(left < right) {
			int sum = arr[left] + arr[right];
						
			if(answer > Math.abs(sum)) {
				answer = Math.abs(sum);
				value1 = arr[left]; // 오름차순을 위해 left를  value1에 저장
				value2 = arr[right];
			}
			
			if(sum > 0)
				right--;
			else
				left++;
		}
	}
}
