package observerpattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Subject extends JFrame implements ActionListener
{
    public Subject()
    {
        // Dialog to input how many observers you want
        String num = JOptionPane.showInputDialog("How many observers do you want?(By default it's 2)", "2");

        // Loop for the number of Observers frame
        for (int i = 0; i < Integer.parseInt(num); i++)
        {
            Observers observer = new Observers();
            observer.setVisible(true);
            mListeners.add(observer);
        }

        setTitle("Server");

        this.setLayout(new GridLayout(r,c));

        serverButton = new Button(r,c);

        for (int row = 0; row < r; row++)
        {
            for(int col = 0; col < c; col++)
            {
                add(serverButton.getButtons()[row][col]);
                serverButton.getButtons()[row][col].addActionListener(this);
            }
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,450);
        setLocation(800,50);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        int index = Integer.parseInt(e.getActionCommand());
        //System.out.println(index);

        for (int row = 0; row < r; row++)
        {
            for(int col = 0; col < c; col++)
            {
                if(e.getSource() == serverButton.getButtons()[row][col] )
                {
                    for(ObserverListener clientListener: mListeners)
                    {
                        clientListener.update(Integer.toString(index));
                    }
                }
            }
        }
    }

    // Basic interface for the update (could be made here).
    /*public interface ObserverListener
    {
        void update(String index);
    }*/

    private final ArrayList<ObserverListener> mListeners = new ArrayList<>();
    private final int r = 10;
    private final int c = 10;
    private final Button serverButton;
}
