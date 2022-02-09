package mon02.day09.boj_행렬제곱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_행렬제곱 {
	
	static int N;
	static long B;
	static long matrix[][];
	static long result[][]; 
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		matrix = new long[N][N];
		result = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Long.parseLong(st.nextToken());
				result[i][j] = matrix[i][j];
			}
		}
		
		solution(B);

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j] % 1000 + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	// B에 대해 분할정복 
	private static void solution(long b) {
		if(b == 1) {
			return ;
		}

		solution(b/2);
		multiple(result, result);
		
		// 홀수인 경우
		if(b % 2 == 1)
			multiple(result, matrix);
	}
	
	private static void multiple(long[][] a, long[][] b) {
		// result * result 계산
		long[][] temp = new long[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// (i, j) 값 구하기
				for(int k = 0; k < N; k++) {
					temp[i][j] += (a[i][k] * b[k][j]) % 1000;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				a[i][j] = temp[i][j];
			}
		}
	}
}
