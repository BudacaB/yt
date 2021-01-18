module.exports = {
  testMatch: [ "**/+(*.)+(pact)\.(spec)\.(ts)" ],
  transform: {
    '^.+\\.(ts|js|html)$': 'ts-jest'
  },
  globals: {
    'ts-jest': {
      tsConfig: '<rootDir>/tsconfig.spec.json'
    },
    stringifyContentPathRegex: true
  },
  moduleFileExtensions: ['ts', 'js', 'html'],
  testURL: 'http://localhost:1234',
  setupFilesAfterEnv: ['<rootDir>/pact/jest/setupJest.ts']
};
