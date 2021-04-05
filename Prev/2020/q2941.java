import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class q2941 {
	public static void main(String[] args) throws IOException {
		
		String[] croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		for(int i = 0; i < croa.length; i++) 
			str = str.replaceAll(croa[i], "*"); // c=c= --> ** 
		
		System.out.println(str.length());
	}
}
