package mon07.day18.boj_연료채우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_연료채우기 {

	static int N; // 주유소의 개수
	static Station[] stations; // 주유소 정보
	
	static class Station implements Comparable<Station>{
		int location;
		int gas;
		
		public Station(int location, int gas) {
			this.location = location;
			this.gas = gas;
		}

		@Override
		public int compareTo(Station o) {
			return Integer.compare(this.location, o.location); // 위치 오름차순
		}

		@Override
		public String toString() {
			return "Station [location=" + location + ", gas=" + gas + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		stations = new Station[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stations[i] = new Station(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(stations); // 거리순으로 정렬
		
		st = new StringTokenizer(br.readLine());
		int dest = Integer.parseInt(st.nextToken()); // 도착지까지의 거리
		int gas = Integer.parseInt(st.nextToken()); // 현재 남아있는 연료의 양
		
		System.out.println(visiteToStation(dest, gas));
	}
	
	private static int visiteToStation(int dest, int gas) {
		// 이전에 지나갔던 주유소의 연료의 양 저장
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((Integer o1, Integer o2) -> {return Integer.compare(o2, o1);});
		int visitedCount = 0;
		int currentLocation = 0; // 성경이의 현재 위치
		
		for(int i = 0; i < N; i++) {
			// 다음 주유소까지 거리
			int distance = stations[i].location - currentLocation;
			if(gas - distance < 0) { // 현재의 연료로 다음 주유소에 도착할 수 없다면 이전 주유소를 들리기
				while(gas < distance) {
					if(q.isEmpty())  // 이전 주유소에서도 연료를 얻을 수 없음.
						return -1;
					gas += q.poll(); // 가장 많이 연료를 얻을 수 있는 주유소에 들리자 (최소횟수)
					visitedCount++; // 주유소 들린 횟수 증가
				}
			}
			q.add(stations[i].gas); // 현재 주유소의 연료를 q에 저장
			
			currentLocation += distance;
			gas -= distance; // 1KM당 1L씩  연료 없어짐
		}
		
		int distance = dest - currentLocation;
		if(gas - distance < 0) {
			while(gas < distance) {
				if(q.isEmpty())  // 이전 주유소에서도 연료를 얻을 수 없음.
					return -1;
				gas += q.poll(); // 가장 많이 연료를 얻을 수 있는 주유소에 들리자 (최소횟수)
				visitedCount++; // 주유소 들린 횟수 증가
			}
		}
		
		return visitedCount;
	}
}
