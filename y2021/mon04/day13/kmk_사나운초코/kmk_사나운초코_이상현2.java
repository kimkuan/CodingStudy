package y2021.mon04.day13.kmk_사나운초코;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kmk_사나운초코_이상현2 {

	static int N, K;
	static int answer = 1; // 최대 거리
	static int[] arr;
	static boolean[] select;
	
	public static void main(String[] args) throws IOException {
		input();
		select[0] = true; // 맨 양쪽 값은 일단 선택
		select[N-1] = true;

		choice(0, 1, 2);
		System.out.println(answer);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		select = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // 오름차순 정렬
	}
	
	// prev 이전에 선택한 값
	public static void choice(int prevIdx, int start, int cnt) {
		if(cnt == K) {
			int gab = Integer.MAX_VALUE;
			int prev = arr[0];
			
			for(int i = 1; i < N; i++) {
				if(select[i]) {
					gab = Math.min(arr[i] - prev, gab);
					prev = arr[i];
				}
			}
			answer = Math.max(answer, gab);
			return;
		}
	
		for(int i = start; i < N-1; i++) {
			if(arr[i] - arr[prevIdx] < answer) continue; // 이전에 선택한 애보다 갭이 작은 애는 볼 필요없음
			
			select[i] = true;
			choice(i, i+1, cnt+1);
			select[i] = false;
		}
	}
}
