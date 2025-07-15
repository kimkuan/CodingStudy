package y2021.mon08.day15.prog_조이스틱;

public class prog_조이스틱 {
	
	static String name = "JEROEN";
	public static void main(String[] args) {
		
		int moveCount = 0;
		char[] str = name.toCharArray();
		moveCount += (str[0] - 'A');
		str[0] = 'A';

		// �̵��� ���� -> ���� �ּ������� �̵��� �� �ִ°�, �� �������� �޸���
		int rightIndex = 0;
		for(int i = 0; i < name.length(); i++) {
			rightIndex++;
			if(str[i+1] != 'A')
				break;
		}
		
		int leftIndex = 0;
		for(int i = name.length()-1; i >= 0; i--) {
			leftIndex++;
			if(str[i] != 'A')
				break;
		}
		
		// ���������� ���°� Ƚ���� �� ������
		if(rightIndex < leftIndex) {
			moveCount += rightIndex;
			for(int i = 1; i < name.length(); i++) {
				moveCount += minMatch(str[i]);
				str[i] = 'A';
				if(!isRemain(str))
					break;
				moveCount++; // �������� �̵�
			}
		}
		else {
			moveCount += leftIndex;
			for(int i = name.length()-1; i > 0; i--) {
				moveCount += minMatch(str[i]);
				str[i] = 'A';
				if(!isRemain(str))
					break;
				moveCount++; // �������� �̵�
			}
		}
		System.out.println(moveCount);
	}
	private static int minMatch(char c) {
		return Math.min(c - 'A', 'Z' - c + 1);
	}
	
	private static boolean isRemain(char[] str) {
		for(int i = 0; i < str.length; i++) {
			if(str[i] != 'A')
				return true;
		}
		return false;
	}
}
