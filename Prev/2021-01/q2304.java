import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* [S2] 창고 다각형 - 2304번 */

class Pillar{
	int x;
	int h;

	public Pillar(int x, int h) {
		this.x = x;
		this.h = h;
	}
}

public class q2304 {
	
	static int getMax(Queue<Pillar> q) {
		int max = 0;
		
		for(int i = 0; i < q.size(); i++) {
			Pillar p = q.poll();
			max = p.h > max ? p.h : max; 
			q.add(p);
		}
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Pillar> list = new ArrayList<>(); 
		Queue<Pillar> q = new LinkedList<>();
		
		int max = 0; // max를 기준으로 감소
		int area = 0; // 넓이 	
		boolean flag = false; // 가장 큰 값이 나왔는지 확인
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list.add(new Pillar(key, value));
			max = Math.max(max, value); // 최대 높이
		}
		
		Collections.sort(list, new Comparator<Pillar>() {
			@Override
			public int compare(Pillar o1, Pillar o2) {
				return o1.x - o2.x; // 오름차순
			}	
		});
		
		for(Pillar p : list) 
			q.add(p); // 큐에 넣기	
		
		int prev_x = 0; // 이전 위치
		int prev_h = 0; // 이전 높이
		
		while(!q.isEmpty()) {

			if(flag) { // 내리막
				max = getMax(q); // 현재 큐에 있는 값 중 최댓값		
				Pillar p = q.poll();
				
				if(p.h == max) {
					p.x++; // 넓이를 구할 때 해당 직사각형까지 포함.

					area += (p.x - prev_x) * p.h; // 넓이 구하기
					prev_x = p.x;
					prev_h = p.h;
				}
			}
			else { // 오르막
				Pillar p = q.poll();

				if(p.h > prev_h) {
					area += (p.x - prev_x) * prev_h; // 넓이구하기
					prev_x = p.x;
					prev_h = p.h;
					
					if(p.h == max) {
						flag = true;
						area += p.h;
						prev_x++; // max 이후부터 막대 그래프의 오른쪽으로 계산
					}
				}
			}
		}
		System.out.println(area);
		
	}
}
