// 최초 시나리오
// 1. 주어진 숫자 하나를 가져온다.
//   1-1. 숫자의 위치를 파악해 손가락을 결정한다.
//        숫자가 1, 4, 7, * 이면 L
//        숫자가 3, 6, 9, # 이면 R
//     1-1-1. 숫자가 2, 5, 8, 0 이면
//          손가락의 위치와 숫자 위치의 거리를 계산한다.
//          계산법: (abs(손가락x - 숫자x) + (abs(손가락y - 숫자y))
//       1-1-1-1. 거리가 다르면 작은 쪽의 손가락을 선택한다.
//       1-1-1-2. 거리가 같으면 어느쪽 손잡이인지로 판단한다.
//   1-2. 선택한 손가락 이름을 배열에 더한다.
//   1-3. 선택한 손가락을 숫자 위치로 이동시킨다.
// 2. 주어지는 숫자들만큼 1의 과정을 반복한다.
//
// 테스트 코드를 작성하면서 수정한 시나리오
// 1. 주어지는 숫자들만큼 아래 과정을 반복한다.
//   1-1. 숫자가 1, 4, 7, *이면 왼손, 숫자가 3, 6, 9, #이면 오른손을 선택한다.
//   1-2. 숫자가 2, 5, 8, 0이면 다음의 과정을 거쳐 결정한다.
//     1-2-1. 숫자 하나의 위치를 가져온다.
//     1-2-2. 각 손가락의 위치와 숫자의 위치를 기준으로 각 손가락과의 거리를 계산한다.
//     1-2-3. 거리가 다르면 거리가 작은 쪽의 손가락을 선택한다.
//     1-2-4. 거리가 같으면 주로 사용하는 손의 손가락으로 선택한다.
//   1-3. 선택한 손가락을 숫자의 위치로 이동시킨다.

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyPadTest {
  @Test
  void selectFingerWithAnswerIsAlreadyDeclared() {
    KeyPad test = new KeyPad();

    assertEquals("L", test.selectFinger(1, null, null, null));
    assertEquals("L", test.selectFinger(4, null, null, null));
    assertEquals("L", test.selectFinger(7, null, null, null));
    assertEquals("R", test.selectFinger(3, null, null, null));
    assertEquals("R", test.selectFinger(6, null, null, null));
    assertEquals("R", test.selectFinger(9, null, null, null));
  }

  @Test
  void checkNumberPosition() {
    KeyPad test = new KeyPad();

    assertArrayEquals(new int[]{0, 0}, test.checkNumberPosition(1));
    assertArrayEquals(new int[]{0, 1}, test.checkNumberPosition(2));
    assertArrayEquals(new int[]{0, 2}, test.checkNumberPosition(3));
    assertArrayEquals(new int[]{1, 0}, test.checkNumberPosition(4));
    assertArrayEquals(new int[]{1, 1}, test.checkNumberPosition(5));
    assertArrayEquals(new int[]{1, 2}, test.checkNumberPosition(6));
    assertArrayEquals(new int[]{2, 0}, test.checkNumberPosition(7));
    assertArrayEquals(new int[]{2, 1}, test.checkNumberPosition(8));
    assertArrayEquals(new int[]{2, 2}, test.checkNumberPosition(9));
    assertArrayEquals(new int[]{3, 1}, test.checkNumberPosition(0));
  }

  @Test
  void checkDistance() {
    KeyPad test = new KeyPad();

    int[] numberPosition = new int[]{0, 1};
    int[] leftFingerPosition = new int[]{0, 0};
    int[] rightFingerPosition = new int[]{3, 1};

    int distanceBetweenLeftAndNumber
        = test.checkDistance(numberPosition, leftFingerPosition);
    int distanceBetweenRightAndNumber
        = test.checkDistance(numberPosition, rightFingerPosition);

    assertEquals(1, distanceBetweenLeftAndNumber);
    assertEquals(3, distanceBetweenRightAndNumber);
  }

  @Test
  void chooseShortDistance() {
    KeyPad test = new KeyPad();

    int distanceBetweenLeftAndNumber = 1;
    int distanceBetweenRightAndNumber = 2;
    assertEquals("L", test.chooseShortDistance(
        distanceBetweenLeftAndNumber, distanceBetweenRightAndNumber));

    distanceBetweenLeftAndNumber = 3;
    distanceBetweenRightAndNumber = 1;
    assertEquals("R", test.chooseShortDistance(
        distanceBetweenLeftAndNumber, distanceBetweenRightAndNumber));
  }

  @Test
  void chooseHandUse() {
    KeyPad test = new KeyPad();

    assertEquals("L", test.chooseHandUse("left"));
    assertEquals("R", test.chooseHandUse("right"));
  }

  @Test
  void moveFingerPosition() {
    KeyPad test = new KeyPad();

    int[] fingerPosition = new int[]{0, 0};
    int number = 2;

    fingerPosition = test.moveFingerPosition(number);
    assertArrayEquals(new int[]{0, 1}, fingerPosition);
  }

  @Test
  void solution() {
    KeyPad test = new KeyPad();
    assertEquals(
        "LRLLLRLLRRL",
        test.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    assertEquals(
        "LRLLRRLLLRR",
        test.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    assertEquals(
        "LLRLLRLLRL",
        test.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
  }
}
