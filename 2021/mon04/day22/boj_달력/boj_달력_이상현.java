package mon04.day22.boj_달력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_달력_이상현 {

	static int[] count; // 각 날짜에 쌓인 일정 개수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		count = new int[367]; // 마지막에 무조건 끝나도록 + 1
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for(int j = start; j <= end; j++) 
				count[j]++;
		}

		int max = 0; // 연속된 날짜에서 가장 큰 높이(사용횟수)
		int len = 0; // 연속된 길이
		int sum = 0; // 면접의 합
		for(int i = 1; i <= 366; i++) {
			if(count[i] > 0) { // 연속의 시작 or 연속 중임
				max = Math.max(count[i], max);
				len++;
			}else {
				sum += len * max; // 현재 연속된 일정의 면적 더해주고
				len = 0; // 연속된 길이와 최대 높이 초기화
				max = 0;
			}
		}
		System.out.println(sum);
	}
}
