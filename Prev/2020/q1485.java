import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class q1485 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		// 문제 풀이 참조 --> https://github.com/jokerKwu/BOJ_Algorithm/blob/master/ccw/BOJ_1485.cpp
		int testcase;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		int x[] = new int[4];
		int y[] = new int[4];
		int d[] = new int[6];
		
		while(testcase-- > 0) {
			HashMap<Integer, Integer> m = new HashMap<>();
			StringTokenizer st;
			int k = 0;
	
			for(int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				x[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			// 각 점들마다 이동할 수 있는 좌표간 거리를 모두 구함
			for(int i = 0; i < 4; i++) {
				for(int j = i+1; j < 4; j++) {
					// System.out.println(i + ", " + j + " => " + x[i] + "&" + y[i] + x[j] + "&" + y[j]);
					d[k] = (x[i] - x[j]) * (x[i]-x[j]) + (y[i] - y[j])*(y[i] - y[j]);
					// System.out.println(d[k]);
					k++;
				}
			}
			Arrays.sort(d); // 오름차순 정렬
			if(d[0] == d[1] && d[1] == d[2] && d[2] == d[3] && d[4] == d[5]) // 정렬 시 앞에 4개는 사각형의 길이, 2개는 대각선의 길이(대각성이 다르면 마름모)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
