package characterSelector;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class animeCharSelector {

	public class Graph {

	}
	//Current available Characters
	public static Boolean Found = false;
		static String[] character = {"Goku", "Naruto", "Asta", "Luffy"};
		//This will be the selected genre choice
		public animeCharSelector(String myCharacter)
		{
			//character = myCharacter;
		}
		//May be used for Selection process
		public animeCharSelector()
		{
			
		}
		//The meat and potatoes of what the project will contain 
		public void animePeas() {
		//What my project is	
		String agent = "Anime Charcater Selector";
		//Shows based off the users feelings
		String performanceMeasure = "Character comparison";
		//Possible places the content will be viewed
		String environment = "Anywhere";
		//Used to access the content 
		String actuators = "Keyboard, Mouse, Touchpad, Charcater list";
		//Mediums to be used to find content
		String sensors = "Microphone, Keyboard";
		
		//Printout of my PEAS
		System.out.println("Agent: " + agent);
		System.out.println("Performance Measure: " + performanceMeasure);
		System.out.println("Environment: " + environment);
		System.out.println("Actuators: " + actuators);
		System.out.println("Sensors: " + sensors);
		
		
		}
		//Variables for each character 
		public static String C1 = "Goku";
		public static String C2 = "Naruto";
		public static String C3 = "Asta";
		public static String C4 = "Luffy";
		
		//App starts off without a match
		public void processMatch(String character2) {
			if (Found == false)
				findMatch(character2);
}
		//This section tells which character is selected
		public void findMatch (String c){
			if (c.equals(C2)) {
				System.out.println("Comparison this is not Asta");
				System.out.println("The character is Naruto");
				Found = true;
			}
			else if (c.equals(C3)) {
				System.out.println("The character is Asta");
				Found = true;
			}
			else if (c.equals(C4)) {
				System.out.println("The character is Luffy");
				Found = true;
			}
			else {
				System.out.println("The character is Goku");
				Found = true;
			}
}
		//Nodes that are visited during the search
		public void vertices() {
			
			Search look = new Search(4);

			look.addEdge(0, 1); //Goes from Goku to Naruto
			look.addEdge(0, 2); //Goes from Goku to Asta
			look.addEdge(0, 3); //Goes From Goku to Luffy
			look.addEdge(3, 3); //Loops Luffy
			System.out.println("");
			System.out.println("Depth First Traversal of my Anime character tree");

			look.DFS();
		}
		
	
		}




