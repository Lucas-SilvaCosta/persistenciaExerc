public class TesteCreateFile{
	public static void main( String[] args )
   {
      CreateTextFile application = new CreateTextFile();

      application.openFile();
      application.addTexts("aaa");
      application.closeFile();
   }
}