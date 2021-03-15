package mon01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2422 {
	static boolean[][] arr;
	static int n, m;
	static int ans = 0;
	
	// temp에 지금까지 뽑은 숫자 저장
	static void iceCream(int[] temp, int current, int start) {
		if(current == 3) { // 3가지 맛 모두 뽑음
			if(arr[temp[0]][temp[1]] || arr[temp[0]][temp[2]] || arr[temp[1]][temp[2]]) 
				return;
			ans++;
		}
		else {
			for(int i = start; i < n; i++) {
				temp[current] = i+1;
				iceCream(temp, current+1, i+1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new boolean[n+1][n+1];
		int temp[] = new int[3];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int ice1 = Integer.parseInt(st.nextToken());
			int ice2 = Integer.parseInt(st.nextToken());
			arr[ice1][ice2] = true;
			arr[ice2][ice1] = true;
		}
		
		iceCream(temp, 0, 0);
		System.out.println(ans);
	}
}
