package hipster.model;

public class Hipster
{
		private String name;
		private String [] hipsterPhrases;
	
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String [4];
//		this.hipsterBooks = new Book [3];
		setupArray();
		setupBooks();
	}
	
	private void setupArray()
	{
		hipsterPhrases[0] = "That is so too mainstream";
		hipsterPhrases[1] = "I don't mean to sound like a hipster, but, ya know";
		hipsterPhrases[2] = "Lol im sarcastic";
		hipsterPhrases[3] = "I was into pokemon before it was cool";
	}
	
	private void setupBooks()
	{
		
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name)
	{
		this.name = name;
	}


	public String[] getHipsterPhrases()
	{
		return hipsterPhrases;
	}


	public void setHipsterPhrases(String[] hipsterPhrases)
	{
		this.hipsterPhrases = hipsterPhrases;
	}
	
}

	
