package hipster.model;

public class Hipster
{
		private String name;
		private String [] hipsterPhrases;
		private Book [] hipsterBooks;
	
	
	public Hipster()
	{
		this.name = "";
		this.hipsterPhrases = new String [4];
		this.hipsterBooks = new Book [3];
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
		Book firstBook, secondBook, thirdBook;
		firstBook = new Book();
		firstBook.setAuthor("Andy Weir");
		firstBook.setTitle("The Martian");
		firstBook.setSubject("Science Fiction");
		firstBook.setPageCount(404);
		firstBook.setPrice(24.99);
		
		secondBook = new Book();
		secondBook.setAuthor("Harry Potter");
		secondBook.setTitle("Harry Potter Biography");
		secondBook.setSubject("Fantasy");
		secondBook.setPageCount(999);
		secondBook.setPrice(29.99);
		
		thirdBook = new Book(640, "Greyson Mitra", "You Fricken Fricks", "Non Fiction", 10.99 );
		
		hipsterBooks[0] = firstBook;
		hipsterBooks[1] = secondBook;
		hipsterBooks[2] = thirdBook;
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

	
