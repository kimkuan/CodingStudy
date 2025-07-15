package mon12.day1.boj_추월;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj_추월 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> inputInfo, outputInfo;
		String[] inputCars, outCars;
		int N, result=0;
		
		N = Integer.parseInt(br.readLine()); 				// 터널에 들어간 자동차의 수
		inputInfo = new HashMap<String, Integer>(); 		// 터널에 들어간 자동차 번호와 순서를 저장
		outputInfo = new HashMap<String, Integer>();		// 터널에서 나온 자동차 번호와 순서를 저장
		inputCars = new String[N];							// 터널에서 들어간 자동차의 번호를 순서대로 저장
		outCars = new String[N];							// 터널에서 나온 자동차의 번호를 순서대로 저장
		
		// 터널에 들어간 순서대로 저장
		for(int i = 0; i < N; i++) {
			String carNumber = br.readLine();
			inputCars[i] = carNumber;
			inputInfo.put(carNumber, i+1); // 1부터 시작
		}
		
		// 터널을 나온 순서대로 저장
		for (int i = 0; i < N; i++) {
			String carNumber = br.readLine(); 		
			outCars[i] = carNumber;
			outputInfo.put(carNumber, i+1); // 1부터 시작
		}
		
		// 터널을 나온 순서대로 비교 (들어갈 때 X차량 보다 앞에 있었던 차량들은 그대로 앞에 있어야 한다)
		for (int i = 0; i < N; i++) {
			int turn = inputInfo.get(outCars[i]);  // 현재 차량이 들어간 순서
						
			for(int j = 0; j < turn; j++) {
				int current = outputInfo.get(outCars[i]); // 현재 차량이 나온 순서
				int prev = outputInfo.get(inputCars[j]);  // 원래 이전에 나와야하는 차량이 안나왔으면 추월한 것
				
				if(prev > current) {
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
	}

} 
