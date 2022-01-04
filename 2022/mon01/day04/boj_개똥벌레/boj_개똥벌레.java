package mon01.day04.boj_개똥벌레;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_개똥벌레 {

	static int N, H, size;
	static int minCount = Integer.MAX_VALUE, count = 0;
	static int[] up;
	static int[] down;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());		
		size = N / 2;
		
		up = new int[size];
		down = new int[size];
		
		int upIdx = 0, downIdx = 0;
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(br.readLine());
			
			if(i % 2 == 0)
				down[downIdx++] = height;
			else
				up[upIdx++] = height;
		}
		
		Arrays.sort(up);
		Arrays.sort(down);
		
		for (int h = 1; h <= H; h++) {
			findLeastHeight(h);
		}
		
		System.out.println(minCount + " " + count);
	}
	
	private static int binarySearch(int left, int right, int[] arr, int h) {
		int idx = Integer.MAX_VALUE; // 처음 부딪히게 되는 물체의 인덱스
		
		while(left <= right) {
			int mid = (left+right)/2;
			
			// 만약 높이가 같거나 현재 높이보다 크면 -> 왼쪽으로 이동
			// 왜냐면, 현재 높이에서 석순과 닿은 높이보다 크거나 같은 높이의 석순들은 당연히 파괴될 것이기 때문에
			// 따라서 현재 높이와 닿는 석순의 최소 높이를 구하는 것!
			if(arr[mid] >= h) {
				idx = mid;
				right = mid - 1;
			}
			else
				left = mid + 1;
		}
		return idx == Integer.MAX_VALUE ? 0 : size-idx;
	}
	
	private static void findLeastHeight(int h) {
		int downCount = binarySearch(0, size-1, down, h); // 석순의 경우에는 h=3일 때 h=3(h)보다 크거나 같은 경우 파괴됨
		int upCount = binarySearch(0, size-1, up, H-h+1); // 종유석의 경우에는 h=3일 때는 h=5(H-h+1)보다 크거나 같은 경우 파괴됨
				
		int sum = downCount + upCount;
		
		if(sum < minCount) {
			minCount = sum;
			count = 1;
		}
		else if(sum == minCount) {
			count++;
		}
	}
}
