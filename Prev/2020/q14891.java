import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Rotation{
	int num;
	int dir;
	String value; // �� �������θ� ������ ����
	
	public Rotation(int num, int dir, String value) {
		this.num = num;
		this.dir = dir;
		this.value = value; // "Both", "Left", "Right"
	}
}

public class q14891 {
	static int[][] gear;
	static int[] twelve;
	
	static void turn(int num, int dir) {
		if(dir == 1) // �ð����
			twelve[num-1] = (twelve[num-1] - 1) == -1 ? 7 : twelve[num-1] - 1;
		else // �ݽð����
			twelve[num-1] = (twelve[num-1] + 1) == 8 ? 0 : twelve[num-1] + 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gear = new int[4][8];
		twelve = new int[4]; // �� ��Ϲ����� 12�ø� ����Ű�� index
		int rotation, answer = 0;
		
		for(int i = 0; i < 4; i++) {
			String str = br.readLine();
			for(int j = 0; j < 8; j++) {
				gear[i][j] = str.charAt(j) - '0';
			}
		}
		
		rotation = Integer.parseInt(br.readLine());
		
		while(rotation-- > 0) {
			String[] tmp = br.readLine().split(" ");
			int num = Integer.parseInt(tmp[0]);
			int dir = Integer.parseInt(tmp[1]);
			
			Queue<Rotation> q = new LinkedList<>();
			
			q.add(new Rotation(num, dir, "Both"));
				
			while(!q.isEmpty()) {	
				Rotation now = q.poll();				
				num = now.num; // 1 ~ 4�� �� �ϳ�
				dir = now.dir; 
				String value = now.value;
				
				int before = twelve[num-1]; // ȸ����Ű�� ���� ��
				int left = num - 1;
				int right = num + 1;
				
				System.out.println("num : " + num + " dir : " + dir);	
				// ���� ��Ϲ����� �´��� ���� ���� �ٸ���, ������ üũ

				for(int i = 0; i < 4; i++) {
					System.out.println("twelve[" + (i+1) + "] : " + twelve[i]);
				}
				
				turn(num, dir);
				
				if(left > 0 && left <= 4) {
					int tmp1 = (before + 6) % 8; // ���� ���� ��Ϲ���  ��
					int tmp2 = (twelve[left-1] + 2) % 8; // ���ʿ� �ش��ϴ� ��Ϲ���
					
					//System.out.println("gear[" + num + "][" + tmp1 + "] : "+ gear[num-1][tmp1] + " gear[" + left + "][" + tmp2 + "] : " + gear[left-1][tmp2]);

					if(gear[num-1][tmp1] != gear[left-1][tmp2] && (value == "Both" || value == "Left")) { //�ٸ���
						q.add(new Rotation(left, dir*(-1), "Left"));
					}// �ݴ� �������� ȸ��
				}
				
				if(right > 0 && right <= 4) {
					int tmp1 = (before + 2) % 8; 
					int tmp2 = (twelve[right-1] + 6) % 8;
					
					//System.out.println("gear[" + num + "][" + tmp1 + "] : " + gear[num-1][tmp1] + " gear[" + right + "][" + tmp2 + "] : " + gear[right-1][tmp2]);

					if(gear[num-1][tmp1] != gear[right-1][tmp2] && (value == "Both" || value == "Right")) { //�ٸ���
						q.add(new Rotation(right, dir*(-1), "Right"));
					}// �ݴ� �������� ȸ��
				}
			}
		}
		
		// N��(0) : 0��, S��(1) : 2^(��ȣ-1)
		for(int i = 0; i < 4; i++) {
			if(gear[i][twelve[i]] == 1)
				answer += Math.pow(2, i);
		}
		
		System.out.println(answer);
	}
}