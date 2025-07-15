package y2021.mon12.day22.boj_트럭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_트럭 {

	static int N, W, L;
	static ArrayDeque<Integer> input = new ArrayDeque<Integer>();
	static ArrayDeque<Truck> output = new ArrayDeque<Truck>();
	
	static class Truck {
		int weight;
		int inputTime; 
		
		public Truck(int weight, int inputTime) {
			this.weight = weight;
			this.inputTime = inputTime;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 트럭의 수
		W = Integer.parseInt(st.nextToken());	// 다리의 길이
		L = Integer.parseInt(st.nextToken());	// 다리의 최대하중
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input.add(Integer.parseInt(st.nextToken()));
		}
		
		int result = checkLeastTime();
		System.out.println(result);
	}

	private static int checkLeastTime() {
		int time = 0;
		int currentWeight = 0; // 현재 다리가 버티고 있는 무게
		
		while(true) {

			// 다리를 지나가는 트럭이 더이상 없으면 break
			if(input.isEmpty() && currentWeight == 0) {
				break;
			}
			
			// 다리를 건너고 있는 트럭 중에서
			if(!output.isEmpty()) {
				Truck truck = output.peek();
				// 다리를 모두 지난 트럭이 존재한다면
				if(time - truck.inputTime == W) {
					int weight = truck.weight;
					currentWeight -= weight;
					output.poll();
				}
			}
						
			// 새로운 트럭이 다리에 들어갈 수 있으면
			if(!input.isEmpty() && currentWeight+input.peek() <= L) {
				int weight = input.poll();
				currentWeight += weight;
				output.add(new Truck(weight, time));
			}
			time++;
		}
		
		return time;
	}

}
