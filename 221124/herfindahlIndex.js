export default function solution(citations) {
  citations.sort((a, b) => b - a);

  for (let i = 0; i < citations.length; i += 1) {
    if (i >= citations[i]) {
      return i;
    }
  }
  return citations.length;
}
