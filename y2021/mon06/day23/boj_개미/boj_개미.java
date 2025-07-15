package y2021.mon06.day23.boj_개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_개미 {

	static int w, h, t;
	static int ax, ay;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		w = Integer.parseInt(st.nextToken()); // 너비
		h = Integer.parseInt(st.nextToken()); // 높이
		
		st = new StringTokenizer(br.readLine());
		ax = Integer.parseInt(st.nextToken()); // 개미의 위치 (ax, ay)
		ay = Integer.parseInt(st.nextToken());
		
		t = Integer.parseInt(br.readLine()); // 개미가 움직일 시간
		
		ax = (ax + t)%(2*w); // w의 2배만큼 왔다갔다하면 처음 ax 그대로임
		ay = (ay + t)%(2*h);
		
		ax = w - Math.abs(w - ax); // 만약 2*w로 나눈 나머지값이 w보다 크면 2w-나머지 해줘야한다
		ay = h - Math.abs(h - ay);
		
		sb.append(ax).append(" ").append(ay);
		System.out.println(sb);
	}
}
