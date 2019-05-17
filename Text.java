public class Text{

	private String text;

	public Text(){
		this("-generic-");
	}
	public Text(String t){
		text = t;
	}

	public void setText(String t){text = t;}
	public String getText(){return text;}
}