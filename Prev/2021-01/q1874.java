import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* [S3] ���ü���   */

public class q1874 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		boolean flag = false;
		int num = 1;

		for(int i = 1; i <= n ; i++) {
			int k = Integer.parseInt(br.readLine()); // ���� ��
			
			while(true) {
				if(k >= num) { 
					stack.push(num);
					sb.append("+\n");
					num++; // stack�� num�� ���� ������ ���� 
				}
				else if(k <= num) {
					if(!stack.isEmpty() && stack.peek() == k) { // ���� num���� ���� ���� stack�� ����
						stack.pop();
						sb.append("-\n");					
					}
					else // ������ ����ְų� ������ �Ұ����� ��
						flag = true;
					break; // ���� k������ �Ѿ 
				}
			}// while��
			
			if(flag) { // �Ұ����� �����̸�
				sb.setLength(0); // sb �ʱ�ȭ
				sb.append("NO\n");
				break;
			}
		}// for��
		System.out.println(sb);
	}
}
