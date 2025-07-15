package y2021.mon09.day04.prog_표편집;

import java.util.Stack;

public class prog_표편집 {

	static int n = 8; // �迭�� ����
	static int k = 2; // ���� ��ġ
	static String[] cmd = {"D 110","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
	
	public static void main(String[] args) {
		Stack<Integer> removeList = new Stack<>();
		
		int index = k;
		int size = n;
		
		for (int i = 0; i < cmd.length; i++) {
			String[] command = cmd[i].split(" ");
			char direction = command[0].charAt(0);
			
			switch (direction) {
			case 'U':
				int upCount = Integer.parseInt(command[1]);
				System.out.println(upCount);
				index = index-upCount < 0 ? 0 : index-upCount;
				break;
			case 'D':
				int downCount = Integer.parseInt(command[1]);
				System.out.println(downCount);
				index = index+downCount >= n ? n-1 : index+downCount;
				break;
			case 'C':
				size--;
				removeList.add(index);
				index = size <= index ? index-1 : index;
				break;
			case 'Z':
				size++;
				int remove = removeList.pop();
				// ���� �����ϴ� ���� ���� �ε������� ������ index+1
				index = remove <= index ? index+1 : index;
				break;

			default:
				break;
			}
			
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			sb.append("O");
		}
		
		while(!removeList.isEmpty()) {
			sb.insert(removeList.pop(), "X");
		}
		
		System.out.println(sb.toString());
	}

}
