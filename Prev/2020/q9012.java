import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {
			Stack<Character> st = new Stack<>();
			String str = br.readLine();
			String ans = "YES";
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == ')') {
					if(st.empty()) { // ������ ����ִµ� pop �õ� --> �Ұ���
						ans = "NO";
						break;
					}
					else 
						st.pop(); // '('�� ¦�� ����	
				}
				else
					st.push(str.charAt(i));
			}
			
			if(!st.empty()) // ���� ��ȣ�� ������ --> �Ұ���
				ans = "NO";
			
			System.out.println(ans);
		}
	}
}
