import java.util.Scanner;
 
/* [S1] ������ �� - 11057�� */


public class q11057_ans {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int n = sc.nextInt();
        int mod = 10007;
         
        int dp[][] = new int[n+1][10];
             
        //�켱 �ʱ�ȭ����� ��
        //1�ڸ��� �ΰ�� �� ���ڰ� �� ����� �� ����
        for(int i=0; i<10; i++) dp[1][i] = 1;
     
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k]; //�ñ׸��� += ���� ��ü�� �� ����.
                    dp[i][j] %= mod;
                }
            }
             
        }
         
        int ans = 0;
        for(int i=0; i<=9; i++){
            ans += dp[n][i];   
            System.out.println(dp[n][i]);  
        }
         
        System.out.println(ans%=mod);
    }
 
}