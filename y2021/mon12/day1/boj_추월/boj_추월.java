package y2021.mon12.day1.boj_추월;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj_추월 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> inputInfo, outputInfo;
		String[] inputCars, outCars;
		int N, result=0;
		
		N = Integer.parseInt(br.readLine()); 				// �ͳο� �� �ڵ����� ��
		inputInfo = new HashMap<String, Integer>(); 		// �ͳο� �� �ڵ��� ��ȣ�� ������ ����
		outputInfo = new HashMap<String, Integer>();		// �ͳο��� ���� �ڵ��� ��ȣ�� ������ ����
		inputCars = new String[N];							// �ͳο��� �� �ڵ����� ��ȣ�� ������� ����
		outCars = new String[N];							// �ͳο��� ���� �ڵ����� ��ȣ�� ������� ����
		
		// �ͳο� �� ������� ����
		for(int i = 0; i < N; i++) {
			String carNumber = br.readLine();
			inputCars[i] = carNumber;
			inputInfo.put(carNumber, i+1); // 1���� ����
		}
		
		// �ͳ��� ���� ������� ����
		for (int i = 0; i < N; i++) {
			String carNumber = br.readLine(); 		
			outCars[i] = carNumber;
			outputInfo.put(carNumber, i+1); // 1���� ����
		}
		
		// �ͳ��� ���� ������� �� (�� �� X���� ���� �տ� �־��� �������� �״�� �տ� �־�� �Ѵ�)
		for (int i = 0; i < N; i++) {
			int turn = inputInfo.get(outCars[i]);  // ���� ������ �� ����
						
			for(int j = 0; j < turn; j++) {
				int current = outputInfo.get(outCars[i]); // ���� ������ ���� ����
				int prev = outputInfo.get(inputCars[j]);  // ���� ������ ���;��ϴ� ������ �ȳ������� �߿��� ��
				
				if(prev > current) {
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

} 
