import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* [S2] 창고 다각형 - 2304번 */

public class q2304_ans {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] heights = new int[1001];

		int lastIndex = 0; // 마지막 index
		int maxIndex = 0 ; // 가장 큰 높이의 index
		

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			heights[L] = H; // 해당 위치의 높이 저장
			
			if(lastIndex < L) 
				lastIndex = L;
			
			if(heights[maxIndex] < H) // H가 현재 가장 큰 높이보다 크면
				maxIndex = L;
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(0); // 최초 높이는 0
		
		int answer = heights[maxIndex]; // 최대 높이
		
		for(int i = 0; i < maxIndex; i++) { // 위치 : 0 ~ maxIndex까지
			if(s.peek() < heights[i]) // 현재 보다 더 큰 높이가 나오면
				s.push(heights[i]);
			
			answer += s.peek(); // 스택의 맨 위의 값 더하기
		}
		
		s.clear();
		s.push(0);
		
		for(int i = lastIndex; i > maxIndex; i--) { // 위치 : lastIndex ~ maxIndex까지
			if(s.peek() < heights[i])
				s.push(heights[i]);
			
			answer += s.peek();
		}
		System.out.println(answer);
	}
}
