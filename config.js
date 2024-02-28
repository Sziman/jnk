var AllureReporter = require('allure_report')
exports.congfig = {
    seleniumAddress: 'http//localhost:3444/wd/hub',
    specs: [spec.js],
onPrepare: function() {
    jasmine.getEnv().addReporter(new AllureReporter{});
        jasmine.getEnv().afterEach(function{done}) {
            browser.takescreeshot{}.then{function (png) }

        }

}
}
