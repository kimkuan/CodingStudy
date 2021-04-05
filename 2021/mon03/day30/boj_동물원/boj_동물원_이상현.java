package mon03.day30.boj_동물원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_동물원_이상현 {
	
	static int N;
	static int[] input;
	static int[] count;
	static boolean[] cat;
	static boolean[] rabbit;
	static int result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		count = new int[N]; // 0부터 N-1개의 개수
		cat = new boolean[N];
		rabbit = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) { 
			input[i] = Integer.parseInt(st.nextToken());
			if(input[i] >= N) { // 한 개라도 N보다 큰 값이 들어오면 바로 종료
				System.out.print(0);
				return;
			}
			count[input[i]]++;
			if(count[input[i]] > 2) { // 한 개라도 N보다 큰 값이 들어오면 바로 종료
				System.out.print(0);
				return;
			}
		}
		Arrays.sort(input); // 오름차순 정렬
		combination(0, 0, 0, 0);
		System.out.println(result);
	}
	private static void combination(int cnt, int start, int catCnt, int rabCnt) {
		
		// 가지치기
		for(int i = 0; i < catCnt; i++)  // 0부터 catCnt까지 하나라도 false면 불가능
			if(cat[i] == false) return;
		for(int i = 0; i < rabCnt; i++)  // 0부터 rabCnt까지 하나라도 false면 불가능
			if(rabbit[i] == false) return;
		
		// 기저조건
		if(cnt == N) {	
			if(catCnt + rabCnt != N) return; // 고양이의 수와 토끼의 수의 합이 N이 아니면 불가능
			result++; 
			return;
		}
		
		for(int i = start; i < N; i++) {
			int higherCnt = input[i];
			boolean flag = false;
			// 해당 값이 고양이일 경우
			if(!cat[higherCnt]) {
				cat[higherCnt] = true;
				combination(cnt+1, i+1, catCnt+1, rabCnt);
				cat[higherCnt] = false;
				flag = true;
			}
			// 해당 값이 토끼일 경우
			if(!rabbit[higherCnt]) {
				rabbit[higherCnt] = true;
				combination(cnt+1, i+1, catCnt, rabCnt+1);
				rabbit[higherCnt] = false;
				flag = true;
			}
			
			if(!flag) return; // 두 경우 모두 안되면 끝
		}
	}
}
