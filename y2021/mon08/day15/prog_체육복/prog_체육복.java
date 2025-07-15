package y2021.mon08.day15.prog_체육복;

public class prog_체육복 {

	static int n = 3;
	static int[] lost = {3};
	static int[] reserve = {1};
	public static void main(String[] args) {

		int[] student = new int[n+2]; // 1: ������ ����, -1: ���� ����
		
		// 1. ������ ������� �л��� ������ ���ߴ� �� üũ
		for (int i = 0; i < lost.length ; i++)   
			student[lost[i]] += -1;
		
		for (int i = 0; i < reserve.length ; i++) 
			student[reserve[i]] += 1;

		
		// 2. 1���Ը� ���� �� �ִ� �л��鿡�� ���� ������
		for (int i = 1; i <= n; i++) {
			if(student[i] == -1) { // ���� ���� �л��̰� 
				if(student[i-1] * student[i+1] == 1) continue;
				
				if(student[i-1] == 1 && student[i+1] < 1){ // �� �л��� ������ �� ������
					student[i] += 1;
					student[i-1] -= 1;
				}
				else if(student[i-1] < 1 && student[i+1] == 1) { // �� �л��� ������ �� ������
					student[i] += 1;
					student[i+1] -= 1;
				}
			}
		}

		// 3. �� ����, 2���� ���� �� �ִ� �л��鿡�� ������
		for (int i = 1; i <= n; i++) {
			if(student[i] == -1) { // ���� ���� �л��̰� 
				if(student[i-1] == 1){ // �� �л��� ������ �� ������
					student[i] += 1;
					student[i-1] -= 1;
				}
				else if(student[i+1] == 1) { // �� �л��� ������ �� ������
					student[i] += 1;
					student[i+1] -= 1;
				}
			}
		}
		
		int answer = 0;
		for(int i = 1 ; i <= n; i++) {
			if(student[i] >= 0) answer++;
		}
		System.out.println(answer);
	}
}
