package mon01.day26.boj_전구와스위치;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_전구와스위치2 {
	
	static int N;
	static int result = Integer.MAX_VALUE;
	static boolean[] state1, state2;
	static boolean[] goal;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		String start = br.readLine();
		String last = br.readLine();
		
		state1 = new boolean[N];
		state2 = new boolean[N];
		goal = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			state1[i] = start.charAt(i) == '1' ? true : false;
			state2[i] = start.charAt(i) == '1' ? true : false;
			goal[i] = last.charAt(i) == '1' ? true: false;
		}

		
		// 1. 첫번째 스위치를 누른 경우(state1)와 누르지 않은 경우로 나누기(state2)
		change(0, state1);
		
		// 2. i-1 인덱스를 보고 스위치를 누를지 말지 결정
		int count1 = 1, count2 = 0;
		for(int i = 1; i < N; i++) {
			if(state1[i-1] != goal[i-1]) {
				change(i, state1);
				count1++;
			}
			
			if(state2[i-1] != goal[i-1]) {
				change(i, state2);
				count2++;
			}
		}
		
		// 3. goal 상태로 만들 수 있는지 체크 후, 최소 횟수 저장
		if(isGoal(state1))
			result = Math.min(result, count1);
		
		if(isGoal(state2))
			result = Math.min(result, count2);

		result = result == Integer.MAX_VALUE ? -1 : result;
		System.out.println(result);
	}
	
	// 스위치 상태를 변경하는 메소드
	private static void change(int i, boolean[] state) {
		if(i == 0) {
			state[i] = !state[i];
			state[i+1] = !state[i+1];
		}
		else if(i == N-1) {
			state[i] = !state[i];
			state[i-1] = !state[i-1];
		}
		else {
			state[i-1] = !state[i-1];
			state[i] = !state[i];
			state[i+1] = !state[i+1];
		}
	}
	
	// goal 상태와 일치하는지 체크하는 메소드
	private static boolean isGoal(boolean[] state) {
		for (int i = 0; i < N; i++) {
			if(state[i] != goal[i])
				return false;
		}	
		return true;
	}
}
