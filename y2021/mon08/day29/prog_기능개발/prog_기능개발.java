package y2021.mon08.day29.prog_기능개발;

import java.util.ArrayList;
import java.util.Arrays;

public class prog_기능개발 {

	static int[] progresses = {1, 1, 1, 1};
	static int[] speeds = {100, 100, 100, 100};
	
	public static void main(String[] args) {
		ArrayList<Integer> result = new ArrayList<>();
		int[] day = new int[progresses.length];
		
		for (int i = 0; i < day.length; i++) {
			int restDay = ((100 - progresses[i]) % speeds[i]) > 0 ? 1 : 0; // ������ �������� �ʴ� ��쿡�� +1�� �� �ʿ�
			day[i] = (100 - progresses[i]) / speeds[i];
			day[i] += restDay;
		}
		System.out.println(Arrays.toString(day));
	
		int prevDay = day[0]; // ���� �۾��� �����µ� �ɸ��� �ϼ�
		int count = 1; // �̹� ������ ���� �� �ִ� �۾��� ����
		for (int i = 1; i < day.length; i++) {
			if(prevDay < day[i]) { // ���������� ���� �� �����ɸ��� �۾��̶�� ���� �������� �̷���
				result.add(count); // �̹� ������ �׷� ���⼭ ��!
				prevDay = day[i];
				count = 1;
			}
			else {
				count++;
			}
		}
		result.add(count); // �������� for������ add���� �ʾ����Ƿ� ���� �־���
		
		int[] answer = new int[result.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
		
		System.out.println(result);
	}

}
