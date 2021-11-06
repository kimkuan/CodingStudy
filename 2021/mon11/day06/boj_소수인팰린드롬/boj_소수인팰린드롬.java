package mon11.day06.boj_소수인팰린드롬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_소수인팰린드롬 {
	
	static boolean[] isNotPrime = new boolean[100000001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		// 에라토스테네스의 체를 이용하여 소수를 미리 계산
		InitPrimeNumber();
		
		for(int i = a; i <= b; i++) {
			// 펠린드롬인지 판단
			if(!isPallendrom(i))
				continue;
			
			// 해당 숫자가 소수인지 판단
			if(isNotPrime[i]) 
				continue;
			
			sb.append(i + "\n");
		}
		sb.append(-1); // 마지막 줄에는 -1을 출력!
		System.out.print(sb.toString());
	}
	
	// 펠린드롬 판단
	private static boolean isPallendrom(int n) {
		String str = String.valueOf(n);
		int len = str.length(); // 해당 숫자의 자릿수
		
		// 짝수 자릿수 숫자인데 그 값이 11이 아닐 때 -> 짝수 자릿수 숫자중에서는 11의 배수만 펠린드롬이 가능하다
		if(len % 2 == 0 && n != 11)
			return false;
		
		int start = 0;
		int end = len - 1;
		while(start < end) {
			if(str.charAt(start) != str.charAt(end))
				return false;
		
			start++;
			end--;
		}
		return true;
	}

	// 소수 판단
	private static void InitPrimeNumber() {	
		double size = Math.sqrt(100000000);
	
		for (int i = 2; i <= size; i++) {
			// 아직 지워지지 않은 값이라면 -> 즉, false라면 (true이면 소수가 아닌 값)
			if(!isNotPrime[i]) {
				// i의 배수에 해당하는 모든 값들을 true로 변환
				for (int j = i+i; j <= 100000000; j += i) {
					isNotPrime[j] = true;
				}
			}	
		}
	}
}