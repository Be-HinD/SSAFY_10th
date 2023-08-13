import java.util.Arrays;

public class Main { //3개의 수 순열
    static boolean[] visited; //재귀를 위한 방문체크배열
    static int[] result; //재귀 순열결과를 위한 배열
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[] {1,2,3}; //순열을 뽑을 대상 집합배열
        npn(arr);
        result = new int[2]; //순열 가지 수 r만큼의 배열을 선언
        visited = new boolean[arr.length]; //대상배열 크기만큼 방문배열 길이 선언
        npr(0);
    }
    // n개의 수 중 n개를 뽑는 npn순열 (n!)
    private static void npn(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                if(j == i) continue; //첫번째 수와 두번째 수가 같다면 continue
                for(int k=0; k<arr.length; k++) {
                    if(k == i || k == j) continue; //세번째 수가 첫번째 수, 두번째 수와 같다면 continue
                    System.out.println(arr[i] +" " + arr[j] + " " + arr[k]);
                }
            }
        }
    }
    // n개의 수 중 r개를 뽑는 npr순열 (n!)
    private static void npr(int cnt) { //cnt : 지금껏 몇개의 수를 선택했는지
        // r개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
        if (cnt == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        // 대상 집합을 순회하며 숫자를 하나 선택한다.
        for (int i = 0; i < arr.length; i++) {
            // 이미 해당 숫자를 선택한 경우에는 스킵.
            if (visited[i]) {
                continue;
            }
            // 선택하지 않은경우, 선택했다는 표시를 해준다.
            visited[i] = true;
            // 숫자를 담는다.
            result[cnt] = arr[i];
            // 자신을 재귀 호출한다.
            npr(cnt + 1);
            // 선택을 해제한다.
            visited[i] = false;
        }
    }
}
