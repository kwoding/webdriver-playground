export default class BasePage {
    constructor() { }

    get title() { return browser.getTitle(); }

    visit(path) {
        browser.url(`/${path}`);
    }
}
