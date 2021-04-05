import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		char[] str;
		
		while(tc-- > 0) {
			str = br.readLine().toCharArray();
			int score = 0;
			int total = 0;

			for(int i = 0; i < str.length; i++) {
				if(str[i] == 'O') {
					score++;
					total += score;
				}
				else
					score = 0;
			}
			
			System.out.println(total);
		}
	}
}
