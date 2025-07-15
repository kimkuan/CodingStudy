package mon10.day31.boj_서로다른부분문자열의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class boj_서로다른부분문자열의개수 {

	static HashSet<String> set = new HashSet<String>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		
		for(int i = 0; i <= len; i++) {
			for (int j = i+1; j <= len; j++) {
				String subString = str.substring(i, j);
				set.add(subString);
			}
		}
		System.out.println(set.size());
	}

}
