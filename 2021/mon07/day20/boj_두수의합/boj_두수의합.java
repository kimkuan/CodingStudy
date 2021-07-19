package mon07.day20.boj_두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_두수의합 {

	static int N, X;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		X = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		int answer = 0;
		
		while(left < right){
			int result = arr[left]+arr[right];
			if(result == X) {
				left++;
				right--;
				answer++;
			}else if(result > X) {
				right--;
			}else {
				left++;
			}
		}
		System.out.println(answer);
	}
}
