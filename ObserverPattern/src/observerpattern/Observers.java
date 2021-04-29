package observerpattern;

import javax.swing.*;
import java.awt.*;

public class Observers extends JFrame implements ObserverListener
{
    public Observers()
    {
        setTitle("Observers");

        this.setLayout(new GridLayout(r,c));

        clientButton = new Button(r,c);

        for (int row = 0; row < r; row++)
        {
            for(int col = 0; col < c; col++)
            {
                add(clientButton.getButtons()[row][col]);
            }
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocation(80, 50);
        setVisible(true);
    }

    // The implementation of update()
    @Override
    public void update(String index)
    {
        int oneRow;
        int oneCol;
        System.out.println(index);
        if(Integer.parseInt(index) < 10)
        {
            /* Just trying
            clientButton.getButtons()[0][Integer.parseInt(index)].setBackground(Color.BLACK);
            clientButton.addActionListener(this);
            */
            clientButton.getButtons()[0][Integer.parseInt(index)].doClick();
        }
        else
        {
            oneRow = Integer.parseInt(index.substring(0, 1));
            oneCol = Integer.parseInt(index.substring(1, 2));

            clientButton.getButtons()[oneRow][oneCol].doClick();
        }

        /*
        For help
        System.out.println("FirstSubstring:" + Integer.parseInt(index.substring(0, 1)))
        System.out.println("SecondSubstring:" + Integer.parseInt(index.substring(1, 2)));
        */
    }

    Button clientButton;
    int r = 10;
    int c = 10;
}
