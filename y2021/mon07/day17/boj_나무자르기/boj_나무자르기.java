package mon07.day17.boj_나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_나무자르기 {

	static int N, M;
	static int[] tree;
	static long maxHeight = Long.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 나무의 개수
		M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이
		tree = new int[N];
	
		st = new StringTokenizer(br.readLine());
		
		long max = Integer.MIN_VALUE; // 주어진 나무에서 가장 큰 나무의 높이
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}		
		binarySearch(0, max);
		System.out.println(maxHeight);
	}
	
	private static void binarySearch(long start, long end) {
		
		while(start <= end) {
			long mid = (start+end)/2; // mid = 현재 선택한 높이 H
			long count = 0;
			// 모든 나무를 베었을 때, 나오는 나무의 길이 계산
			for(int i = 0; i < N; i++) {
				if(tree[i] <= mid) continue; // 선택한 높이가 나무보다 높으면 PASS
				count += tree[i]-mid;
			}
			if(count >= M) { // 적어도 M보다 크거나 같으면 -> 높이를 증가시켜보자
				maxHeight = Math.max(mid, maxHeight);
				start = mid+1;
			}
			else { // 합이 M보다 적으면 -> 높이를 감소시켜보자
				end = mid-1;
			}
		}
	}
}
