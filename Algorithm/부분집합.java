public class Main { //{1,2,3,4}집합의 모든 부분집합
    static int[] arr;
    static boolean[] isSelected;
    public static void main(String[] args) {
        arr = new int[] {1,2,3,4}; //부분집합을 뽑을 대상 집합배열
        isSelected = new boolean[arr.length]; //부분집합을 구하기위한 방문체크배열
        recursion(0); //
    }
    //재귀 부분집합
    private static void recursion(int cnt) { //현재까지 처리한 원소개수
        if(cnt == arr.length) { //선택된 원소의 개수가 원소개수 N에 도달했을 때
            // 부분집합 완성
            for(int i=0; i<arr.length; i++) System.out.print(isSelected[i] == true ? arr[i] : "");
            System.out.println();
        } else {
            isSelected[cnt] = true; // 현재 원소를 선택했을 경우
            recursion(cnt + 1);
            isSelected[cnt] = false; //현재 원소를 선택하지않았을 경우
            recursion(cnt + 1);
        }
    }
}
