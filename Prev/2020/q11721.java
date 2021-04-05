import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		for(int i = 0; i < len;) {
			if((len - i) / 10 > 0)
				System.out.println(str.substring(i, i+10));
			else
				System.out.println(str.substring(i, i+(len - i)%10));
			i += 10;
		}
	}
}