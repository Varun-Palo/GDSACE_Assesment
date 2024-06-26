package hooks;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.palo.Factory.DriverFactory;
import org.palo.utils.WebActions;

import java.nio.file.Paths;

public class Hooks {

    public DriverFactory driverFactory;
    public Page page;

    @Before
    public void launchBrowser() {
        String browserName = WebActions.getProperty("browser");  //Fetching browser value from config file
        driverFactory = new DriverFactory();
        page = driverFactory.initDriver(browserName); // Passing browser name to launch the browser
    }


    @After()
    public void takeScreenshotAndTrace(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll("", "_"); //Replace all space in scenario name with underscore
            byte[] sourcePath = page.screenshot();
            scenario.attach(sourcePath, "image/png", screenshotName);  //Attach screenshot to report if scenario fails
            DriverFactory.context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("target/" + screenshotName + ".zip")));
            page.close();
        }
        else {
            DriverFactory.getContext().browser().close();
        }
    }

}
