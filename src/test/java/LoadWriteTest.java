import model.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadWriteTest
{
    Workspace textWorkspace =new Workspace();
    @Test
    public void loadTextTest()
    {
        String answer= textWorkspace.loadText("src/main/resources/ReadFile.txt");
        String expectedAnswer="Text was loaded successfully";
        Assert.assertEquals(answer,expectedAnswer);
    }
    @Test(dependsOnMethods={"loadTextTest"})
    public void writeTextTest()
    {
        textWorkspace.createTextStructure();
        String answer= textWorkspace.writeText("src/main/resources/WriteFile.txt");
        String expectedAnswer="Text was written successfully";
        Assert.assertEquals(answer,expectedAnswer);
    }

}
