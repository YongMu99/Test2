package hw4_2;

//***************************
//파일명: MergeSort
//작성자: 유영무
//작성일: 21.04.01
//내용: 병합 정렬 알고리즘
//***************************

class Sort {
	private char sorted[] = new char[30];
	//정렬
	public void merge(char alphabet[], int m, int middle, int n) {
		int i, j, k, t;
		i = m;
		j = middle + 1;
		k = m;
		//새로 생성한 배열에 비교 값 삽입
		while (i <= middle && j <= n) {
			if (alphabet[i] <= alphabet[j])
				sorted[k] = alphabet[i++];
			else
				sorted[k] = alphabet[j++];
			k++;
		}
		if (i > middle) {
			for (t = j; t <= n; t++, k++)
				sorted[k] = alphabet[t];
		} else {
			for (t = i; t <= middle; t++, k++)
				sorted[k] = alphabet[t];
		}
		for (t = m; t <= n; t++)
			alphabet[t] = sorted[t];
	}

	//병합 정렬
	public void mergeSort(char alphabet[], int m, int n) {
		int middle;
		if (m < n) {
			middle = (m + n) / 2;
			mergeSort(alphabet, m, middle);
			mergeSort(alphabet, middle + 1, n);
			merge(alphabet, m, middle, n);
		}
	}
}

public class MergeSort {
	public static void main(String[] args) {
		System.out.println("hw4_2 유영무");
		char[] alphabet = new char[20]; // 알파벳을 저장할 배열 생성
		for (int i = 0; i < 10; i++) { // 랜덤 대문자 저장
			alphabet[i] = (char) ((Math.random() * 26) + 65);
		}
		for (int i = 10; i < 20; i++) { //랜덤 소문자 저장
			alphabet[i] = (char) ((Math.random() * 26) + 97);
		}
		int size = alphabet.length;

		Sort s = new Sort();

		System.out.print("정렬할 원소 : "); //정렬 전 배열 출력
		for (int i = 0; i < alphabet.length; i++)
			System.out.printf("%s", alphabet[i]);

		s.mergeSort(alphabet, 0, size - 1); //정렬

		System.out.print("\n정렬한 원소 : "); //정렬 후 배열 출력
		for (int i = 0; i < 20; i++)
			System.out.printf("%s", alphabet[i]);
	}

}