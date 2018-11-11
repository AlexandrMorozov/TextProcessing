package control;

import model.Workspace;

public class Controller
{
    Workspace workspace=new Workspace();
    public String createNewText(String path)
    {
        return workspace.loadText(path);
    }
    public void textStructure()
    {
        workspace.createTextStructure();
    }
    public String writeTextToFile(String path)
    {
        return workspace.writeText(path);
    }
    public void swapFirstAndFastWord()
    {
        workspace.swapWordsInText();
    }

}
