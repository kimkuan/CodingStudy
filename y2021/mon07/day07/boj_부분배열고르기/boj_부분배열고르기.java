package y2021.mon07.day07.boj_부분배열고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_부분배열고르기 {

	static int N, treeSize;
	static int[] arr;
	static long[] sumTree; // 구간 합은 int형을 넘을 수 있기 때문에 long으로! (100,000 * 1,000,000)
	static int[] minTree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		// treeSize = (int) Math.pow(Math.sqrt(N)+1, 2) * 2; // 가까운 제곱수 * 2
		treeSize = N*4;
		arr = new int[N];
		sumTree = new long[treeSize];
		minTree = new int[treeSize];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(0, N-1, 1); // 채워넣을 구간 합 트리의 인덱스 시작은 1부터
		initMin(0, N-1, 1);

//		long max = 0;
//		int left = 0, right = N-1;
//		int minIndex = -1;
//		
//		while(left <= right) {			
//			// 현재 구간에서 계산
//			minIndex = minIndex(0, N-1, 1, left, right);
//			max = Math.max(max, sum(0, N-1, 1, left, right) * arr[minIndex]);
//			
////			System.out.println("left : " + left + " right : " + right);
////			System.out.println("min Index: " + minIndex);
//			
//			// 현재 구간에서 최솟값이 나오는 인덱스를 기준으로 왼쪽, 오른쪽 점수 비교
//			long leftScore = 0, rightScore = 0;
//			int leftMinIndex = minIndex(0, N-1, 1, 0, minIndex-1); 
//			int rightMinIndex = minIndex(0, N-1, 1, minIndex+1, N-1);
//			
//			if(leftMinIndex >= 0 && leftMinIndex < N) 
//				leftScore = sum(0, N-1, 1, 0, minIndex-1) * arr[leftMinIndex];
//			
//			if(rightMinIndex >= 0 && rightMinIndex < N) 
//				rightScore = sum(0, N-1, 1, minIndex+1, N-1) * arr[rightMinIndex];
//
//			if(leftScore > rightScore) 
//				right = minIndex-1;
//			else
//				left = minIndex+1;
//		}
//		System.out.println(max);
		System.out.println(findAnswer(0, N-1));
	}	
	// 구간 합 트리를 만드는 함수
	private static long init(int start, int end, int node) {
		if(start == end){
			return sumTree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return sumTree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	// 구간에서 최솟값 '인덱스' 트리를 만드는 함수
	private static int initMin(int start, int end, int node) {
		if(start == end){
			return minTree[node] = start;
		}
		int mid = (start+end)/2;
		int min1 = initMin(start, mid, node*2);
		int min2 = initMin(mid+1, end, node*2+1);
		return minTree[node] = (arr[min1] < arr[min2] ? min1 : min2); // 둘 중 더 작은 값의 인덱스를 반환
	}
	
	// 구간 합을 구하는 함수
	private static long sum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return 0;
		if(left <= start && right >= end) return sumTree[node];
		int mid = (start+end)/2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	
	// 주어진 구간에서 최솟값의 인덱스를 반환하는 함수
	private static int minIndex(int start, int end, int node, int left, int right){
		// 구간을 벗어날 때
		if(left > end || right < start) return -1;
		// 구간을 벗어나지 않을 때
		if(left <= start && right >= end) return minTree[node]; // 최솟값의 인덱스 반환
		
		int mid = (start+end)/2;
		int index1 = minIndex(start, mid, node*2, left, right);
		int index2 = minIndex(mid+1, end, node*2+1, left, right);
		
		if(index1 == -1) return index2;
		else if(index2 == -1) return index1;
		else
			return (arr[index1] < arr[index2]) ? index1 : index2;
	}
	
	private static long findAnswer(int left, int right) {
		int minIndex = minIndex(0, N-1, 1, left, right);
		long sum = sum(0, N-1, 1, left, right) * arr[minIndex];
		
		if(left < minIndex) // 새로찾은 (현재 구간의) 최소값의 인덱스가 오른쪽에 있으면 -> 최솟값의 인덱스를 기준으로 왼쪽 탐색
			sum = Math.max(sum, findAnswer(left, minIndex-1));
		if(minIndex < right)
			sum = Math.max(sum, findAnswer(minIndex+1, right));
			
		return sum;
	}
}
