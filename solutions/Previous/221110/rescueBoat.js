export default function solution(weights, limit) {
  const sortedWeights = weights.sort((a, b) => (b - a));

  let lightWeightIndex = sortedWeights.length - 1;

  const answer = sortedWeights.reduce((count, heavyWeight, index, array) => {
    if (index > lightWeightIndex) {
      return count;
    }
    if (heavyWeight + array[lightWeightIndex] <= limit) {
      lightWeightIndex -= 1;
      return count + 1;
    }
    if (index === lightWeightIndex
      || heavyWeight + array[lightWeightIndex] > limit) {
      return count + 1;
    }
    return count;
  }, 0);

  return answer;
}
