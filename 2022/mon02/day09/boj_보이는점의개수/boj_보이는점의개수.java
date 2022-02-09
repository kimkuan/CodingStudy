package mon02.day09.boj_보이는점의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_보이는점의개수 {
	
	static int[][] result = new int[1001][1001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		
		init();
		
		while(C-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(countStart(N) + "\n");
		}
		System.out.print(sb.toString());
	}

	private static void init() {
		for(int i = 0; i <= 1000; i++) {
			for(int j = 0; j <= 1000; j++) {
				result[i][j] = gcd(i, j);					
			}
		}
	}

	private static int countStart(int N) {
		int count = 0;
		
		for(int i = 0; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				// 최대 공약수가 1인 경우에만 카운트
				if(result[i][j] == 1)
					count++;
			}
		}
		
		return count;
	}
	
	// TIP! BigInteger 클래스는 내부함수로 gcd를 제공한다
	private static int gcd(int x, int y){	
		int temp;
		
		while(y > 0) {
			temp = x % y;
			x = y;
			y = temp;
		}
		return x; 
	}
}

// 각도에 따라 보이는 점이 판단됨 -> 같은 각도에서는 한 개의 점만 보인다

// 두 수의 최대공약수가 1인 애들만 카운트