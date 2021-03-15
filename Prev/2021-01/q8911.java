import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* [S2] 거북이 - 8911번 */

public class q8911 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서
		int[] dy = {-1, 0, 1, 0};
		
		while(tc-- > 0) {
			String str = br.readLine();
			int minX = 0, maxX = 0;// 거북이가 움직인 x 배열
			int minY = 0, maxY = 0;// 거북이가 움직인 y 배열
			int x = 0, y = 0, dir = 0;

			for(int i = 0; i < str.length(); i++) {
				char cmd = str.charAt(i);
				
				if(cmd == 'F') {
					x = dx[dir%4] + x;
					y = dy[dir%4] + y;
				}
				else if(cmd == 'B') {
					x = dx[(dir+2)%4] + x;
					y = dy[(dir+2)%4] + y;
				}
				else if(cmd == 'R')
					dir++;
				else if(cmd == 'L') {
					dir--;
					if(dir < 0)
						dir += 4;
				}
				
                if (maxX < x)
                    maxX = x;
                if (maxY < y)
                    maxY = y;
                if (minX > x)
                    minX = x;
                if (minY > y)
                    minY = y;
                
				/*
				if(cmd == 'F' || cmd == 'B') {
					if(dir == 0 && cmd == 'F' || dir == 180 && cmd == 'B')
						y++;
					else if(dir == 0 && cmd == 'B' || dir == 180 && cmd == 'F')
						y--;
					else if(dir == 90 && cmd == 'F' || dir == 270 && cmd == 'B')
						x++;
					else if(dir == 270 && cmd == 'F' || dir == 90  && cmd == 'B')
						x--;
				}
				else if(cmd == 'L')
					dir = (dir + 270) % 360;
				else
					dir = (dir + 90) % 360;
				
				
				if(x < 0)
					minX = minX > x ? x : minX;
				else
					maxX = maxX < x ? x : maxX;
				if(y < 0)
					minY = minY > y ? y : minY;
				else
					maxY = maxY < y ? y : maxY;
				*/
			}		
			// 넓이 구하기
			if((minX == 0 && maxX == 0) || (minY == 0 && maxY == 0))  // 선분으로 표현될 때
				System.out.print(0);
			else 
				System.out.println((maxX - minX) * (maxY - minY));
		}
	}
}
