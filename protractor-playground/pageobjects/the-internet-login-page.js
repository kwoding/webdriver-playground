import BasePage from './base-page';

export default class TheInternetLoginPage extends BasePage {
    get username() { return $('#username'); }

    get password() { return $('#password'); }

    get submitButton() { return $('button[type="submit"]'); }

    get confirmationText() { return $('.success').getText(); }

    get someElement() { return element(by.css('[ng-model="test"]')); }

    get anotherElement() { return element(by.id('a title')); }

    get yetAnotherElement() { return element(by.xpath('/container/div[1]/title')); }

    visit() {
        super.visit('login');
    }

    async login(user) {
        await this.username.sendKeys(user.username);
        await this.password.sendKeys(user.password);
        await this.submitButton.click();
    }
}
