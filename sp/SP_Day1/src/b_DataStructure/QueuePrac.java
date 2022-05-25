package b_DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class QueuePrac {
	static HashMap<String, MsgQueue> queues;

	public static void main(String[] args) throws Exception {
		queues = new HashMap<String, MsgQueue>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = bf.readLine();
			String[] words = line.split(" ");
			String command = words[0];
			String qname = words[1];
			switch (command) {
			case "CREATE":
				System.out.println(QCreate(qname, Integer.parseInt(words[2])));
				break;
			case "ENQUEUE":
				break;
			case "DEQUEUE":
				break;
			case "GET":
				break;
			case "SET":
				break;
			case "DEL":
				break;
			default:
				break;
			}
		}
	}

	static String QCreate(String name, int size) {
		if (queues.containsKey(name))
			return "Queue Exist";

		MsgQueue q = new MsgQueue(size);

		queues.put(name, q);

		return "Queue Created";
	}

	static String QEnqueue(String name, String msg) {
		return queues.get(name).MsgEnqueue(msg);
	}

	static String QDequeue(String name) {
		return queues.get(name).MsgDequeue();
	}

	static String QGet(String name) {
		return queues.get(name).MsgGet();
	}

	static String QSet(String name, int id) {
		return queues.get(name).MsgSet(id);
	}

	static String QDel(String name, int id) {
		return queues.get(name).MsgDel(id);
	}
}
