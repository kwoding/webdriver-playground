export default class BasePage {
    get title() { return browser.getTitle(); }

    visit(path) {
        browser.url(`/${path}`);
    }
}
