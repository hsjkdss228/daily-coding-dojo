export function makeReportedCountTable(userList) {
  return userList.map((user) => (
    { name: user, reporters: [] }
  ));
}

export function deduplicateReports(reports) {
  const deduplicatedReports = new Set(reports);

  return [...deduplicatedReports];
}

export function reportingProcess(reportedCountTable, reports) {
  reports.forEach((element) => {
    const reporterAndReportee = element.split(' ');

    const report = { reporter: reporterAndReportee[0], reportee: reporterAndReportee[1] };

    const userTable = reportedCountTable.find((user) => (
      user.name === report.reportee
    ));

    userTable.reporters.push(report.reporter);
  });
}

export function suspendUser(reportedCountTable, limitReportCount) {
  const suspendedUsers = [];

  reportedCountTable.forEach((userTable) => {
    if (userTable.reporters.length >= limitReportCount) {
      suspendedUsers.push(userTable.name);
    }
  });

  return suspendedUsers;
}

export function makeEmailCountTable(userList) {
  return userList.map((user) => (
    { name: user, count: 0 }
  ));
}

export function setEmailCount(reportedCountTable, suspendedUsers, emailCountTable) {
  reportedCountTable.forEach((userTable) => {
    if (suspendedUsers.includes(userTable.name)) {
      userTable.reporters.forEach((reporter) => {
        const reportingUser = emailCountTable.find((countedUser) => (
          countedUser.name === reporter
        ));

        reportingUser.count += 1;
      });
    }
  });

  return emailCountTable.map((userTable) => userTable.count);
}

export function solution(userList, reports, limitReportCount) {
  const reportedCountTable = makeReportedCountTable(userList);

  const deduplicatedReports = deduplicateReports(reports);

  reportingProcess(reportedCountTable, deduplicatedReports);

  const suspendedUsers = suspendUser(reportedCountTable, limitReportCount);

  const emailCountTable = makeEmailCountTable(userList);

  return setEmailCount(reportedCountTable, suspendedUsers, emailCountTable);
}
