package y2021.mon08.day01.prog_오픈채팅방;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class prog_오픈채팅방 {

	
	static String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
	static ArrayDeque<Log> logs = new ArrayDeque<Log>();	
	static HashMap<String, String> userMap = new HashMap<>(); // ������ ���̵�� �г����� �����ϱ� ���� ��
	
	static class Log {
		String act;
		String uid;
		public Log(String act, String uid) {
			this.act = act;
			this.uid = uid;
		}
	}
	
	public static void main(String[] args) {
		
		StringTokenizer st = null;
		for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			String act = st.nextToken();
			String uid = st.nextToken();
			
			if(act.equals("Enter")) {
				String nickname = st.nextToken();
				userMap.put(uid, nickname);
				logs.add(new Log(act, uid));
			}else if(act.equals("Change")) {
				String nickname = st.nextToken();
				userMap.put(uid, nickname);
			}else {
				logs.add(new Log(act, uid));
			}
		}
		System.out.println(makeResult());
	}
	
	private static String[] makeResult() {
		StringBuilder sb = new StringBuilder();
		String[] result = new String[logs.size()];
		
		int idx = 0;
		while(!logs.isEmpty()) {
			Log log = logs.poll();
			sb.append(userMap.get(log.uid) + "���� ");
			
			if(log.act.equals("Enter"))
				sb.append("���Խ��ϴ�.");
			else if(log.act.equals("Leave"))
				sb.append("�������ϴ�.");
			sb.append("\n");
			
			result[idx++] = sb.toString();
			sb.setLength(0);
		}
		return result;
	}
}
