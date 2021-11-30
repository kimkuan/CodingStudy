package mon11.day30.boj_숨바꼭질2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_숨바꼭질2 {
	
	static int N, K;
	static int timeResult, countResult;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		findSister();
		
		System.out.println(timeResult);
		System.out.println(countResult);
	}

	
	private static void findSister() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int[] visited = new int[100001]; // 이미 이동한 위치에 대한 최소 시간 저장
		int time = 0;
		
		// 수빈이의 위치에서 시작
		q.add(N);
		visited[N] = -1;

		// 시작부터 같은 위치에 있을 때
		if(N == K) {
			timeResult = 0;
			countResult = 1;
			return;
		}

		// 아니라면, 동생 찾기
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			
			for(int i = 0; i < size; i++) {
				int x = q.poll();
				int next;
								
				for(int j = 0; j < 3; j++) {
					next = nextStep(x, j);
				
					// 아직 방문한 적이 없거나, 최소 시간안에 방문한 경우
					if(next >= 0 && next <= 100000 && (visited[next] == 0 || visited[next] == time)) {
						q.add(next);
						visited[next] = time;
					}
					
					// 동생을 찾았다면
					if(next == K) {
						timeResult = time;
						countResult += 1;
					}
				}
			}

			// 이미 동생을 찾았다면, 더이상 시도하지 X
			if(countResult > 0)
				break;
		}
	}
	
	static int nextStep(int x, int j) {
		if(j == 0)
			return x-1;
		else if(j == 1)
			return x+1;
		else
			return 2*x;
	}
}
