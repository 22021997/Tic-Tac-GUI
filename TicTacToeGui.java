
package tictactoe.gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class TicTacToeGui extends JFrame implements ActionListener
{
    
    

    JButton b1,b2;
    Label ltitle;
    int flag = 0 ;
   // private Object add;
    TicTacToeGui()
    {
        setVisible(true);
        setSize(450,350);
        setLocation(300,150);
        setLayout(null);
        setTitle("Tic-Tac-Toe Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
            
        ltitle =  new Label("Welcome");
        ltitle.setForeground(Color.RED);
        ltitle.setBounds(175,50,100,20);
         Font f= new Font("Times New Roman",Font.BOLD,20);
         ltitle.setFont(f);
        add(ltitle);
        
        b1 = new JButton("Start");
        b2 = new JButton("End");
        b1.setBounds(170,100,80,50);
        b2.setBounds(170,200,80,50);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {   //flag=1;
                JOptionPane.showMessageDialog(null,"The game begins");
                Game o1 = new Game();
                
            }
        }
        );
         
      
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null,"Are You Sure");
                System.exit(0);
            }
        }
        );
      
        
        add(b1);
        add(b2);
        
    }
    
   
    
    
    
    public static void main(String[] args)
    {
       TicTacToeGui obj = new TicTacToeGui();    // TODO code application logic here
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
