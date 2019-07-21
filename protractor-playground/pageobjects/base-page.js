export default class BasePage {
    get title() {
        return browser.getTitle();
    }

    visit(path) {
        browser.sleep(500);
        browser.get(`/${path}`);
    }

    forceClick(elm) {
        browser.actions().click(elm);
    }
}
