import model.Text;

import org.testng.Assert;
import org.testng.annotations.Test;


public class FunctionTest
{
    TestInitializer testInitializer=new TestInitializer();
    @Test
    public void swapTest()
    {

        String[] expectedAnswer= {
                testInitializer.getWordValue(0,8),
                testInitializer.getWordValue(0,0)
        };
        testInitializer.getSentence(0).swapFirstAndFastWord();
        String[] answer={
                testInitializer.getWordValue(0,0),
                testInitializer.getWordValue(0,8)
        };
        Assert.assertEquals(answer,expectedAnswer);
    }
    @Test
    public void sentenceAssembleTest()
    {
        String answer=testInitializer.getSentence(0).assembleSentence(0,10);
        String expectedAnswer="Сегодня весь день шел дождь.";
        Assert.assertEquals(answer,expectedAnswer);
    }
    @Test
    public void parserTest()
    {
        boolean flag=true;
        Text text=new Text();
        String testString="Сегодня весь день шел дождь.";
        text.parseText(testString);
        int numberOfWords=text.getListOfSentences().get(0).getListOfWords().size();
        int numberOfSigns=text.getListOfSentences().get(0).getListOfSigns().size();
        int expectedNumberOfWords=5;
        int expectedNumberOfSigns=5;
        if(numberOfSigns!=expectedNumberOfSigns && numberOfWords!=expectedNumberOfWords)
        {
            flag=false;
        }
        Assert.assertTrue(flag);
    }
}
