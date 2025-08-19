package manager;
import org.openqa.selenium.By;

public class LoginHelper1 {

    private final ApplicationManager1 manager1;

    public LoginHelper1(ApplicationManager1 manager1){
        this.manager1 = manager1;
    }

    void login1(String user, String password) {
        manager1.driver1.findElement(By.name("user")).sendKeys(user);
        manager1.driver1.findElement(By.name("pass")).sendKeys(password);
        manager1.driver1.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }
}
