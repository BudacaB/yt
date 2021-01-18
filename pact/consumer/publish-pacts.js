let projectFolder = __dirname;
let pact = require('@pact-foundation/pact-node');
let project = require('./package.json');

let options = {
  pactFilesOrDirs: [projectFolder + '/pacts'],
  pactBroker: 'http://localhost:9292',
  consumerVersion: project.version,
  tags: ['latest']
};

pact.publishPacts(options).then(function () {
  console.log("Pacts successfully published!");
});
