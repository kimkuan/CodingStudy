import java.util.Arrays;
import java.util.Scanner;

public class q10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[26];
		Arrays.fill(arr, -1); // arr�迭�� -1�� �ʱ�ȭ
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(arr[c - 'a'] == -1) {
				int idx = str.indexOf(c);
				arr[c - 'a'] = idx;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
