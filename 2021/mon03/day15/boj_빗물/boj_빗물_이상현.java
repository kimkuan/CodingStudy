package mon03.day15.boj_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_빗물_이상현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		int[] height = new int[W];
		int maxHeight = 0, maxIndex = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < W; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			if(maxHeight < height[i]) {
				maxHeight = height[i];
				maxIndex = i;
			}
		}
		
		int startHeight = height[0];
		for(int i = 0; i <= maxIndex; i++) {
			if(height[i] > startHeight) 
				startHeight = height[i];
			else
				answer += startHeight - height[i];
		}
		
		startHeight = height[W-1];
		for(int i = W-1; i > maxIndex; i--) {
			if(height[i] > startHeight) 
				startHeight = height[i];
			else
				answer += startHeight - height[i];
		}
		System.out.println(answer);
	}
}
