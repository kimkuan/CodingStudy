package mon02.day01.boj_프린터큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int idx;
	int prior;
	public Pair(int idx, int  prior) {
		this.idx = idx;
		this.prior = prior;
	}
	public int getIdx() {
		return idx;
	}
	public int getPrior() {
		return prior;
	}
}

public class boj_프린터큐_이상현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Pair> q = new LinkedList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.getPrior() - o1.getPrior(); // 내림차순
			}
		});
		
		int tc = Integer.parseInt(br.readLine());
		while(tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int prior =  Integer.parseInt(st.nextToken());
				q.add(new Pair(j, prior));
				pq.add(new Pair(j, prior));
			}
			
			int cnt = 0;
			while(true) {
				Pair qFront = q.poll();
				Pair pqFront = pq.peek();

				if(qFront.getPrior() < pqFront.getPrior())
					q.add(qFront); // 다시 넣기
				else {
					cnt++;
					pq.poll();
					
					if(qFront.getIdx() == idx)
						break;
				}
			}
			
			System.out.println(cnt);
			q.clear();
			pq.clear();
		}
	}
}
