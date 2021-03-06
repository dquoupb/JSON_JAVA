package b_DataStructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// print 입력하면 이름순 오름차순으로 출력하기
// 과목 명을 입력하면 해당 과목 성적순(내림차순)으로 출려하되, 성적이 동일할 경우에는 이름 오름차순
public class test {
	public static void main(String[] args) throws IOException {
		String line = null;
		ArrayList<Grade> list = new ArrayList<>();

		try {
			FileReader fr = new FileReader("./List_sample.txt");
			BufferedReader bf = new BufferedReader(fr);

			while ((line = bf.readLine()) != null) {
				String words[] = line.split("\t");
				Grade g = new Grade(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]),
						Integer.parseInt(words[3]));
				list.add(g);
			}

			bf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String strInput = br.readLine();

			switch (strInput) {
			case "PRINT": // 이름 순 출력
				Collections.sort(list, (g1, g2) -> g1.getName().compareTo(g2.getName()));
				break;
			case "KOREAN": // 국어 성적 순 출력
				// Lambda식
				Collections.sort(list,
						(g1, g2) -> (g2.getKorean() - g1.getKorean()) == 0 ? g1.getName().compareTo(g2.getName())
								: g2.getKorean() - g1.getKorean());
				break;
			case "ENGLISH": // 영어 성적 순 출력
				// Comparator				
				Collections.sort(list, new Comparator<Grade>() {

					@Override
					public int compare(Grade x, Grade y) {
						if (y.getEnglish() - x.getEnglish() == 0) {
							return x.getName().compareTo(y.getName());
						} else {
							return y.getEnglish() - x.getEnglish();
						}
					}

				});
				break;
			case "MATH":
				// Comparator
				Collections.sort(list, new sortByMath());
				break;
			case "QUIT":
				return;
			default:
				break;
			}

			for (Grade val : list) {
				System.out.println(String.format("%s\t%d\t%d\t%d", val.getName(), val.getKorean(), val.getEnglish(),
						val.getMath()));
			}

		}

	}

}

class sortByMath implements Comparator<Grade>{
	public int compare(Grade x, Grade y) {
		if(y.getMath() - x.getMath() == 0) {
			return x.getName().compareTo(y.getName());
		} else {
			return y.getMath() - x.getMath();
		}
	}
}

class Grade {
	private String name;
	private int korean;
	private int english;
	private int math;

	public Grade(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String strName) {
		this.name = strName;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
}
