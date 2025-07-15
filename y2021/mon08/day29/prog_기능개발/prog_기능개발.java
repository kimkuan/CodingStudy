package com.mon08.day29.prog_기능개발;

import java.util.ArrayList;
import java.util.Arrays;

public class prog_기능개발 {

	static int[] progresses = {1, 1, 1, 1};
	static int[] speeds = {100, 100, 100, 100};
	
	public static void main(String[] args) {
		ArrayList<Integer> result = new ArrayList<>();
		int[] day = new int[progresses.length];
		
		for (int i = 0; i < day.length; i++) {
			int restDay = ((100 - progresses[i]) % speeds[i]) > 0 ? 1 : 0; // 나누어 떨어지지 않는 경우에는 +1이 더 필요
			day[i] = (100 - progresses[i]) / speeds[i];
			day[i] += restDay;
		}
		System.out.println(Arrays.toString(day));
	
		int prevDay = day[0]; // 이전 작업을 끝내는데 걸리는 일수
		int count = 1; // 이번 배포때 끝낼 수 있는 작업의 개수
		for (int i = 1; i < day.length; i++) {
			if(prevDay < day[i]) { // 이전배포일 보다 더 오래걸리는 작업이라면 다음 배포때로 미뤄짐
				result.add(count); // 이번 배포는 그럼 여기서 끝!
				prevDay = day[i];
				count = 1;
			}
			else {
				count++;
			}
		}
		result.add(count); // 마지막은 for문에서 add되지 않았으므로 따로 넣어줌
		
		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
		
		System.out.println(result);
	}

}
