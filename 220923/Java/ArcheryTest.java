import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// 특이한 양궁 규칙;
// 과녁판의 하나의 점수 영역에 화살을 더 많이 맞춘 사람이 해당 점수를 가져감
// 단 같은 개수의 화살을 맞췄을 경우 Apeach가 해당 점수를 가져감
//
// 주어지는 요소
// number: 화살의 개수
// apeachResult: 어피치가 맞힌 과녁 점수의 개수를 10점부터 0점까지 순서대로 담은 정수 배열
//
// 요구조건
// Ryan이 우승할 수 있는 방법들 중 가장 큰 점수 차이로 우승할 수 있는 방법을 return
// 가장 큰 점수 차이 우승 방법이 여러가지일 경우, 가장 낮은 점수를 더 많이 맞춘 경우로 return
// 가장 낮은 점수를 맞춘 개수가 같을 경우, 그 다음으로 낮은 점수를 맞춘 개수가 더 많은 경우로 return
// 우승할 수 있는 방법이 없을 경우, 배열 [-1]을 return
//
// Apeach의  2 1 1 1 0 0 0 0 0 0 0
//          10 9 8 7              을 이기기 위한 경우의 수 따지기
//
// 1. 10점부터 빼앗아보기
//   - 10점 뺏기위해 3발, 남은화살 2발, 내점수 10, 상대점수 24
//   -  9점 뺏기위해 2발, 남은화살 0발, 내점수 19, 상대점수 15 >> 4점차 승리
// 2. 9점부터 빼앗아보기
//   -  9점 뺏기위해 2발, 남은화살 3발, 내점수  9, 상대점수 25
//   -  8점 뺏기위해 2발, 남은화살 1발, 내점수 17, 상대점수 17
//   -  7점 뺏기 불가능
//   -  6점 획득 시:     남은화살 0발, 내점수 23, 상대점수 17 >> 6점차 승리 (4점차 승리를 6점차 승리로 갱신)
// 3. 8점부터 빼앗아보기
//   -  8점 뺏기위해 2발, 남은화살 3발, 내점수  8, 상대점수 26
//   -  7점 뺏기위해 2발, 남은화살 1발, 내점수 15, 상대점수 19
//   -  6점 획득 시:     남은화살 0발, 내점수 21, 상대점수 19 >> 2점차 승리 (낮은 점수 얻어보기 더 하지 않음)
//
// 가장 높은 점수차로 이긴 9점, 8점, 6점을 획득한 배열을 return
//
// 과정을 정리하면?
// 가장 높은 점수부터 뺏거나 얻기를 1점씩 낮춰가면서 반복해 획득할 수 있는 점수를 생성한다.
//   특정 점수를 뺏을 수 없는 경우, 그 다음 점수를 뺏거나 얻도록 한다.
// 이 생성된 점수가 처음부터 Apeach보다 낮을 경우, [-1] return
// 점수가 생성되었으면 가장 높은 점수 시작지점을 1 낮춰서 위의 과정을 반복 시도한다.
// 생성된 점수가 이전보다 높으면 또 가장 높은 점수 시작지점을 1 낮춰서 반복 시도를 이어가고,
// 생성된 점수가 이전보다 낮으면 바로 직전에 생성되었었던 가장 높은 점수 배열을 반환한다.

class ArcheryTest {
  @Test
  void checkNeededArrowCountToTakeOtherScore() {
    Archery test = new Archery();

    int arrowCountOtherHaveMatched = 2;

    int arrowsNeed
        = test.checkNeededArrow(arrowCountOtherHaveMatched);

    assertThat(arrowsNeed).isEqualTo(3);
  }
}