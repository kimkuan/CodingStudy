package mon01.day05.boj_수복원하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class boj_수복원하기 {
	
	static int MAX_SIZE = 100000;
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		findPrimeNumber();

		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			LCM(N);
		}
		
		System.out.print(sb.toString());
	}
	
	// 최소공배수를 찾는 메소드
	private static void LCM(int N) {
		// HashMap은 들어온 순서대로 저장이 안된다~~!!
		TreeMap<Integer, Integer> count = new TreeMap<Integer, Integer>(); // 사용한 소수의 개수를 저장할 MAP
		int size = prime.size();
		
		for(int i = 0; i < size; i++) {
			int sosu = prime.get(i);
			
			// 소인수분해가 완료되면
			if(N == 1) {
				break;
			}
			
			// 소수로 나누어 떨어지면
			while (N % sosu == 0) {
				count.put(sosu, count.getOrDefault(sosu, 0)+1);
				N = N / sosu;
			}
		}
		
		for(Entry<Integer, Integer> entry : count.entrySet()) {
			sb.append(entry.getKey() + " " + entry.getValue() + "\n");
		}
	}

	// 소수를 찾는 메소드
	private static void findPrimeNumber() {
		int[] num = new int[MAX_SIZE + 1];
		
		// 자기 자신으로 초기화
		for(int i = 2; i <= MAX_SIZE; i++) {
			num[i] = i;
		}

		for (int i = 2; i <= MAX_SIZE; i++) {
			if(num[i] == 0)
				continue;
			
			// 리스트에 소수 저장
			prime.add(i);
			
			// 자기자신(i)을 제외한 나머지 배수들은 모두 소수가 아니다
			for(int j = i+i; j <= MAX_SIZE; j += i) {
				num[j] = 0;
			}
		}
	}
}
