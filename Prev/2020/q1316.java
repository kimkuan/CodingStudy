import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1316 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean alpha[] = new boolean[26];
		int answer = Integer.parseInt(br.readLine());	
		char c;
		
		for(int j=answer; j>0; j--){
			Arrays.fill(alpha, false);
			String sb = br.readLine();
			
			for(int i=0; i < sb.length(); i++) {
				c = sb.charAt(i);
				if(alpha[c -'a'] == true && sb.charAt(i-1) != c) {
					answer--;
					break;		
				}
				else
					alpha[c -'a'] = true;
			}
		}
		System.out.println(answer);
	}
}
