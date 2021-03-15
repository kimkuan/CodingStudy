import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb;
		
		String num1 = st.nextToken();
		String num2 = st.nextToken();
		String answer = "";
	
		for(int i = 2; i >= 0; i--) {
			if(num1.charAt(i) > num2.charAt(i)) {
				sb = new StringBuilder(num1);
				answer = sb.reverse().toString();
				break;
			}
			else if(num1.charAt(i) < num2.charAt(i)) {
				sb = new StringBuilder(num2);
				answer = sb.reverse().toString();
				break;
			}
		}	
		System.out.print(answer);
	}
}
