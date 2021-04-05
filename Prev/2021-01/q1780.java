import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* [S2] ������ ���� - 1780�� */

public class q1780 {
   static int[][] arr;
   static int[] ans = new int[3];
   
   static boolean isSame(int x, int y, int n) { 
      for(int i = x; i < x+n; i++) {
         for(int j = y; j < y+n; j++) {
            if(arr[i][j] != arr[x][y]) // �� ���̿� ���� �ٸ� ���� ������
               return false;
         }
      }
      return true;
   }
   
   static void onePaper(int x, int y, int n) {
      int now = arr[x][y];
      
      if(n > 1 && !isSame(x, y, n)) { // n�� 1���� ũ�� ���� �ٸ� ���� ���� ��
         int k = n/3;

         for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
               onePaper(x + k*i, y + k*j, k);
            }
         }
      }
      else { // �ڸ��� �ʾƵ� �Ǵ� ��� --> n = 1�� �� or ��� ���� ���� ��
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
            // �ƿ� arr[i][j]�� +1 �� ���·� �����ϸ� 
            // -1 0 1�� �ƴ϶� 0 1 2�� ����Ǿ ans[arr[i][j]]++; �̷��� ������ų �� ���� ����
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
 * nxn�� ��� ���� �����̸� --> �ϳ��� ����
 * �ƴϸ� --> n%3���� ����� Ȯ��
 */
