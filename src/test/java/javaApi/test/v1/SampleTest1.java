package javaApi.test.v1;

import com.aventstack.extentreports.Status;
import javaApi.test.TestBaseBrowser;
import javaApi.utilities.Reporter;
import org.testng.annotations.Test;

public class SampleTest1 extends TestBaseBrowser {

    @Test
    public void SampleTest1(){
        System.out.println("Sample Test 1");
        Reporter.test.log(Status.PASS,"Pass");
    }

}
