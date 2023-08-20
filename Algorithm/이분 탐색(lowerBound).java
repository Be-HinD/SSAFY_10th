public static int lowerBound(int[] arr,  int key) { //arr은 정렬된 배열, key는 배열에서 찾을 값
  int low = 0;
  int high = arr.length;
  while (low < high) {
      final int mid = low + (high - low)/2;
      if (key <= arr[mid]) { //중앙값이 찾고자하는 key값 보다 같거나 클 경우
          high = mid;
      } else { //중앙값이 key값보다 작을 경우
          low = mid + 1;
      }
  }
  return low; //key값보다 같거나 큰값을 리턴
}
