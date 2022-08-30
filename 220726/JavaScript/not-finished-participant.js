export default function solution(participants, finishers) {
  const sortedParticipants = participants.sort();
  const sortedFinishers = finishers.sort();

  const answer = sortedParticipants.filter(
    (value, index) => (value !== sortedFinishers[index]),
  );

  return answer[0];
}
