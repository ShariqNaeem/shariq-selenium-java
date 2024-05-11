package mercans.utils;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static mercans.utils.DriverManager.driver;

public class Wait{

    private static WebDriverWait wait = null;
    public static WebDriverWait longWaitForWebElement() throws InterruptedException {
        if(wait == null)
        {
            return new WebDriverWait(driver,Duration.ofSeconds(40));
        }
        else
        {
            return wait;
        }
    }


}
