package mon10.day31.boj_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] height = new int[W];
		
		int maxHeight = 0;
		int maxHeightIndex = 0;
		int heightSum = 0;
		
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			
			// 가장 높은 막대의 길이와 인덱스를 찾기
			if(height[i] > maxHeight) {
				maxHeight = height[i];
				maxHeightIndex = i;
			}
			// 막대들의 합 구하기
			heightSum += height[i];
		}
		
		int total = 0; // 전체 넓이를 저장할 변수
		int prevHeight = 0; // 현재 막대의 높이와 비교할 이전 막대
		
		// 1. 가장 높은 막대를 기준으로 왼쪽 접근
		for(int i = 0; i < maxHeightIndex; i++) {
			// 이전 높이와 비교했을 때, 현재 높이가 더 크면 현재 높이 선택. (현재 높이가 더 작으면 이전 높이 선택)
			if(height[i] > prevHeight)
				prevHeight = height[i];
			
			total += prevHeight;
		}
		
		prevHeight = 0; // 초기화
		
		// 2. 가장 높은 막대를 기준으로 오른쪽으로 접근
		for(int i = W-1; i >= maxHeightIndex; i--) {
			// 이전 높이와 비교했을 때, 현재 높이가 더 크면 현재 높이 선택. (현재 높이가 더 작으면 이전 높이 선택)
			if(height[i] > prevHeight)
				prevHeight = height[i];
			
			total += prevHeight;
		}
		
		// 빗물의 양 = 전체 넓이 - 막대들의 높이의 합
		System.out.println(total - heightSum);	
	}
}
