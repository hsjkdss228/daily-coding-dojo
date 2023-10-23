import {
  makeReportedCountTable, deduplicateReports, reportingProcess, suspendUser,
  makeEmailCountTable, setEmailCount, solution,
} from './reporting-results';

test('Make reported count table', () => {
  const userList = [
    'muzi', 'frodo', 'apeach', 'neo',
  ];

  const reportedCountTable = makeReportedCountTable(userList);

  expect(reportedCountTable[0]).toStrictEqual({ name: 'muzi', reporters: [] });
  expect(reportedCountTable[1]).toStrictEqual({ name: 'frodo', reporters: [] });
  expect(reportedCountTable[2]).toStrictEqual({ name: 'apeach', reporters: [] });
  expect(reportedCountTable[3]).toStrictEqual({ name: 'neo', reporters: [] });
});

test('Deduplicate reports with no duplicated reports', () => {
  const reports = [
    'muzi frodo',
    'apeach frodo',
    'frodo neo',
    'muzi neo',
    'apeach neo',
  ];

  const deduplicatedReports = deduplicateReports(reports);

  expect(deduplicatedReports.length).toBe(5);
});

test('Deduplicate reports with no duplicated reports', () => {
  const reports = [
    'muzi frodo',
    'muzi frodo',
    'muzi frodo',
    'muzi frodo',
    'muzi neo',
    'apeach neo',
  ];

  const deduplicatedReports = deduplicateReports(reports);

  expect(deduplicatedReports.length).toBe(3);
});

test('Reporting process', () => {
  const reportedCountTable = [
    { name: 'muzi', reporters: [] },
    { name: 'frodo', reporters: [] },
    { name: 'apeach', reporters: [] },
    { name: 'neo', reporters: [] },
  ];

  const reports = [
    'muzi frodo',
    'apeach frodo',
    'frodo neo',
    'muzi neo',
    'apeach neo',
    'neo apeach',
  ];

  reportingProcess(reportedCountTable, reports);

  expect(reportedCountTable[0].reporters).toStrictEqual([]);
  expect(reportedCountTable[1].reporters).toStrictEqual(['muzi', 'apeach']);
  expect(reportedCountTable[2].reporters).toStrictEqual(['neo']);
  expect(reportedCountTable[3].reporters).toStrictEqual(['frodo', 'muzi', 'apeach']);
});

test('Suspend user who exceeded reporting limit', () => {
  const reportedCountTable = [
    { name: 'muzi', reporters: [] },
    { name: 'frodo', reporters: ['muzi', 'apeach'] },
    { name: 'apeach', reporters: ['neo'] },
    { name: 'neo', reporters: ['frodo', 'muzi', 'apeach'] },
  ];

  const limitReportCount = 2;

  const suspendedUser = suspendUser(reportedCountTable, limitReportCount);

  expect(suspendedUser).toStrictEqual(['frodo', 'neo']);
});

test('Make email count table', () => {
  const userList = [
    'muzi', 'frodo', 'apeach', 'neo',
  ];

  const emailCountTable = makeEmailCountTable(userList);

  expect(emailCountTable[0]).toStrictEqual({ name: 'muzi', count: 0 });
  expect(emailCountTable[1]).toStrictEqual({ name: 'frodo', count: 0 });
  expect(emailCountTable[2]).toStrictEqual({ name: 'apeach', count: 0 });
  expect(emailCountTable[3]).toStrictEqual({ name: 'neo', count: 0 });
});

test('Decide how many times to send an email', () => {
  const reportedCountTable = [
    { name: 'muzi', reporters: [] },
    { name: 'frodo', reporters: ['muzi', 'apeach'] },
    { name: 'apeach', reporters: ['neo'] },
    { name: 'neo', reporters: ['frodo', 'muzi', 'apeach'] },
  ];

  const suspendedUser = ['frodo', 'neo'];

  const emailCountTable = [
    { name: 'muzi', count: 0 },
    { name: 'frodo', count: 0 },
    { name: 'apeach', count: 0 },
    { name: 'neo', count: 0 },
  ];

  const emailCounts = setEmailCount(reportedCountTable, suspendedUser, emailCountTable);

  expect(emailCounts).toStrictEqual([2, 1, 2, 0]);
});

test('solution', () => {
  const userList = [
    'muzi', 'frodo', 'apeach', 'neo',
  ];

  const reports = [
    'muzi frodo',
    'apeach frodo',
    'frodo neo',
    'muzi neo',
    'apeach muzi',
  ];

  const limitReportCount = 2;

  expect(solution(userList, reports, limitReportCount)).toStrictEqual([2, 1, 1, 0]);
});
