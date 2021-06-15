package mon06.day15.boj_강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_강의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int[][] timeTable = new int[N][2]; // [0] : 시작시간, [1] : 끝나는 시간
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			timeTable[i][0] = Integer.parseInt(st.nextToken());
			timeTable[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(timeTable, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) // 시작시간이 같으면 끝나는 시간이 빠른순
					return o1[1] - o2[1];
				return o1[0] - o2[0]; // 시작 시간이 빠른순
			}
		});
		
		for (int i = 0; i < N; i++) {
			int start = timeTable[i][0];
			int end = timeTable[i][1];
			
			while(!q.isEmpty() && q.peek() <= start){ // 현재 수업의 시작시간보다 값이 작으면 이미 끝난 수업들
				q.poll();
			}
			q.add(end);
			answer = Math.max(answer, q.size());
		}
		System.out.print(answer);
	}
}
