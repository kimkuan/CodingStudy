package com.mon09.day11.prog_6주차;

import java.util.Arrays;
import java.util.Comparator;

public class prog_6주차 {

	static int[] weights = {50,82,75,120};
	static String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
	
	public static void main(String[] args) {
		
		int N = weights.length;
		double[] winPercent = new double[N]; // 다른 복서랑 붙어서 이긴 승률
		int[] winMoreWeight = new int[N]; // 자신보다 무거운 사람과 붙어서 이긴 횟수
		
		for (int i = 0; i < N; i++) {
			int count = 0; // 다른 선수랑 붙은 횟수
			int win = 0; // 다른 선수랑 붙어서 이긴 횟수
			int winWithMore = 0; // 자신보다 무거운 선수를 이긴 횟수
			
			for (int j = 0; j < N; j++) {
				if(head2head[i].charAt(j) == 'N') 
					continue;
				
				if(head2head[i].charAt(j) == 'W') {
					win++;
					winWithMore += weights[i] < weights[j] ? 1 : 0; 
				}
				count++;
			}
			winPercent[i] = count == 0 ? 0 : (double)win/count * 100;
			winMoreWeight[i] = winWithMore;
		}
		
		Integer[] player = new Integer[N];
		for (int i = 0; i < N; i++) { // 1번 ~ N번 선수들 저장
			player[i] = i;
		}
		
		Arrays.sort(player, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int cmp = Double.compare(winPercent[o2], winPercent[o1]);
				
				if(cmp == 0) 
					cmp = Integer.compare(winMoreWeight[o2], winMoreWeight[o1]);
				if(cmp == 0)
					cmp = Integer.compare(weights[o2], weights[o1]);
				if(cmp == 0)
					cmp = Integer.compare(o1, o2);
					
				return cmp;
			}
		});
		
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) { // 1번 ~ N번 선수들 저장
			answer[i] = player[i]+1;
		}
	}
}

// 전체 승률이 높은 복서의 번호가 앞쪽으로 갑니다. 아직 다른 복서랑 붙어본 적이 없는 복서의 승률은 0%로 취급합니다.
// 승률이 동일한 복서의 번호들 중에서는 자신보다 몸무게가 무거운 복서를 이긴 횟수가 많은 복서의 번호가 앞쪽으로 갑니다.
// 자신보다 무거운 복서를 이긴 횟수까지 동일한 복서의 번호들 중에서는 자기 몸무게가 무거운 복서의 번호가 앞쪽으로 갑니다.
// 자기 몸무게까지 동일한 복서의 번호들 중에서는 작은 번호가 앞쪽으로 갑니다.
