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
					if(st.empty()) { // 스택이 비어있는데 pop 시도 --> 불가능
						ans = "NO";
						break;
					}
					else 
						st.pop(); // '('와 짝이 맞음	
				}
				else
					st.push(str.charAt(i));
			}
			
			if(!st.empty()) // 남은 괄호가 있으면 --> 불가능
				ans = "NO";
			
			System.out.println(ans);
		}
	}
}
