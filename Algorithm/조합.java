import java.util.Arrays;

public class Main { //{1,2,3,4}중 원소 3개를 포함하는 모든 조합
    static int[] arr, result;
    public static void main(String[] args) {
        arr = new int[] {1,2,3,4}; //조합을 뽑을 대상 집합배열
        iterator();
        result = new int[3]; // 구하려는 조합의 수 r개만큼 크기선언
        System.out.println("================");
        recursion(0, 0);
    }
    //조합 구현 - 반복문
    private static void iterator() {
        //r개를 포함하는 조합을 구하려면 반복문의 개수가 r개
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                }
            }
        }
    }
    //조합 구현 - 재귀
    private static void recursion(int cnt, int start) { // cnt : 현재까지 뽑은 조합 원소 개수, start : 조합 시도할 원소의 시작 인덱스
        if(cnt == result.length) { // 원소를 r개만큼 뽑을 경우 조합 생성완료
            System.out.println(Arrays.toString(result));
        } else {
            for(int i=start; i<arr.length; i++) { //시작 지점부터 원본 배열크기만큼 반복
                result[cnt] = arr[i]; //결과 배열에 선택되지않은 원소를 추가
                recursion(cnt + 1, i + 1); //재귀호출 : 뽑은 원소 개수 + 1, 현재 선택한 인덱스번호에 +1을 해주어야함!!!
            }
        }
    }
}
