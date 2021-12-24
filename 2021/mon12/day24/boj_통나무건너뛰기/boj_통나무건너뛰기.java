package mon12.day24.boj_통나무건너뛰기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 풀이 시간 : 1시간 30분 , (풀이 들은 후) 15분
 * 시간복잡도 : O(T * NlogN)
 * IDE 사용 : O
*/

public class boj_통나무건너뛰기 {

	static int T, N;
	static int[] wood;
	static int[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());	
			wood = new int[N];
			result = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				wood[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append(getMinGrade());
			sb.append("\n");
		}	
		System.out.println(sb.toString());
	}
	
	private static int getMinGrade() {
			
		// 오름차순으로 정렬
		Arrays.sort(wood);
		
		// 정렬했을 때 가장 작은 값과 가장 큰 값이 같다면 모든 값이 같다.
		if(wood[0] == wood[N-1])
			return 0;
		
		int index = 0;
		int start = 0;
		int end = N-1;
		
		// 정렬한 차례대로 왼쪽, 오른쪽 (지그재그)으로 번갈아가며 채우는게 인접한 높이 차가 가장 작다!
		while(start <= end) {
			// 짝수일 때는, 앞부터 채우기
			if(index % 2 == 0)
				result[start++] = wood[index++];
			else
				result[end--] = wood[index++];
		}
		
		// 결과값에서 가장 차이가 많이 나는 경우 구하기
		int minGrade = Math.abs(result[N-1] - result[0]); 
		for (int i = 1; i < N; i++) {
			minGrade = Math.max(Math.abs(result[i] - result[i-1]), minGrade);
		}
		
		return minGrade;
	}
}
