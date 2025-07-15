package y2021.mon07.day13.boj_퍼즐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_퍼즐 {
	
	static int N = 3;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
	
	static class Info {
		int index; // ���� ��ĭ(0)�� ��ġ
		int cnt; // ó�� ������� ���� ������� �̵� Ƚ��
		StringBuilder str;
		
		public Info(int index, int cnt, StringBuilder str) {
			this.index = index;
			this.cnt = cnt;
			this.str = str;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sb.append(st.nextToken());
			}
		}
		
		int startIndex = sb.indexOf("0");
		tryMoving(startIndex, sb);
		System.out.println((visited.containsKey(123456780) == true) ? visited.get(123456780) : -1);
	}
	
	private static void tryMoving(int index, StringBuilder str) {
		ArrayDeque<Info> q = new ArrayDeque<>();
		q.add(new Info(index, 0, str));
		visited.put(stoi(str.toString()), 0);
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			int x = info.index/3;
			int y = info.index%3;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				
				int nextIndex = nx*3 + ny;
	
				// if(nextIndex < 0 || nextIndex > 8) continue;
				
				// swap
				StringBuilder temp = new StringBuilder(info.str);
				char to = temp.charAt(nextIndex);
				temp.setCharAt(nextIndex, '0');
				temp.setCharAt(info.index, to);
				
				// �湮���� check
				int num = stoi(temp.toString());
				if(visited.containsKey(num)) continue; // �̹� �湮�� �迭�� ��쿡�� Pass
				q.add(new Info(nextIndex, info.cnt+1, temp));
				visited.put(num, info.cnt+1);
			}
		}
	}
	
	private static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
