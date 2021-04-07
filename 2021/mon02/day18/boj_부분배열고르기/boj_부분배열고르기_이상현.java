package mon02.day18.boj_부분배열고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_부분배열고르기_이상현 {
	
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(maxSubSet(0, arr.length-1));
	}
	
	public static int maxCross(int left, int right, int mid) {
		int i = mid, j = mid+1;
		int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
		int leftSum = 0, rightSum = 0;
		int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
		
		System.out.println("left right mid " + left + " " + right + " " + mid);
		
		while(true) {
			if(i < left && j > right) break;
			
			if(i >= left) {
				leftSum += arr[i];
				leftMin = Math.min(arr[i], leftMin);
				i--;
			}
			
			if(j <= right) {
				rightSum += arr[j];
				rightMin = Math.min(arr[j], rightMin);
				j++;
			}	
			min = Math.min(Math.min(rightMin, leftMin), min);
			System.out.println("leftSum : " + leftSum);
			System.out.println("leftMin : " + leftMin);
			System.out.println("leftSum*leftMin : " + leftSum*leftMin);
			System.out.println("rightSum*rightMin : " + rightSum*rightMin);
			System.out.println("totalSum*totalMin : " + (rightSum + leftSum)*min);
	
			
			max = Math.max(leftSum*leftMin, max);// 왼쪽만 포함했을 때
			max = Math.max(rightSum*rightMin, max);// 오른쪽만 포함했을 때
			max = Math.max((rightSum + leftSum)*min, max); // 왼쪽 오른쪽 포함했을 때
		}
		System.out.println(max);
		return max;
	}
	
	public static int maxSubSet(int left, int right) {
		if(left == right) // 크기가 1일 때 최대합은 해당 원소의 곱
			return arr[left] * arr[left]; 
		
		int mid = (left+right) / 2;
		int leftSum = maxSubSet(left, mid);
		int rightSum = maxSubSet(mid+1, right);
		int crossSum = maxCross(left, right, mid);
		
		return Math.max(leftSum, Math.max(rightSum, crossSum));
	}
}
