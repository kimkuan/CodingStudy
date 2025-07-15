package y2021.mon04.day13.kmk_사나운초코;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kmk_사나운초코_이상현 {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(binarySearch());
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // 오름차순 정렬
	}
	
	public static int binarySearch() {
		int ans = 0;
		int minDis = 1; // 가능한 최소 거리
		int maxDis = arr[N-1] - arr[0]; // 가능한 최대 거리

		while(minDis <= maxDis) {
			int start = 0;
			int cnt = 1; // 설치한 개수 (맨 앞은 무조건 선택한 상태)
			int mid = (minDis + maxDis) / 2; // 기준 간격 = 최소간격

			// 일정 간격(dis)을 기준으로 공유기 설치 해보기
			for(int i = 1; i < N; i++) {
				int dis = arr[i] - arr[start]; // 현재 설치할 자리와 이전에 설치한 공유기 사이의 거리
				if(mid <= dis) { // 최소 간격보다 크면 설치 가능
					cnt++; // 선택 -> 개수 증가
					start = i;
				}
			}
			
			// 공유기가 더 설치 되어야 한다 -> 간격 좁히기
			if(cnt < K) {
				maxDis = mid - 1;
			}
			// 공유기의 수를 줄여야 한다 -> 간격 넓히기
			else {
				ans = mid; // cnt == K라고 해서 그게 최대 간격이 되지는 않음. 따라서 쭉 갱신
				minDis = mid + 1;
			}
		}
		return ans;
	}
}
