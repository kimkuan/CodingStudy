import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* [S2] â�� �ٰ��� - 2304�� */

public class q2304_ans {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] heights = new int[1001];

		int lastIndex = 0; // ������ index
		int maxIndex = 0 ; // ���� ū ������ index
		

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			heights[L] = H; // �ش� ��ġ�� ���� ����
			
			if(lastIndex < L) 
				lastIndex = L;
			
			if(heights[maxIndex] < H) // H�� ���� ���� ū ���̺��� ũ��
				maxIndex = L;
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(0); // ���� ���̴� 0
		
		int answer = heights[maxIndex]; // �ִ� ����
		
		for(int i = 0; i < maxIndex; i++) { // ��ġ : 0 ~ maxIndex����
			if(s.peek() < heights[i]) // ���� ���� �� ū ���̰� ������
				s.push(heights[i]);
			
			answer += s.peek(); // ������ �� ���� �� ���ϱ�
		}
		
		s.clear();
		s.push(0);
		
		for(int i = lastIndex; i > maxIndex; i--) { // ��ġ : lastIndex ~ maxIndex����
			if(s.peek() < heights[i])
				s.push(heights[i]);
			
			answer += s.peek();
		}
		System.out.println(answer);
	}
}
