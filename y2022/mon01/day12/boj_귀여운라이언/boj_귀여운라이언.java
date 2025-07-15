package y2022.mon01.day12.boj_귀여운라이언;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_귀여운라이언 {
	
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = -1;
				
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int doll = Integer.parseInt(st.nextToken());
			
			if(doll == 1) // 라이언인형일 때, 인덱스를 list에 저장
				list.add(i);
		}
	
		// 라이언인형이 K개 이상이면, 가장 작은 연속된 인형들의 집합의 크기 구하기
		if(list.size() >= K)
			answer = getLeastSize(K);
		
		System.out.println(answer);
	}

	private static int getLeastSize(int K) {
		
		int size = list.size();
		int answer = Integer.MAX_VALUE;
	
		for(int left = 0; left < size; left++) {
			
			int right = left;
			int cnt = 0;
			
			while(right < size && cnt < K) {
				cnt++; 
				right++;
			}
			
			if(cnt == K) {
				answer = Math.min(answer, list.get(right-1) - list.get(left) + 1);
			}
		}
		
		return answer;
	}
}
