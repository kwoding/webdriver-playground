import { expect } from 'chai';
import LoginPage from '../pageobjects/the-internet-login-page';
import user from '../data/user';

const loginPage = new LoginPage();

describe('The Internet app', () => {
    it('should be able to login to the internet', async () => {
        await loginPage.visit();
        await loginPage.login(user.validUser);

        expect(await loginPage.confirmationText).to.contain('You logged into a secure area!');
    });
});
