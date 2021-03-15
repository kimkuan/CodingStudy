import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [S2] 종이의 개수 - 1780번 */

public class q1780 {
   static int[][] arr;
   static int[] ans = new int[3];
   
   static boolean isSame(int x, int y, int n) { 
      for(int i = x; i < x+n; i++) {
         for(int j = y; j < y+n; j++) {
            if(arr[i][j] != arr[x][y]) // 한 종이에 서로 다른 수가 있으면
               return false;
         }
      }
      return true;
   }
   
   static void onePaper(int x, int y, int n) {
      int now = arr[x][y];
      
      if(n > 1 && !isSame(x, y, n)) { // n이 1보다 크고 서로 다른 수가 있을 때
         int k = n/3;

         for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               onePaper(x + k*i, y + k*j, k);
            }
         }
      }
      else { // 자르지 않아도 되는 경우 --> n = 1일 때 or 모든 수가 같을 때
         if(now == -1)
            ans[0]++;
         else if(now == 0)
            ans[1]++;
         else
            ans[2]++;
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      arr = new int[n][n];
      
      for(int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         for(int j = 0; j < n; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
            // 아예 arr[i][j]에 +1 한 상태로 저장하면 
            // -1 0 1이 아니라 0 1 2로 저장되어서 ans[arr[i][j]]++; 이렇게 증가시킬 수 있음 ㄷㄷ
         }
      }
      
      onePaper(0, 0, n);
      
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < 3; i++)
         sb.append(ans[i]).append('\n');
   
      System.out.println(sb);
   }
}

/*
 * nxn이 모두 같은 숫자이면 --> 하나의 종이
 * 아니면 --> n%3으로 나누어서 확인
 */
