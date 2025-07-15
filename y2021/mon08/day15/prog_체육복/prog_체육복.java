package com.mon08.day15.prog_체육복;

import java.util.Arrays;





public class prog_체육복 {

	static int n = 3;
	static int[] lost = {3};
	static int[] reserve = {1};
	public static void main(String[] args) {

		int[] student = new int[n+2]; // 1: 여벌이 있음, -1: 도난 당함
		
		// 1. 여벌을 가지고온 학생이 도난을 당했는 지 체크
		for (int i = 0; i < lost.length ; i++)   
			student[lost[i]] += -1;
		
		for (int i = 0; i < reserve.length ; i++) 
			student[reserve[i]] += 1;

		
		// 2. 1명에게만 받을 수 있는 학생들에게 먼저 빌려줌
		for (int i = 1; i <= n; i++) {
			if(student[i] == -1) { // 도난 당한 학생이고 
				if(student[i-1] * student[i+1] == 1) continue;
				
				if(student[i-1] == 1 && student[i+1] < 1){ // 앞 학생이 빌려줄 수 있으면
					student[i] += 1;
					student[i-1] -= 1;
				}
				else if(student[i-1] < 1 && student[i+1] == 1) { // 뒷 학생이 빌려줄 수 있으면
					student[i] += 1;
					student[i+1] -= 1;
				}
			}
		}

		// 3. 그 다음, 2명에게 받을 수 있는 학생들에게 빌려줌
		for (int i = 1; i <= n; i++) {
			if(student[i] == -1) { // 도난 당한 학생이고 
				if(student[i-1] == 1){ // 앞 학생이 빌려줄 수 있으면
					student[i] += 1;
					student[i-1] -= 1;
				}
				else if(student[i+1] == 1) { // 뒷 학생이 빌려줄 수 있으면
					student[i] += 1;
					student[i+1] -= 1;
				}
			}
		}
		
		int answer = 0;
		for(int i = 1 ; i <= n; i++) {
			if(student[i] >= 0) answer++;
		}
		System.out.println(answer);
	}
}
