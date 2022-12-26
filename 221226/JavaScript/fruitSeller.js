export function sortInDescendingOrder(scores) {
  return scores.sort((a, b) => b - a);
}

export default function solution(k, numberInBox, scores) {
  if (numberInBox > scores.length) {
    return 0;
  }

  const descendingScores = sortInDescendingOrder(scores);

  return descendingScores.reduce((answer, score, index) => (
    index % numberInBox === numberInBox - 1
      ? answer + (score * numberInBox)
      : answer
  ), 0);
}
