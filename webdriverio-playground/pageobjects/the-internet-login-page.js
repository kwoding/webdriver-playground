import BasePage from './base-page';

export default class TheInternetLoginPage extends BasePage {

    get username() { return $('#username'); }

    get password() { return $('#password'); }

    get submitButton() { return $('button[type="submit"]'); }

    get confirmationText() { return $('.success').getText(); }

    get anotherElement() {
        let anotherElement = $('.title');
        return anotherElement = $('.message');
    }

    get yetAnotherElement() { 
        $('.title');
    }

    visit() {
        super.visit('login');
    }

    login(user) {
        this.username.setValue(user.username);
        this.password.setValue(user.password);
        this.submitButton.click();
    }
}
