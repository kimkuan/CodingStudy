import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q2485 {
	
	static int gcd(int a, int b) {
		return (b > 0) ? gcd(b, a%b) : a;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n; // �̹� �ɾ����ִ� ���μ��� ��
		n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int gap[] = new int[n-1];
		int min = 100000000;
		int ans = 0; // �ɾ���� ���μ�
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // �������� 
		for(int i = 0; i < n-1; i++) {
			gap[i] = arr[i+1] - arr[i]; // �Ÿ����� ���� 
		}
		for(int i = 0; i < n-2; i++) {
			int temp = gcd(gap[i], gap[i+1]);	
			if(min > temp) min = temp;
		}
		
		for(int i = 0; i < n-1; i++) {
			ans += gap[i] / min - 1;  // �ɾ���� ���μ� ���� ī��Ʈ
		}		 
		System.out.print(ans);
	}

}
