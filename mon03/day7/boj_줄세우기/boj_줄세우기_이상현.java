package mon03.day7.boj_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_줄세우기_이상현 {

	static LinkedList<Integer> line = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(num > 0) 
				line.add(i - num, i+1);
			else
				line.add(i, i+1);
		}
		print();
	}
	
	private static void print() {
		StringBuilder sb = new StringBuilder();
		for(int x : line) {
			sb.append(x + " ");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}
}
