//This page calls to me other page.
package characterSelector;

import java.util.Random;
import characterSelector.memGame;
//Connects my classes 
public class selectStart extends animeCharSelector{

	public static void main(String[] args) {
					
					animeCharSelector c1 = new animeCharSelector("Goku");
					c1.animePeas();
					//Randomly selects a character.
					animeCharSelector c2 = new animeCharSelector();
					c2.processMatch(character[new Random().nextInt(character.length)]);
					animeCharSelector c3 = new animeCharSelector();
					c3.vertices();
					memGame runnable = new memGame();
					runnable.formGrid();
					runnable.job();
					runnable.job2();
					runnable.job3();
					runnable.job4();
				}
			}
