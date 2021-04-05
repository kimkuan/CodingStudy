import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q5622 {

	public static void main(String[] args) throws IOException {
		/*
		 ABC : 2
		 DEF : 3
		 GHI : 4
		 JKL : 5
		 MNO : 6
		 PQRS : 7
		 TUV : 8
		 WXYZ : 9	 
		 */
		int[] alpha = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9}; 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		
		int answer = 0;
		int len = sb.toString().length();
		
		for(int i = 0; i < len; i++) {
			answer += alpha[sb.charAt(i) - 'A'] + 1;
		}
		System.out.print(answer);
	}
}
