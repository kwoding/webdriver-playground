import { browser } from 'protractor';

require('@babel/register');

exports.config = {
    framework: 'jasmine',
    seleniumAddress: 'http://localhost:4444/wd/hub',
    baseUrl: 'https://the-internet.herokuapp.com',
    specs: ['./specs/*.spec.js'],
    mochaOpts: {
        ui: 'bdd',
        timeout: 60000,
        compilers: ['js:@babel/register']
    },
    onPrepare() {
        browser.ignoreSynchronization = true;
    }
};
