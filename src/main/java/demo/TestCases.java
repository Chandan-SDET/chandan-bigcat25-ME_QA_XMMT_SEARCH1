package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        // options.add_argument("start-maximized");
        // options.add_argument("--disable-blink-features=AutomationControlled");
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.get("https://www.makemytrip.com/");
        
       String CURL= driver.getCurrentUrl();
       boolean status=CURL.contains("makemytrip.");
       if(status)
       {
        System.out.println("The test case is passed since the Url contains makemytrip.");
       }
       else{
        System.out.println("The test case is faild since the Url does not contain makemytrip.");
       }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.makemytrip.com/flights/");
         WebElement from= driver.findElement(By.xpath("//span[text()='From']"));
        from.click();
         WebElement fromf= driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromf.sendKeys("blr");
        WebElement fromb= driver.findElement(By.xpath("//span[text()='Bengaluru']"));
        fromb.click();

        WebElement to= driver.findElement(By.xpath("//span[text()='To']"));
        to.click();
         WebElement Tof= driver.findElement(By.xpath("//input[@placeholder='To']"));
        Tof.sendKeys("del");
        WebElement Tod= driver.findElement(By.xpath("//span[text()='New Delhi']"));
        Tod.click();
        WebElement date= driver.findElement(By.xpath("//div[@aria-label='Fri Mar 29 2024']"));
        date.click();
        // WebElement ren= driver.findElement(By.xpath("//span[text()='Return']"));
        // ren.click();
        // WebElement dater= driver.findElement(By.xpath("//div[@aria-label='Sat Mar 30 2024']"));
        // dater.click();
         WebElement search= driver.findElement(By.xpath("//a[text()='Search']"));
        search.click();
        Thread.sleep(5000);
        WebElement gotit= driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']"));
        gotit.click();
        Thread.sleep(5000);

        WebElement price= driver.findElement(By.xpath("(//div[@class='textRight flexOne'])[1]"));
        String peradult= price.getText();
        if(peradult.equals("₹ 6,218"))
        {
            System.out.println("The test case is passed: "+peradult);
        }
        

        System.out.println("end Test case: testCase02");
    }

    public  void testCase03() throws InterruptedException
    {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.makemytrip.com/railways/");
        WebElement from= driver.findElement(By.id("fromCity"));
        from.click();
        //input[@title='From']
        WebElement fromt= driver.findElement(By.xpath("//input[@title='From']"));
        fromt.sendKeys("ypr");
         WebElement ypr= driver.findElement(By.xpath("//span[text()='Bengaluru - All Stations']"));
        ypr.click();
        WebElement Tot= driver.findElement(By.xpath("//input[@title='To']"));
        Tot.sendKeys("ndls");
        WebElement Del= driver.findElement(By.xpath("//span[text()='Delhi - All Stations']"));
        Del.click();
        WebElement Date= driver.findElement(By.xpath("//div[@aria-label='Mon Apr 29 2024']"));
        Date.click();
        WebElement seat= driver.findElement(By.xpath("//li[text()='Third AC']"));
        seat.click();
        WebElement search= driver.findElement(By.xpath("//a[text()='Search']"));
        search.click();
        WebElement threeA= driver.findElement(By.xpath("(//div[@id='train_options_29-04-2024_0'])[1]/div/div[2]"));
        if(threeA.getText().equals("₹ 4245"))
        {
            System.out.println("The testcase is passed: "+threeA.getText());
        }
        else
        {
            System.out.println("The Tc is failed"+threeA.getText());
        }
        
        

    }

    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        //driver.get("https://www.google.com");
       // driver.get("https://www.makemytrip.com/");
       driver.get("https://www.makemytrip.com/bus-tickets/");
         //Thread.sleep(5000);
       
        // Thread.sleep(5000);
        //  driver.switchTo().frame("notification-frame-~10cb502bc");
        //  WebElement close= driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']"));
        // close.click();
        // Thread.sleep(1000);
        // driver.switchTo().parentFrame();

        // WebElement Bus= driver.findElement(By.xpath("//li[@data-cy='menu_Buses']"));
        // Bus.click();


         WebElement from= driver.findElement(By.xpath("//span[text()='From']"));
        from.click();
         WebElement fromf= driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromf.sendKeys("bangl");
        WebElement fromb= driver.findElement(By.xpath("//span[contains(text(),'Bangalore, Karnataka')]"));
        fromb.click();
        // WebElement to= driver.findElement(By.xpath("//span[text()='To']"));
        // to.click();
         WebElement Tof= driver.findElement(By.xpath("//input[@placeholder='To']"));
        Tof.sendKeys("ran");
        WebElement Tod= driver.findElement(By.xpath("//span[text()='Ranchi, Jharkhand']"));
        Tod.click();
        WebElement date= driver.findElement(By.xpath("//div[@aria-label='Mon Apr 29 2024']"));
        date.click();
         WebElement search= driver.findElement(By.id("search_button"));
         //Thread.sleep(5000);
        search.click();
       // Thread.sleep(5000);

         WebElement error= driver.findElement(By.className("error-title"));
         String err=error.getText();
         if (err.contains("No buses found"))
         {
            System.out.println("test case passed");
         }
         else{
            System.out.println("test case failed");
         }
        // gotit.click();
        System.out.println("end Test case: testCase04");
    }


}
