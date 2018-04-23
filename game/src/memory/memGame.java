package memory;

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

public class memGame implements ActionListener {
    JPanel p;
    JFrame f;

    String[] charArray = { "Luffy", "Luffy", "Asta", "Asta", "Naruto", "Naruto", "Goku", "Goku"};
    String[] randomChars;

    JButton[][] cards;

    boolean turn = true;

    int i = 0;
    int card;
    int cardIndex;

    public static void main(String[] args) {
     
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                memGame app = new memGame();
                app.formGrid();
            }
        });
    }

    public void laycards(JPanel panel) {
        cards = new JButton[2][]; 
        shufflecard();
        for (int i = 0; i < 2 * 4; i++) { 
            if (i % 4 == 0)
                cards[i / 4] = new JButton[4];
            cards[i / 4][i % 4] = new JButton("Click"); 
            cards[i / 4][i % 4].addActionListener(this);
            panel.add(cards[i / 4][i % 4]);
        }
    }

    public void shufflecard() {
        List<String> list = Arrays.asList(charArray);
        Collections.shuffle(list);
        randomChars = list.toArray(new String[list.size()]);
    }

    public void updatecharArray(String a, String b, boolean add) {
        String[] charList;
        int oldLen = charArray.length;

        if (add) { 
            charList = new String[oldLen + 2];
            charList[0] = new String(a); 
            charList[1] = new String(b); 
            for (int item = 2; item <= oldLen; item += 2) {
                charList[item] = charArray[item - 2];
                charList[item + 1] = charArray[item - 1];
            }
            charArray = charList;
        } else { 
            charList = new String[oldLen - 2];
            int matchItem = 0;
            for (int item = 0; item <= oldLen; item += 2) {
                if (a != charArray[item]) { 
                    charList[item] = charArray[matchItem];
                    charList[item + 1] = charArray[matchItem + 1];
                    matchItem += 2;
                }
            }
            charArray = charList;
        }

    }

    /**
     * Creates the JFrame and its UI components.
     */
    public void formGrid() {
        JFrame frame = new JFrame("Charater Matching Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new JPanel(new GridLayout(2, 4));
        p.setPreferredSize(new Dimension(500, 200));
        laycards(p);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(p, BorderLayout.CENTER);

       
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int r, c;

        if (i < 2) { 

            for (r = 0; r < 2; r++) {
                for (c = 0; c < 4; c++) {
                   
                    if ((e.getSource() == cards[r][c])
                            && cards[r][c].getText().equals("Click")) {
                      
                        cards[r][c].setText(randomChars[(r * 4 + c)]);
                        i++; 
                        if (i == 1)
                            card = (r * 4 + c); 
                        else
                            cardIndex = (r * 4 + c); 
                        return;
                    }
                }
            }
        } else { 

            for (r = 0; r < 2; r++) {
                for (c = 0; c < 4; c++) {
                   
                    if (randomChars[card].equals(randomChars[cardIndex])) {
                       
                        if (!cards[r][c].getText().equals("Click"))
                            
                            cards[r][c].setText("Match Found");
                    } else if ((!cards[r][c].getText().equals("Match Found"))
                            && (!cards[r][c].getText().equals("Click"))) {
                        
                        cards[r][c].setText("Click");
                    }
                }
                i = 0; 
            }
        }
    }
}