export default function solution(string: string): number[] {
  const charAndLastIndexes: Map<string, number> = new Map();

  return [...string].map((char, index) => {
    const difference = charAndLastIndexes.has(char)
      ? index - (charAndLastIndexes.get(char) as number)
      : -1;

    charAndLastIndexes.set(char, index);

    return difference;
  });
}
