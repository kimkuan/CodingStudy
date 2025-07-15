package y2021.mon06.day24.boj_직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_직사각형 {

	static class Square{
		int sx;
		int sy;
		int ex;
		int ey;
		
		public Square(int sx, int sy, int ex, int ey) {
			this.sx = sx; this.sy = sy;
			this.ex = ex; this.ey = ey;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 4; // 4줄을 입력받음
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			Square s1 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Square s2 = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
			int sumX = (s1.ex - s1.sx) + (s2.ex - s2.sx);
			int sumY = (s1.ey - s1.sy) + (s2.ey - s2.sy);
			int subX = subX(s1, s2);
			int subY = subY(s1, s2);

			if(subX > sumX || subY > sumY) 
				sb.append("d");
			else if(subX == sumX && subY == sumY) 
				sb.append("c");
			else if(subX == sumX || subY == sumY) 
				sb.append("b");
			else 
				sb.append("a");
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int subX(Square s1, Square s2) {
		if(s1.ex < s2.ex) 
			return Math.abs(s2.ex - s1.sx);
		return Math.abs(s1.ex - s2.sx);
	}
	
	public static int subY(Square s1, Square s2) {
		if(s1.ey < s2.ey)
			return Math.abs(s2.ey - s1.sy);
		return Math.abs(s1.ey - s2.sy);
	}
}
