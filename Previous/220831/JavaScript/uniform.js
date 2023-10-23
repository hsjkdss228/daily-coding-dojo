export function deduplicate(losts, reserves) {
  const uniqueLosts = [];

  losts.forEach((index) => {
    if (!reserves.includes(index)) {
      uniqueLosts.push(index);
    }
  });

  const uniqueReserves = [];

  reserves.forEach((index) => {
    if (!losts.includes(index)) {
      uniqueReserves.push(index);
    }
  });

  return { uniqueLosts, uniqueReserves };
}

export function sortArrays(uniqueLosts, uniqueReserves) {
  const sortedLosts = uniqueLosts.sort((a, b) => a - b);

  const sortedReserves = uniqueReserves.sort((a, b) => a - b);

  return { sortedLosts, sortedReserves };
}

export function findStudentsCantLendClothes(sortedLosts, sortedReserves) {
  sortedLosts.forEach((studentLost, index) => {
    if (sortedReserves.includes(studentLost - 1)) {
      sortedLosts[index] = Number.MIN_SAFE_INTEGER;
      sortedReserves[sortedReserves.indexOf(studentLost - 1)] = Number.MIN_SAFE_INTEGER;
      return;
    }

    if (sortedReserves.includes(studentLost + 1)) {
      sortedLosts[index] = Number.MIN_SAFE_INTEGER;
      sortedReserves[sortedReserves.indexOf(studentLost + 1)] = Number.MIN_SAFE_INTEGER;
    }
  });

  return sortedLosts.filter((studentLost) => studentLost !== Number.MIN_SAFE_INTEGER);
}

export function solution(studentCount, losts, reserves) {
  const lostsIndexModified = losts.map((lost) => lost - 1);
  const reservesIndexModified = reserves.map((reserve) => reserve - 1);

  const { uniqueLosts, uniqueReserves } = deduplicate(lostsIndexModified, reservesIndexModified);

  const { sortedLosts, sortedReserves } = sortArrays(uniqueLosts, uniqueReserves);

  const studentsUnableToAttend = findStudentsCantLendClothes(sortedLosts, sortedReserves);

  return studentCount - studentsUnableToAttend.length;
}
