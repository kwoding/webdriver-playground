import BasePage from './base-page';

export default class TheInternetLoginPage extends BasePage {
    get username() { return $('#username'); }

    get password() { return $('#password'); }

    get submitButton() { return $('button[type="submit"]'); }

    get confirmationText() { return $('.success').getText(); }

    visit() {
        super.visit('login');
    }

    async login(user) {
        await this.username.sendKeys(user.username);
        await this.password.sendKeys(user.password);
        await this.submitButton.click();
    }
}
