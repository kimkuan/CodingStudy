package mon02.day25.boj_창고다각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_창고다각형_이상현 {

	static int[] height;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxH = 0, maxIdx = 0;
		int ans = 0;
		height = new int[1001]; // 높이
			
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			height[idx] = h;
			if(maxH < h) {
				maxH = h;
				maxIdx = idx;
			}
		}
		
		int tempH = 0;
		for(int i = 0; i <= maxIdx; i++) {
			if(tempH < height[i])
				tempH = height[i];
			ans += tempH;
		}
		
		tempH = 0;
		for(int i = 1000; i > maxIdx; i--) {
			if(tempH < height[i])
				tempH = height[i];
			ans += tempH;
		}
		
		System.out.println(ans);
	}
}
