package mon04.day09.boj_컬러볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_컬러볼_이상현 {

	static int N;
	static Ball[] balls;
	static long[] score; // i번공의 점수
	static HashMap<Integer, Long> colorScore = new HashMap<Integer, Long>(); // 해당 색상의 누적합 -> 해쉬대신 배열쓰기!! 접근 O(logN)
	
	static class Ball implements Comparable<Ball>{
		int idx;
		int color;
		int size;
		
		public Ball(int idx, int color, int size) {
			this.idx = idx;
			this.color = color;
			this.size = size;
		}
		@Override
		public int compareTo(Ball o) {
			if(this.size == o.size)
				return this.color - o.color; //  (같으면 컬러도 오름차순)
			return this.size - o.size; // 크기 순으로 오름차순
		}
		@Override
		public String toString() {
			return " 번호 : "  + this.idx +  " 색상 : " +this.color + " 크기 : " + this.size; 
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		input();
		gamestart();
		for(int i = 0; i < N; i++) {
			sb.append(score[i]).append("\n");
		}
		System.out.print(sb);
	}
	
	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		balls = new Ball[N];
		score = new long[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			balls[i] = new Ball(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(balls);
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(balls[i].toString());
//		}
	}
	
	public static void gamestart() {
		long total = 0; // i번 공의 점수
		int prevSize = 0; // 이전 공의 크기
		
		// 쭉 돌면서 만약 누적합을 구함 -> total 
		// total에서 같은 색상끼리의 누적합을 빼줌
		for(int i = 0; i < N; i++) { // 현재 공을 기준으로
			if(!colorScore.containsKey(balls[i].color))
				colorScore.put(balls[i].color, (long) 0);
			
			// 현재 크기와 이전 공의 크기가 같다면  이전 공 중에서 크기가 같은 애들은 제외
			if(prevSize == balls[i].size) { 
				int sub = 0; // 빼야 할 값
				for(int j = i-1; j >= 0; j--) {
					if(balls[i].size != balls[j].size) // 색깔이 같거나 크기가 같지 않을 때 까지
						break;
					if(balls[i].color != balls[j].color) // 컬러가 다를 때만 더해준다
						sub += balls[j].size;
				}
				score[balls[i].idx] = total - sub - colorScore.get(balls[i].color); // 현재 공의 점수 (현재 총 값  - 같은 크기의 공의 점수 합 - 해당 색상의 누적합)
			}
			else
				score[balls[i].idx] = total - colorScore.get(balls[i].color); // 현재 공의 점수 (현재 총 값  - 해당 색상의 누적합)
			
			total += balls[i].size; // 현재 공까지의 합
			colorScore.put(balls[i].color, colorScore.get(balls[i].color) + balls[i].size); // 현재 공도 해당 색의 공의 누적합에 추가
		
			prevSize = balls[i].size; // 현재공을 이전공으로 갱신
		}
	}
}

// 크기 순으로 정렬한 후에 
// 만약 크키가 더 작은 값들 중에 자신과 같은 색깔의 공이 있다면 = >  해당 공까지의 점수 + 해당 공에서부터 자신까지의 점수 
// 없으면 쭉 탐색