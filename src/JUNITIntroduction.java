import org.junit.*;

/**
 * Created by Jay
 */
public class JUNITIntroduction {
    @BeforeClass
    public static void connection(){
        System.out.println("Do DB connection");
    }

    @AfterClass
    public static void closeConnection(){
        System.out.println("Close connection");
    }


    @Before
    public void openBrowser(){
        System.out.println("Open Browser");
    }

    @Test
    public void verifyIShouldNavigateToLoginPage(){
        System.out.println("Navigate to Login page");
    }

    @Test
    public void doLogin(){
        System.out.println("Login to application");
    }

    @After
    public void closeBrowser(){
        System.out.println("Close browser");
    }
}
