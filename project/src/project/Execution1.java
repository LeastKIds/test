package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class Execution1 extends JPanel implements ActionListener, KeyListener{

    Random rand=new Random();
    private int time=6;
    private int second=0;
    private String answer;
    private String colorAnswer;
    private int answerCheck;
    private int count=0;
    private int point=0;
    private int bestPoint=0;
    JPanel[] letterPanel=new JPanel[3];
    JButton[] actionButton=new JButton[3];
    JLabel[] actionLetter=new JLabel[3];
    JLabel pointCheck=new JLabel();
    JLabel timeCheck=new JLabel();
    JPanel subMainPanel, subMenualPanel, subRetryPanel;
    JLabel subLastPoint, subBestPointLabel;
    Container mainContentPane;
    Timer timer;
    TimerTask timerTask;


    public void randomLetterSetting(JLabel letterLabel1, JLabel letterLabel2, JLabel letterLabel3)
    {

        revalidate();
        repaint();
        ArrayList<String> randomLetter=new ArrayList<>();
        randomLetter.add("»¡°­");
        randomLetter.add("³ë¶û");
        randomLetter.add("ÆÄ¶û");
        Collections.shuffle(randomLetter);

        ArrayList<Integer> randomColor=new ArrayList<>();
        randomColor.add(0); //  0ÀÌ¸é »¡°­
        randomColor.add(1); //  1ÀÌ¸é ³ë¶û
        randomColor.add(2); //  2ÀÌ¸é ÆÄ¶û
        Collections.shuffle(randomColor);

        ArrayList<Integer> randomSize=new ArrayList<>();
        randomSize.add(20);
        randomSize.add(40);
        randomSize.add(60);
        Collections.shuffle(randomSize);

        int randomInt;
        for(int i=0; i<3; i++)
        {
            actionLetter[i].setText(randomLetter.get(i));

            switch(randomColor.get(i))
            {
                case 0 :
                actionLetter[i].setForeground(Color.RED);
                    colorAnswer="»¡°­";
                    break;
                case 1 :
                actionLetter[i].setForeground(Color.YELLOW);
                    colorAnswer="³ë¶û";
                    break;
                case 2 :
                actionLetter[i].setForeground(Color.BLUE);
                    colorAnswer="ÆÄ¶û";
                    break;
                default :
                    break;
            }

            switch(randomSize.get(i))
            {
                case 20 :
                actionLetter[i].setFont(new Font("°íµñ", Font.BOLD,20));
                    break;
                case 40 :
                actionLetter[i].setFont(new Font("°íµñ", Font.BOLD,40));
                    answer=colorAnswer;
                    break;
                case 60 :
                actionLetter[i].setFont(new Font("°íµñ", Font.BOLD,60));
                     break;
                default :
                    break;
            }

        }
        
    }

    
    public void repeat(JLabel letterLabel1, JLabel letterLabel2, JLabel letterLabel3, JButton button1, JButton button2, JButton button3)
    {
        JButton[] button=new JButton[3];
        button[0]=button1;
        button[1]=button2;
        button[2]=button3;
    
        actionButton[0]=button1;
        actionButton[1]=button2;
        actionButton[2]=button3;

        actionLetter[0]=letterLabel1;
        actionLetter[1]=letterLabel2;
        actionLetter[2]=letterLabel3;

        int checkLetter=0;
        int checkTimer=0;

        revalidate();
        repaint();
        randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
        

        //MyListener myListener=new MyListener(button1,button2,button3,answer);
            
        actionButton[0].addActionListener(this);
        actionButton[1].addActionListener(this);
        actionButton[2].addActionListener(this);
        

        

        secondTimer();
     
    }

    public void secondTimer()
    {
        second=0;
        timer=new Timer();
        timerTask=new TimerTask()
        {

			@Override
			public void run() {
            // TODO Auto-generated method stub
                
                
                second++;
                System.out.println(answer);
                timeCheck.setText(Integer.toString(time-second));
                System.out.println(second);
                if(second>=time)
                {
                    System.out.println("½Ã°£ÃÊ°ú");
                    timeCheck.setText("½Ã°£ ÃÊ°ú!!");
                    actionButton[0].setEnabled(false);
                    actionButton[1].setEnabled(false);
                    actionButton[2].setEnabled(false);
                    retryGame();
                    

                    timer.cancel();
                }

              
            }

        
        };
        timer.schedule(timerTask,0,1000);


    }

    public void retryGame()
    {
        subLastPoint.setText("ÇöÀç Á¡¼ö : " + Integer.toString(point)+"Á¡");
        if(point>bestPoint)
            bestPoint=point;
        subBestPointLabel.setText("ÃÖ°í Á¡¼ö : " + Integer.toString(bestPoint) + "Á¡");
        subRetryPanel.setVisible(true);
    }


   


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("test");
        if(e.getSource()==actionButton[0] && actionButton[0].getText().equals(answer))
        {
                System.out.println("Á¤´ä1");
                timer.cancel();
                secondTimer();
                count++;
                point++;
                pointCheck.setText(Integer.toString(point)+"Á¡");
                if(count==3)
                {
                    count=0;
                    if(time>2)
                        time-=1;
                    
                }
                revalidate();
                repaint();
                randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
            
        }
        else if(e.getSource()==actionButton[1] && actionButton[1].getText().equals(answer))
        {
            
                System.out.println("Á¤´ä2");
                timer.cancel();
                secondTimer();
                count++;
                point++;
                pointCheck.setText(Integer.toString(point));
                if(count==3)
                {
                    count=0;
                    if(time>2)
                        time-=1;
                }
                revalidate();
                repaint();
                randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
        }
        else if(e.getSource()==actionButton[2] && actionButton[2].getText().equals(answer))
        {
                timer.cancel();
                secondTimer();
                count++;
                point++;
                pointCheck.setText(Integer.toString(point));
                if(count==3)
                {
                    count=0;
                    if(time>2)
                        time-=1;
                }
                revalidate();
                repaint();
                randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
                
            
        }
        else
        {
            System.out.println("Æ²·È¾î¿ä");
            actionButton[0].setEnabled(false);
            actionButton[1].setEnabled(false);
            actionButton[2].setEnabled(false);
            retryGame();
            timer.cancel();
            
        }


    }

    public void setPanel(JPanel retryPanel, JLabel lastPoint, JLabel bestPoint)
    {
        subRetryPanel=retryPanel;
        subLastPoint=lastPoint;
        subBestPointLabel=bestPoint;

    }

    public void setContentPane(Container contentPane)
    {
        mainContentPane=contentPane;
    }

    public void setPoint(JLabel pointLabel)
    {
        pointCheck=pointLabel;
    }

    public void setQuestionTimer(JLabel questionTimer)
    {
        timeCheck=questionTimer;
    }

    public void setLetterPanel(JPanel letterPanel1, JPanel letterPanel2, JPanel letterPanel3)
    {
        letterPanel[0]=letterPanel1;
        letterPanel[1]=letterPanel2;
        letterPanel[2]=letterPanel3;
    }

    public void resetGame()
    {
        time=6;
        second=0;
        point=0;
        pointCheck.setText("0Á¡");
        randomLetterSetting(actionLetter[0], actionLetter[1], actionLetter[2]);
        secondTimer();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        letterPanel[0].setBackground(new Color(255,0,0,0));
        letterPanel[1].setBackground(new Color(255,0,0,0));
        //letterPanel[2].setBackground(new Color(255,0,0,0));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyCode()==37)
        {  
            System.out.println(e.getKeyCode());
            actionButton[0].addActionListener(this);
        }
        else if(e.getKeyCode()==38)
        {
            System.out.println(e.getKeyCode());
            actionButton[1].addActionListener(this);
        }
        else if(e.getKeyCode()==39)
        {
            System.out.println(e.getKeyCode());
            actionButton[2].addActionListener(this);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
   


}