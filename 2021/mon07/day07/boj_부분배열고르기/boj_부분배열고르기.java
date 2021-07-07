package mon07.day07.boj_부분배열고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_부분배열고르기 {

	static int N, treeSize;
	static int[] arr;
	static int[] sumTree;
	static int[] minTree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		treeSize = (int) Math.pow(Math.sqrt(N)+1, 2) * 2; // 가까운 제곱수 * 2
		arr = new int[N];
		sumTree = new int[treeSize];
		minTree = new int[treeSize];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(0, N-1, 1); // 채워넣을 구간 합 트리의 인덱스 시작은 1부터
		initMin(0, N-1, 1);
		
		System.out.println(Arrays.toString(sumTree));
		System.out.println(Arrays.toString(minTree));
		
		int max = 0;
		System.out.println(sum(0, N-1, 1, 1, 3));
	
	}
	
	// 구간 합 트리를 만드는 함수
	private static int init(int start, int end, int node) {
		if(start == end){
			return sumTree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return sumTree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
	}
	
	// 구간 최솟값 트리를 만드는 함수
	private static int initMin(int start, int end, int node) {
		if(start == end){
			return minTree[node] = arr[start];
		}
		int mid = (start+end)/2;
		return minTree[node] = Math.min(initMin(start, mid, node*2), initMin(mid+1, end, node*2+1));
	}
	
	// 구간 합을 구하는 함수
	private static int sum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) return 0;
		if(left <= start && right >= end) return sumTree[node];
		int mid = (start+end)/2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	
	// 주어진 구간에서 최솟값의 인덱스를 반환하는 함수
//	private static int minIndex(int start, int end, int node, int left, int right){
//		// 구간을 벗어날 때
//		if(left > end || right < start) return -1;
//		// 구간을 벗어나지 않을 때
//		if(left <= start && right >= end) return minTree[node];
//		
//		int mid = (start+end)/2;
//		int index1 = minIndex(start, mid, node*2, left, right);
//		int index2 = minIndex(mid+1, end, node*2+1, left, right);
//	}
}
