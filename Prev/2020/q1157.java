import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1157 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int alpha[] = new int[26];
		int maxIdx = -1, max = -1;
		Arrays.fill(alpha, 0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		str = str.toUpperCase(); // 대문자로 변환
		
		for(int i=0; i<str.length(); i++) 
			alpha[str.charAt(i) - 'A']++;
		
		for(int i=0; i<alpha.length; i++) {
			if(alpha[i] > max) {
				max = alpha[i];
				maxIdx = i;
			}
		}
		sb.append((char)(maxIdx + 'A'));
		
		for(int i=0; i<alpha.length; i++) {
			if(max == alpha[i] && maxIdx != i) {
				sb.setLength(0);
				sb.append("?");
				break;
			}
		}
		
		System.out.print(sb.toString());
	}
}
