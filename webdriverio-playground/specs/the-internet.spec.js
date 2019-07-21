import { expect } from 'chai';
import LoginPage from '../pageobjects/the-internet-login-page';
import user from '../data/user';

const loginPage = new LoginPage();

describe('The Internet app', () => {
    it('should be able to login to the internet', () => {
        const name = user.validUser.username;
        const someText = 'Hello ${name}!';

        loginPage.visit();
        loginPage.login(user.validUser);

        expect(loginPage.confirmationText).to.contain('You logged into a secure area!');
    });
});
