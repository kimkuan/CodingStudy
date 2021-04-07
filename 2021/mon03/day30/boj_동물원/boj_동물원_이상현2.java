package mon03.day30.boj_동물원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_동물원_이상현2 {
	
	static int N;
	static int[] input;
	static int[] count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		count = new int[N]; // 0부터 N-1개의 개수

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) { 
			input[i] = Integer.parseInt(st.nextToken());
			if(input[i] >= N) { // 한 개라도 N보다 큰 값이 들어오면 바로 종료
				System.out.print(0);
				return;
			}
		}
		
		Arrays.sort(input); // 오름차순 정렬
		for(int i = 0; i < N; i++) {
			int now = input[i];
			count[now]++; // 현재 값을 1 증가
			
			if(count[now] > 2) { // 들어온 값이 2보다 크면 안됨
				System.out.print(0);
				return;
			}
			else if(now > 0 && count[now-1] < count[now]) { // 현재값이 이전의 크기보다 크면 안됨 (연속적임을 포함)
				System.out.print(0);
				return;
			}
		}
		
		int result = 1;
		int max = input[N-1];
		for(int i = 0; i <= max; i++) { // 최댓값 전까지
			if(count[i] == 2) result *= 2;			
		}
		if(count[max] == 1) result *= 2; // 최댓값이 1이면 경우의 수는 2배
		System.out.println(result);
	}
}
