package observerpattern;

import javax.swing.JButton;
//import java.util.Random;

/**
 *
 * @author fuser
 */
public class Button extends JButton
{
    public Button(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;

        initButton();
    }

    // The class and function that create the Buttons
    private void initButton()
    {
        this.buttons = new JButton[this.rows][this.cols];
        int buttonName = 0;
        for(int row = 0; row < this.rows; row++)
        {
            for(int col = 0; col < this.cols; col++)
            {
                this.buttons[row][col] = new JButton(Integer.toString(buttonName));
                buttonName++;
            }
        }
    }

    public JButton[][] getButtons()
    {
        return this.buttons;
    }

    /*public int getRandomButton()
    {
        Random r = new Random();
        int randomIndex = r.nextInt(100);

        return randomIndex;
    }*/

    private JButton[][] buttons;
    private final int rows;
    private final int cols;
}
