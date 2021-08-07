package com.mon08.day07.prog_다단계칫솔판매;

import java.util.Arrays;
import java.util.HashMap;

public class prog_다단계칫솔판매 {

	static String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
	static String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
	static String[] seller = {"sam", "emily", "jaimie", "edward"};
	static int[] amount = {2, 3, 5, 4};
	
	static int[] cost;
	static HashMap<String, Integer> index = new HashMap<>(); // 해당 직원의 인덱스를 저장
	
	public static void main(String[] args) {

		cost = new int[enroll.length+1]; // 돈을 넣을 때는 자신의 index 위치에 넣기
	
		for (int i = 0; i < enroll.length; i++) { // 루트가 0, 나머지는 1부터 시작
			index.put(enroll[i], i); 
		}
		for (int i = 0; i < seller.length; i++) {
			reward(index.get(seller[i]), amount[i]*100);
		}
		System.out.println(Arrays.toString(cost));
	}

	private static void reward(int currentIndex, int amount) {
		System.out.println("현재 판매원 " + enroll[currentIndex]);
		System.out.println("현재 금액 " + amount);
		
		int nextAmount = amount*1/10; // 넘겨줄 양
		if(nextAmount < 1) { // 1원 미만일 경우에는 넘기지 않고 자신이 다 먹음
			cost[currentIndex] += amount;
			return; // 그리고 넘겨주지 않음
		}else {
			cost[currentIndex] += amount - nextAmount;
		}
		
		// 넘겨줄 수 있다면
		if(referral[currentIndex].equals("-")) { // 다음 위치가 루트라면 나누지않고 다 먹음
			return;
		}
		int referralIndex = index.get(referral[currentIndex]);
		reward(referralIndex, nextAmount);
	}
}
