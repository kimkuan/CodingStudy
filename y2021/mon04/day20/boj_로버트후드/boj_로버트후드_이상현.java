package y2021.mon04.day20.boj_로버트후드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_로버트후드_이상현 {

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
		public int compareTo(Point o) {
			if(this.y == o.y)
				return Integer.compare(this.x, o.x); // y가 같으면 x가 작은 순서
			return Integer.compare(this.y, o.y); // y가 작은 좌표순서
		}
	}
	
	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new Point[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list[i] = new Point(x, y);
		}
	}
	
	public static int ccw(Point r, Point p, Point q) { // r이 기준점!!
		int first = (p.x - r.x) * (q.y - r.y); // 식 주의 (곱셈임)
		int second = (p.y - r.y) * (q.x - r.x);
		int result = first - second;

		if(result > 0) return 1; // 반시계방향 (왼쪽)
		else if(result == 0) return 0;
		else return -1; // 시계방향 (오른쪽)
	}
	
	public static double getDistance(Point p1, Point p2) {
		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}
	
	public static void graham() {
		stack.push(list[0]);
		stack.push(list[1]);
		
		for(int i = 2; i < N; i++) {
			Point next = list[i];
			
			while(stack.size() >= 2) {
				Point second = stack.pop();
				Point first = stack.peek(); // first점은 뽑지 않음
				
				int ccw = ccw(first, second, next);
				if(ccw > 0) { // 반시계 방향이 나오면 -> 볼록껍질이 될 수 있음
					stack.push(second);
					break;
				}
			}
			stack.push(next);
		}
	}
	
	// 최대 거리 구하기
	public static double getMax() {
		double max = 0;
		int size = stack.size();
		Point[] convex = new Point[size];
		
		for(int i = 0; i < size; i++) 
			convex[i] = stack.pop();

		for(int i = 0; i < size - 1; i++) {
			for(int j = i+1; j < size; j++) {
				max = Math.max(max, getDistance(convex[i], convex[j]));
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		Arrays.sort(list); // 기준점을 찾기 위해 정렬
		
		// 기준점 -> list[0]
		Arrays.sort(list, 1, N, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				int ccw = ccw(list[0], o1, o2);
				
				if(ccw > 0) return -1; // 반시계이므로 그대로 유지
				else if(ccw < 0) return 1; // 시계방향이므로 변경
				else { // 일직선일 때
					double dist1 = getDistance(list[0], o1);
					double dist2 = getDistance(list[0], o2);
					return Double.compare(dist1, dist2); // 거리가 더 가까운 점 먼저
				}
			}
		});
		
		graham();
		System.out.println(getMax());
	}
}
