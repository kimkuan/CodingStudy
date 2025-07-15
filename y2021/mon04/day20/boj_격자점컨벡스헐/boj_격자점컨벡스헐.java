package y2021.mon04.day20.boj_격자점컨벡스헐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_격자점컨벡스헐 {
	static int N;
	static Point[] list;
	static Stack<Point> stack = new Stack<Point>();

	static class Point implements Comparable<Point>{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		@Override
		public int compareTo(Point o) {
			if(this.y == o.y)  // 작은 점
				return Integer.compare(this.x, o.x);
			return Integer.compare(o.y, this.y); // y가 가장 큰 점
		}
	}

	public static int ccw(Point r, Point p, Point q) {
		int first = (p.x - r.x) * (q.y - r.y);
		int second = (p.y - r.y) * (q.x - r.x);
		int result = first - second;
		
		if(result > 0) return -1; // 반시계방향일 때 -1 리턴
		else if(result == 0) return 0;
		else return 1; // 시계방향일 때 1 리턴 (맞는 방향)
	}
	
	public static long getDistance(Point p1, Point p2) { // sqrt를 씌워줘야 double형으로 반환!
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}
	
	public static void graham() {
		stack.push(list[0]);
		stack.push(list[1]);
		
		for(int i = 2; i < N; i++) {
			Point next = list[i];
			
			while(stack.size() >= 2) {
				Point second = stack.pop();
				Point first = stack.peek();
				
				int ccw = ccw(first, second, next);
				if(ccw > 0) { // 시계방향이 맞을 때만
					stack.push(second);
					break;
				}
			}
			stack.push(next);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new Point[N];
			
			int idx = 0; // 좌표가 배열에 저장될 인덱스
			int R = (N % 5 == 0) ? N/5 : N/5+1;
			for(int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens()) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					list[idx++] = new Point(x, y);
				}
			}
			
			Arrays.sort(list); // 1차 정렬 (y는 가장 크고, x는 작은 순)
			// 기준점 -> list[0]
			Arrays.sort(list, 1, N, new Comparator<Point>() { // 2차 정렬 (반시계방향, 거리순)
				@Override
				public int compare(Point o1, Point o2) {
					int ccw = ccw(list[0], o1, o2);
					
					if(ccw > 0) return -1; // 시계방향 순서면 유지
					else if(ccw < 0) return 1; // 반시계방향이면 교체
					else {
						long dist1 = getDistance(list[0], o1);
						long dist2 = getDistance(list[0], o2);
						
						return Long.compare(dist1, dist2); // 거리가 더 가까운 순으로
					}
				}
			});
			
			graham();
			
			sb.append(stack.size()).append("\n");
			for(int i = 0; i < stack.size(); i++) 
				sb.append(stack.get(i).x).append(" ").append(stack.get(i).y).append("\n");
			stack.clear();
		}
		sb.setLength(sb.length() - 1);
		System.out.print(sb);
	}
}
