
package tictactoe.gui;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
public class Game extends JFrame implements ActionListener
{   
    Label title1;
   
    public static boolean Player1_turn = false; 
   // public static boolean Player2_turn = false; 
    public static boolean CPU_turn = false; 
    String u1,u2;
    
    public JTextField txt = new JTextField("OUTPUT BOX");
    Font f = new Font("Courier", Font.BOLD,32);
    
    
    private JButton b1,b2,b3,b4,be;
   private JButton i1,i2,i3,i4,i5,i6,i7,i8,i9;
    //JPanel controlpanel; 
    public Game()
    {
     
       
     GUI();  
       
    }
   //  public int check;
    private void GUI()
    {   
        
        
       //int check=0;
       String U1 = "User1";
       String U2 = "User2";
       
       JPanel p2 =  new JPanel(new GridLayout(5,1,5,35));
       
       
       JPanel p1 = new JPanel(new BorderLayout());
       BorderLayout layout = new BorderLayout();
       
       
       
       txt.setPreferredSize(new Dimension(110,110));
       //txt.setBounds(500,500,110,110);
       
       p1.add(txt,BorderLayout.SOUTH);
       //p1.setSize(200,200);
       //private void get_U1()
       
           
       
       b1 = new JButton(U1+ " Vs " + U2);
      b1.setBackground(Color.PINK);
       b1.addActionListener(new ActionListener()
           {
               
               public void actionPerformed(ActionEvent e)
               {    //check=1;
                   //String u1="";
                    
                   
                 u1=JOptionPane.showInputDialog("Enter the name");
                 
                 
                 //text1();
                 Reset();
                 if(u1.equals(""))
                 {
                  u1=JOptionPane.showInputDialog("Enter a valid name");   
                 }
                 u2 = JOptionPane.showInputDialog("Enter a valid name");
                 if(u2.equals(""))
                 {
                     u2=JOptionPane.showInputDialog("Enter the name again");
                 }
                 txt.setFont(f);
                 
                   //u1=txt.getText();
                   //u2=txt.getText();
                   UvsU(u1);
                    
                  //The_Grid();
               }
               //UvsU();
           }
       );
        //if(check == 1)
         
        // UvsU();
         
       b2 = new JButton("User Vs CPU");
       b2.setBackground(Color.PINK);
       b2.addActionListener(new ActionListener()
           {
                
               public void actionPerformed(ActionEvent e)
               {    Reset();
                u1=JOptionPane.showInputDialog("Enter the name");
                if(u1.equals(""))
                {
                    u1 = JOptionPane.showInputDialog("Enter a valid");
                }
                
                    txt.setFont(f);
                    txt.setText(u1+ " turn");
                   UvsCPU();
                   
               }
           }
       );
       b3 = new JButton("AI Vs CPU");
       b3.setBackground(Color.PINK);
       b3.addActionListener(new ActionListener()
           {
                
               public void actionPerformed(ActionEvent e)
               {
                   Reset(); 
                   u1="AI";
                   u2="CPU";
                   
                   AvsCPU();
                   
               }
           }
       );
       b4 = new JButton("User Vs AI");
       b4.setBackground(Color.PINK);
       b4.addActionListener(new ActionListener()
           {
                
               public void actionPerformed(ActionEvent e)
               {
                   
                   Reset();
                    u1=JOptionPane.showInputDialog("Enter the name");
                if(u1.equals(""))
                {
                    u1 = JOptionPane.showInputDialog("Enter a valid");
                }
                u2="AI";
                txt.setFont(f);
                txt.setText(u1+ " turn");
                   UvsCPU();
                   
                   
               }
           }
       );
       be = new JButton("Exit");
       //b1.setBounds(50,50,110,35);
       b2.setBounds(50,110,110,35);
       b3.setBounds(50,180,110,35);
       b4.setBounds(50,240,110,35);
        be.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txt.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               JOptionPane.showMessageDialog(null,"Are You Sure");
                System.exit(0);
           }
       }
       );
     
       //add(b1,BorderLayout.WEST);
       p2.add(b1);
       p2.add(b2);
       p2.add(b3);
       p2.add(b4);
       p2.add(be);
       
       setVisible(true);
        setSize(700,450);
        setLocation(300,150);
        setLayout(new GridLayout(1,5,17,17));
        setTitle("Tic-Tac-Toe Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
       
        
        add(p2);
        The_Grid(); 
        //add(XO);
        add(p1);
        
        //System.out.println(check);
       
      
       //add(b3);
       //add(b4);
       
       
     
    
    }
    
    
   
    
    
    private void  The_Grid()
    {
        i1 = new JButton("");
        i1.setBackground(Color.WHITE);
        i2 = new JButton("");i2.setBackground(Color.WHITE);
        i3 = new JButton("");i3.setBackground(Color.WHITE);
        i4 = new JButton("");i4.setBackground(Color.WHITE);
        i5 = new JButton("");i5.setBackground(Color.WHITE);
        i6 = new JButton("");i6.setBackground(Color.WHITE);
        i7 = new JButton("");i7.setBackground(Color.WHITE);
        i8 = new JButton("");i8.setBackground(Color.WHITE);
        i9 = new JButton("");i9.setBackground(Color.WHITE);
        
        JPanel XO = new JPanel(new GridLayout(3,3));
        XO.add(i1);
        XO.add(i2);
        XO.add(i3);
        XO.add(i4);
        XO.add(i5);
        XO.add(i6);
        XO.add(i7);
        XO.add(i8);
        XO.add(i9);
        add(XO);
    }
   
    public void i1actionPerformed(ActionEvent e)
    {
        if(i1.getText().equals(""))
        {
            if(Player1_turn == false)
            {
                txt.setText("");
                txt.setText(u2+"Turn");
                i1.setText("X");
                Player1_turn = true;
                check_for_win();
                       
                
                

            }
            else
            {   txt.setText(u1 +"Turn");
                i1.setText("O");
                Player1_turn = false;;
                check_for_win();
            }
        }
    }
    private void Reset()
    {
        txt.setText("Output Box");
        i1.setText("");
        i1.setBackground(Color.WHITE);
        i2.setText("");i2.setBackground(Color.WHITE);
        i3.setText("");i3.setBackground(Color.WHITE);
        i4.setText("");i4.setBackground(Color.WHITE);
        i5.setText("");i5.setBackground(Color.WHITE);
        i6.setText("");i6.setBackground(Color.WHITE);
        i7.setText("");i7.setBackground(Color.WHITE);
        i8.setText("");i8.setBackground(Color.WHITE);
        i9.setText(""); i9.setBackground(Color.WHITE);
    }
     public void i2actionPerformed(ActionEvent e)
    {
        if(i2.getText().equals(""))
        {
            if(Player1_turn == false)
            {
                txt.setText("");
                txt.setText(u2 +"Turn");
                i2.setText("X");
                Player1_turn = true;
                check_for_win();
            }
            else
            {
                txt.setText(u1 +"Turn");
                i2.setText("O");
                Player1_turn = false;
                check_for_win();
            }
        }
    }
     public void i3actionPerformed(ActionEvent e)
    {
        if(i3.getText().equals(""))
        {
            if(Player1_turn == false)
            {
                txt.setText(u2 +"Turn");
                i3.setText("X");
                Player1_turn = true;
                check_for_win();
            }
            else
            {
             txt.setText(u1 +"Turn");
                i3.setText("O");
                Player1_turn = false;
                check_for_win();
            }
        }
    }
      public void i4actionPerformed(ActionEvent e)
    {
        if(i4.getText().equals(""))
        {
            if(Player1_turn == false)
             {
                 //txt.setText("");
                 txt.setText(u2 +"Turn");
                i4.setText("X");
                Player1_turn = true;
                check_for_win();
            }
            else
            {
                txt.setText(u1 +"Turn");
               // txt.setText("");
                //txt.setText("seond");
                i4.setText("O");
                Player1_turn = false;
                check_for_win();
            }
        }
    }
      
       public void i5actionPerformed(ActionEvent e)
    {
        if(i5.getText().equals(""))
        {
            if(Player1_turn == false)
            {
                txt.setText(u2 +" Turn");
                i5.setText("X");
                Player1_turn = true;
                check_for_win();
            }
            else
            {
                txt.setText(u1 +" Turn");
                i5.setText("O");
                Player1_turn = false;
                check_for_win();
            }
        }
    }
       
        public void i6actionPerformed(ActionEvent e)
    {
        if(i6.getText().equals(""))
        {
            if(Player1_turn == false)
            {
                txt.setText(u2 +" Turn");
                i6.setText("X");
                Player1_turn = true;
                check_for_win();
            }
            else
            {
               txt.setText(u1 +" Turn");
                i6.setText("O");
                Player1_turn = false;
                check_for_win();
            }
        }
    }
    public void i7actionPerformed(ActionEvent e)
    {
        if(i7.getText().equals(""))
        {
            if(Player1_turn == false)
            {
                txt.setText(u2 +" Turn");
                i7.setText("X");
                Player1_turn = true;
                check_for_win();
            }
            else
            {
             txt.setText(u1 +" Turn");
                i7.setText("O");
                
                Player1_turn = false;
                check_for_win();
            }
        }
    }
    public void i8actionPerformed(ActionEvent e)
    {
        if(i8.getText().equals(""))
        {
            if(Player1_turn == false)
            {
                txt.setText(u2 +" Turn");
                i8.setText("X");
                Player1_turn = true;
                check_for_win();
            }
            else
            {
                txt.setText(u1 +" Turn");
                i8.setText("O");
                Player1_turn = false;
                check_for_win();
            }
        }
    }
    public void i9actionPerformed(ActionEvent e)
    {
        if(i9.getText().equals(""))
        {
            if(Player1_turn == false)
            {
             txt.setText(u2 +" Turn");
                i9.setText("X");
                Player1_turn = true;
                check_for_win();
            }
            else
            {
                txt.setText(u1 +" Turn");
                i9.setText("O");
                Player1_turn = false;
                check_for_win();            }
        }
    }
    
    
    
     void  UvsU(String a)
    {   
        
        txt.setText(u1+" turn");
         i1.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               //txt.setText("First Players");
                i1actionPerformed(e);
               // txt.setText("First Players Turn");
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
         
          i2.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i2actionPerformed(e);
              //     txt.setText("First Players Turn");
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
           i3.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i3actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
           
            i4.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i4actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
             i5.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i5actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
             
              i6.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i6actionPerformed(e);
                
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
              
              i7.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i7actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
              i8.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i8actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
              
              i9.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i9actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
              
              
    }
     public int flag=0;
     void l()
     {
         if(flag == 1)
         {
             Reset();
         }
         else
         {
             
         }
     }
       public void check_for_win()
       {    flag=0;
           if(i1.getText().equals("X") && i2.getText().equals("X") && i3.getText().equals("X"))
           {
               i1.setBackground(Color.MAGENTA);i1.setOpaque(true);i1.setForeground(Color.ORANGE);
               
               i2.setBackground(Color.MAGENTA);i2.setOpaque(true);i2.setForeground(Color.ORANGE);
               i3.setBackground(Color.MAGENTA);i3.setOpaque(true);i3.setForeground(Color.ORANGE);
               //System.exit(0);
               flag++;
               txt.setText(u1 + "  wins");
              
           
          // txt.setText("Player1 one wins");
           }
              
           else if(i1.getText().equals("X") && i4.getText().equals("X") && i7.getText().equals("X"))
           {
               i1.setBackground(Color.MAGENTA);i1.setOpaque(true);i1.setForeground(Color.ORANGE);
               
               i4.setBackground(Color.MAGENTA);i4.setOpaque(true);i4.setForeground(Color.ORANGE);
               i7.setBackground(Color.MAGENTA);i7.setOpaque(true);i7.setForeground(Color.ORANGE);
               txt.setText(u1 + " wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i1.getText().equals("X") && i5.getText().equals("X") && i9.getText().equals("X"))
           {
               i1.setBackground(Color.MAGENTA);i1.setOpaque(true);i1.setForeground(Color.ORANGE);
               
               i5.setBackground(Color.MAGENTA);i5.setOpaque(true);i5.setForeground(Color.ORANGE);
               i9.setBackground(Color.MAGENTA);i9.setOpaque(true);i9.setForeground(Color.ORANGE);
               txt.setText(u1 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i3.getText().equals("X") && i5.getText().equals("X") && i7.getText().equals("X"))
           {
               i3.setBackground(Color.MAGENTA);i3.setOpaque(true);i3.setForeground(Color.ORANGE);
               
               i5.setBackground(Color.MAGENTA);i5.setOpaque(true);i5.setForeground(Color.ORANGE);
               i7.setBackground(Color.MAGENTA);i7.setOpaque(true);i7.setForeground(Color.ORANGE);
               txt.setText(u1 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i4.getText().equals("X") && i5.getText().equals("X") && i6.getText().equals("X"))
           {
               i4.setBackground(Color.MAGENTA);i4.setOpaque(true);i4.setForeground(Color.ORANGE);
               
               i5.setBackground(Color.MAGENTA);i5.setOpaque(true);i5.setForeground(Color.ORANGE);
               i6.setBackground(Color.MAGENTA);i6.setOpaque(true);i6.setForeground(Color.ORANGE);
               txt.setText(u1 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i7.getText().equals("X") && i8.getText().equals("X") && i9.getText().equals("X"))
           {
               i7.setBackground(Color.MAGENTA);i7.setOpaque(true);i7.setForeground(Color.ORANGE);
               
               i8.setBackground(Color.MAGENTA);i8.setOpaque(true);i8.setForeground(Color.ORANGE);
               i9.setBackground(Color.MAGENTA);i9.setOpaque(true);i9.setForeground(Color.ORANGE);
               txt.setText(u1 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i2.getText().equals("X") && i5.getText().equals("X") && i8.getText().equals("X"))
           {
               i2.setBackground(Color.MAGENTA);i2.setOpaque(true);i2.setForeground(Color.ORANGE);
               
               i5.setBackground(Color.MAGENTA);i5.setOpaque(true);i5.setForeground(Color.ORANGE);
               i8.setBackground(Color.MAGENTA);i8.setOpaque(true);i8.setForeground(Color.ORANGE);
               txt.setText(u1 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i3.getText().equals("X") && i6.getText().equals("X") && i9.getText().equals("X"))
           {
               i3.setBackground(Color.MAGENTA);i3.setOpaque(true);i3.setForeground(Color.ORANGE);
               i6.setBackground(Color.MAGENTA);i6.setOpaque(true);i6.setForeground(Color.ORANGE);
               i9.setBackground(Color.MAGENTA);i9.setOpaque(true);i9.setForeground(Color.ORANGE);
               txt.setText(u1 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i1.getText().equals("O") && i2.getText().equals("O") && i3.getText().equals("O"))
           {
               i1.setBackground(Color.MAGENTA);i1.setOpaque(true);i1.setForeground(Color.ORANGE);
               
               i2.setBackground(Color.MAGENTA);i2.setOpaque(true);i2.setForeground(Color.ORANGE);
               i3.setBackground(Color.MAGENTA);i3.setOpaque(true);i3.setForeground(Color.ORANGE);
               txt.setText(u2 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i1.getText().equals("O") && i4.getText().equals("O") && i7.getText().equals("O"))
           {
               i1.setBackground(Color.MAGENTA);i1.setOpaque(true);i1.setForeground(Color.ORANGE);
               
               i4.setBackground(Color.MAGENTA);i4.setOpaque(true);i4.setForeground(Color.ORANGE);
               i7.setBackground(Color.MAGENTA);i7.setOpaque(true);i7.setForeground(Color.ORANGE);
               txt.setText(u2 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i1.getText().equals("O") && i5.getText().equals("O") && i9.getText().equals("O"))
           {
               i1.setBackground(Color.MAGENTA);i1.setOpaque(true);i1.setForeground(Color.ORANGE);
               
               i5.setBackground(Color.MAGENTA);i5.setOpaque(true);i5.setForeground(Color.ORANGE);
               i9.setBackground(Color.MAGENTA);i9.setOpaque(true);i9.setForeground(Color.ORANGE);
               txt.setText(u2 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i3.getText().equals("O") && i5.getText().equals("O") && i7.getText().equals("O"))
           {
               i3.setBackground(Color.MAGENTA);i3.setOpaque(true);i3.setForeground(Color.ORANGE);
               
               i5.setBackground(Color.MAGENTA);i5.setOpaque(true);i5.setForeground(Color.ORANGE);
               i7.setBackground(Color.MAGENTA);i7.setOpaque(true);i7.setForeground(Color.ORANGE);
               txt.setText(u2 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i4.getText().equals("O") && i5.getText().equals("O") && i6.getText().equals("O"))
           {
               i4.setBackground(Color.MAGENTA);i4.setOpaque(true);i4.setForeground(Color.ORANGE);
               
               i5.setBackground(Color.MAGENTA);i5.setOpaque(true);i5.setForeground(Color.ORANGE);
               i6.setBackground(Color.MAGENTA);i6.setOpaque(true);i6.setForeground(Color.ORANGE);
               txt.setText(u2 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i7.getText().equals("O") && i8.getText().equals("O") && i9.getText().equals("O"))
           {
               i7.setBackground(Color.MAGENTA);i7.setOpaque(true);i7.setForeground(Color.ORANGE);
               
               i8.setBackground(Color.MAGENTA);i8.setOpaque(true);i8.setForeground(Color.ORANGE);
               i9.setBackground(Color.MAGENTA);i9.setOpaque(true);i9.setForeground(Color.ORANGE);
               txt.setText(u2 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i2.getText().equals("O") && i5.getText().equals("O") && i8.getText().equals("O"))
           {
               i2.setBackground(Color.MAGENTA);i2.setOpaque(true);i2.setForeground(Color.ORANGE);
               
               i5.setBackground(Color.MAGENTA);i5.setOpaque(true);i5.setForeground(Color.ORANGE);
               i8.setBackground(Color.MAGENTA);i8.setOpaque(true);i8.setForeground(Color.ORANGE);
               txt.setText(u2 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
           else if(i3.getText().equals("O") && i6.getText().equals("O") && i9.getText().equals("O"))
           {
               i3.setBackground(Color.MAGENTA);i3.setOpaque(true);i3.setForeground(Color.ORANGE);
               i6.setBackground(Color.MAGENTA);i6.setOpaque(true);i6.setForeground(Color.ORANGE);
               i9.setBackground(Color.MAGENTA);i9.setOpaque(true);i9.setForeground(Color.ORANGE);
               txt.setText(u2 + "  wins");
              // txt.setText("Player1 one wins");
               
           }
          // l();
             // Reset();
           
       }
       
       public void i11actionPerformed(ActionEvent e)
       {
           if(i1.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i1.setText("X");
                   
                   check_for_win();
                   random_gen();
                   check_for_win();
                   
               
           }
       }
       
        public void i22actionPerformed(ActionEvent e)
       {
           if(i2.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i2.setText("X");
                   check_for_win();
                  random_gen();
                    check_for_win();
           }
       }
        
         public void i33actionPerformed(ActionEvent e)
       {
           if(i3.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i3.setText("X");
                   check_for_win();
                   random_gen();
                   check_for_win();
                   
               
           }
       }
         
            public void i44actionPerformed(ActionEvent e)
       {
           if(i4.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i4.setText("X");
                   check_for_win();
                   random_gen();
                   check_for_win();
                   
               
           }
       }
               public void i55actionPerformed(ActionEvent e)
       {
           if(i5.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i5.setText("X");
                   check_for_win();
                   random_gen();
                   check_for_win();
                   
               
           }
       }
                  public void i66actionPerformed(ActionEvent e)
       {
           if(i6.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i6.setText("X");
                   check_for_win();
                   random_gen();
                   check_for_win();
                   
               
           }
       }
       
        public void i77actionPerformed(ActionEvent e)
       {
           if(i7.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i7.setText("X");
                   check_for_win();
                   random_gen();
                   check_for_win();
                   
               
           }
       }
            public void i88actionPerformed(ActionEvent e)
       {
           if(i8.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i8.setText("X");
                   check_for_win();
                   random_gen();
                   check_for_win();
                   
               
           }
       }
        public void i99actionPerformed(ActionEvent e)
       {
           if(i9.getText().equals(""))
           {
           
               //if(Player1_turn == false)
               
                   i9.setText("X");
                   check_for_win();
                   random_gen();
                   check_for_win();
                   
               
           }
       }
       
       
       
       void random_gen()
       {
           Random rn =  new Random();
           int ans =0;
           int t=1;
           int flag=0;
           while(t==1)
           {
               ans = rn.nextInt(9)+1;
               
               if(ans == 1 && i1.getText().equals(""))
               {
                   i1.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
               
               else if(ans == 2 && i2.getText().equals(""))
               {
                   i2.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
               else if(ans ==3 && i3.getText().equals(""))
               {
                   i3.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
               else if(ans == 4 && i4.getText().equals(""))
               {
                   i4.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
               else if(ans == 5 && i5.getText().equals(""))
               {
                   i5.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
               else if(ans == 6 && i6.getText().equals(""))
               {
                   i6.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
               else if(ans == 7 && i7.getText().equals(""))
               {
                   i7.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
               else if(ans == 8 && i8.getText().equals(""))
               {
                   i8.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
               else if(ans == 9 && i9.getText().equals(""))
               {
                   i9.setText("O");
                   txt.setText(u1+ " Turn");
                   flag++;
                   t=0;
               }
              
               //else if(flag>3)
               
                   //t=0;
                   //break;
                   
               
               
               
           }
           
           //return ans ;
       }
      
      /* void Check_Draw()
       {
           
           if(!i1.getText().equals(""))
           {
               flag++;
           }
           else if(!i2.getText().equals(""))
           {
               flag++;
           }
           else if(!i3.getText().equals(""))
           {
               flag++;
           }
           else if(!i4.getText().equals(""))
           {
               flag++;
           }
       
       }
*/

       void UvsCPU()
       {
           
           
           i1.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i11actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
         
          i2.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i22actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
           i3.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i33actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
           
            i4.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i44actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
             i5.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i55actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
             
              i6.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i66actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
              
              i7.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i77actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
              i8.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i88actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
              
              i9.addActionListener(new ActionListener()
       {
           //JTextField txt = new JTextField();
           //txwhot.setBounds(90,40,10,35);
           public void actionPerformed(ActionEvent e)
           {
               
                i99actionPerformed(e);
                   
                   //i1.setText("X"+click);
                   
               
           }
       }
       );
              
              
       }
       
       void AvsCPU()
       {
           i1.setText("X");
           random_gen();
           if(i2.getText().equals(""))
           {
               i2.setText("X");
               random_gen();
               if(i3.getText().equals(""))
               {
                   i3.setText("X");
                   check_for_win();
                   
               }
               else
               {    random_gen();
                   i5.setText("X");
                   random_gen();
                   if(i9.getText().equals(""))
                   {
                       i9.setText("X");
                       check_for_win();
                   }
               }
           }
           else{
               i4.setText("X");
               random_gen();
               if(i7.getText().equals(""))
               {
                   i7.setText("X");
                   check_for_win();
               }
               else
               {
                   random_gen();
                   i5.setText("X");
                   random_gen();
                   if(i6.getText().equals(""))
                   {
                       i6.setText("X");
                       check_for_win();
                   }
                   
               }
                       
           }
       }
    
    public static void main(String args[])
    {
        Game obj = new Game();
       // obj.borderlayout();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

