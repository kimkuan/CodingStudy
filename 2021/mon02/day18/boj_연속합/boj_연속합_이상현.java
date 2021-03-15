package mon02.day18.boj_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_연속합_이상현 {

	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(maxSubSet(0, arr.length-1));
	}
	
	public static int maxCross(int left, int right) {
		
		int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
		int mid = (left + right)/2;
		
		int sum = 0;
		for(int i = mid; i >= left; i--) { // 가운데를 기준으로  왼쪽 탐색
			sum += arr[i];
			leftSum = Math.max(leftSum, sum); // 최대합
		}
		sum = 0;
		for(int i = mid + 1; i <= right; i++) {
			sum += arr[i];
			rightSum = Math.max(rightSum, sum);
		}	
		return leftSum + rightSum; // 왼쪽 최대합 + 오른쪽 최대합 -> mid 걸쳐 있는 부분 배열의 최대합
	}

	public static int maxSubSet( int left, int right) {
		if(left == right) // 크기가 1이면 무조건 최대합
			return arr[left];
		
		int mid = (left+right) / 2;
		int leftSum = maxSubSet(left, mid); // 왼쪽에 최대 부분 배열이 있다
		int rightSum = maxSubSet(mid + 1, right);
		int crossSum = maxCross(left, right); // mid를 기준으로 left,right 걸쳐있는 부분배열
			
		return Math.max(leftSum, Math.max(rightSum, crossSum));
	}
}

/*
	배열을 좌우로 나누어서 
*/