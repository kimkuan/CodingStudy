import java.util.Scanner;
 
/* [S1] 오르막 수 - 11057번 */


public class q11057_ans {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int n = sc.nextInt();
        int mod = 10007;
         
        int dp[][] = new int[n+1][10];
             
        //우선 초기화해줘야 함
        //1자리수 인경우 각 숫자가 들어갈 경우의 수 저장
        for(int i=0; i<10; i++) dp[1][i] = 1;
     
        for(int i=2; i<=n; i++){
            for(int j=0; j<=9; j++){
                for(int k=0; k<=j; k++){
                    dp[i][j] += dp[i-1][k]; //시그마는 += 으로 대체될 수 있음.
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