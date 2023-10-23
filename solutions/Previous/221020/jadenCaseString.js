export function modifyString(word) {
  const firstCharacter = word.charAt(0).toUpperCase();
  const restCharacters = word.substring(1).toLowerCase();

  return `${firstCharacter}${restCharacters}`;
}

export function modifyStrings(splitWords) {
  return splitWords.map((word) => modifyString(word));
}

export function split(words) {
  return words.split(' ');
}

export function join(splitWords) {
  return splitWords.join(' ');
}

export default function solution(words) {
  const splitWords = split(words);

  const modifiedSplitWords = modifyStrings(splitWords);

  return join(modifiedSplitWords);
}
