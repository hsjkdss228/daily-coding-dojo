export default function solution(array, commands) {
  return [...Array(commands.length)].map((_, index) => (
    array.slice(commands[index][0] - 1, commands[index][1])
      .sort((a, b) => a - b)
      .find((element, __, slicedArray) => (
        element === slicedArray[commands[index][2] - 1]
      ))
  ));
}
