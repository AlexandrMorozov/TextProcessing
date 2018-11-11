import model.*;

public class TestInitializer
{
    Text text=new Text();
    public TestInitializer()
    {
        Sentence sentence=new Sentence();
        sentence.getListOfWords().put(0,new Word("Сегодня"));
        sentence.getListOfWords().put(2,new Word("весь"));
        sentence.getListOfWords().put(4,new Word("день"));
        sentence.getListOfWords().put(6,new Word("шел"));
        sentence.getListOfWords().put(8,new Word("дождь"));
        sentence.getListOfSigns().put(1,new PunctuationMark(' '));
        sentence.getListOfSigns().put(3,new PunctuationMark(' '));
        sentence.getListOfSigns().put(5,new PunctuationMark(' '));
        sentence.getListOfSigns().put(7,new PunctuationMark(' '));
        sentence.getListOfSigns().put(9,new PunctuationMark('.'));
        text.getListOfSentences().add(sentence);
    }

    public Sentence getSentence(int index)
    {
        return text.getListOfSentences().get(index);
    }
    public String getWordValue(int sentenceIndex,int wordIndex)
    {
        return text.getListOfSentences().get(sentenceIndex).getListOfWords().get(wordIndex).getWord();
    }
}
