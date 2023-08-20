public static int upperBound(int[] arr,  int key) { //arr : 값을 찾을 정렬된 배열, key : 배열 내에서 찾을 특정값
    int low = 0;
    int high = arr.length; //배열의 길이만큼 준 이유는 배열의 최대값보다 더 큰 값을 찾을때 배열의 길이를 주기위해서
    while (low < high) {
        final int mid = low + (high - low)/2;
        if (key >= arr[mid]) { //중앙값이 찾고자하는 key값 보다 같거나 작을 경우
            low = mid + 1;
        } else { //중앙값이 key값보다 클 경우
            high = mid;
        }
    }
    return low; //key값보다 같거나 큰값을 리턴
}
