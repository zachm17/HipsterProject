package hipster.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpringLayout; //For layout
//import gui.controller.GUIController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import hipster.controller.HipsterController;
import hipster.model.Book;
import javax.swing.*;

public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private SpringLayout baseLayout;
	private JComboBox<String> phraseComboBox;
	private JLabel bookPageCountLabel;
	private JLabel bookAuthorLabel;
	private JLabel bookSubjectLabel;
	private JLabel bookTitleLabel;
	private JLabel bookPriceLabel;
	private JButton changeBookButton;
	private int maxClicks;
	private int startClick;
	
	public HipsterPanel(HipsterController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		bookPageCountLabel = new JLabel("The page count");
		bookAuthorLabel = new JLabel("The author");
		bookPriceLabel = new JLabel("The price");
		bookSubjectLabel = new JLabel("The subject");
		bookTitleLabel = new JLabel("The title");
		changeBookButton = new JButton("Change books");
		phraseComboBox = new JComboBox<String>();
		maxClicks = baseController.getFirstHipster().getHipsterBooks().length;
		startClick = 0;
		
		setupComboBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupComboBox()
	{
		String [] phrases = baseController.getFirstHipster().getHipsterPhrases();
		DefaultComboBoxModel phraseModel = new DefaultComboBoxModel(phrases);
		phraseComboBox.setModel(phraseModel);
		
	}


	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.add(bookAuthorLabel);
		this.add(phraseComboBox);
		this.add(bookPageCountLabel);
		this.add(bookTitleLabel);
		this.add(bookPriceLabel);
		this.add(bookSubjectLabel);
		this.add(changeBookButton);
	}

	private void setupLayout()

	{
		baseLayout.putConstraint(SpringLayout.WEST, changeBookButton, 165, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, changeBookButton, -32, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, phraseComboBox, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, phraseComboBox, 42, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, bookTitleLabel, 135, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookAuthorLabel, -33, SpringLayout.NORTH, bookTitleLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookTitleLabel, -45, SpringLayout.NORTH, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookSubjectLabel, -99, SpringLayout.NORTH, changeBookButton);
		baseLayout.putConstraint(SpringLayout.NORTH, bookSubjectLabel, 18, SpringLayout.SOUTH, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookSubjectLabel, 0, SpringLayout.WEST, bookAuthorLabel);
		baseLayout.putConstraint(SpringLayout.EAST, bookSubjectLabel, -263, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, bookPriceLabel, 135, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookPriceLabel, -205, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, bookPageCountLabel, -51, SpringLayout.NORTH, bookPriceLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookAuthorLabel, 0, SpringLayout.WEST, bookPageCountLabel);
		baseLayout.putConstraint(SpringLayout.WEST, bookPageCountLabel, 135, SpringLayout.WEST, this);
	}
	
	private void changeColor()
	{
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		setBackground(new Color(red, green, blue));
	}
	
	private void setupListeners()
	{
		phraseComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selcection)
			{
			changeColor();
			String updatedTitle = phraseComboBox.getSelectedItem().toString();
			baseController.getBaseFrame().setTitle(updatedTitle);
		}
		});
		
		changeBookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				changeColor();
				Book [] tempBooks = baseController.getFirstHipster().getHipsterBooks();
				if(startClick < maxClicks)
				{
					bookSubjectLabel.setText("Book subject:   " + tempBooks[startClick].getSubject());
					bookAuthorLabel.setText("Book author: " + tempBooks[startClick].getAuthor());
					bookTitleLabel.setText("Book title: " + tempBooks[startClick].getTitle());
					bookPageCountLabel.setText("Book pages: " + tempBooks[startClick].getPageCount());
					bookPriceLabel.setText("Book price: " + tempBooks[startClick].getPrice());
					startClick++;
				}
				else
				{
					startClick = 0;
					bookSubjectLabel.setText("Book subject: ");
					bookAuthorLabel.setText("Book author: ");
					bookTitleLabel.setText("Book title ");
					bookPageCountLabel.setText("Book pages: ");
					bookPriceLabel.setText("Book price: ");
				}
				
			}
		});
	}
}