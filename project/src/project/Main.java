package project;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;

 public class Main extends JFrame implements ActionListener{
    private JPanel startPanel, mainPanel, menualPanel;
    JButton startButton, endButton,menualButton;
    JButton button1,button2,button3;
    JLabel letterLabel1, letterLabel2, letterLabel3, pointLabel,questionTimer;
    JPanel letterPanel1,letterPanel2,letterPanel3;
    Container contentPane=getContentPane();
    ImageIcon mainIcon;

    Execution1 ex=new Execution1();
    Panel rt=new Panel();


    public Main()
    {
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ColorSet");
        this.setResizable(false);
        this.setLayout(null);
        

        //  시작 페이지-------------------------------------------------------
        startPanel=new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);

                g.drawImage(mainIcon.getImage(),0,0,null);
            }
        };
        startPanel.setLayout(null);
        startPanel.setBounds(0,0,700,700);
        startPanel.setBackground(new Color(236,230,204));

        //메인 이미지
        mainIcon=new ImageIcon(getClass().getResource("/nin.png"));
        Image mainImg=mainIcon.getImage();
        Image setImage=mainImg.getScaledInstance(685,660,Image.SCALE_SMOOTH);
        mainIcon=new ImageIcon(setImage);
        
        //--------------------------------------------------------

        
        //                        //  ------------> 제목 위치
        // titleLabel1.setHorizontalAlignment(SwingConstants.CENTER);                       // ------------->   제목 배경
        // titleLabel1.setFont(new Font("고딕", Font.BOLD,30));        // ------------->   제목 글자 색, 크기 결정
        ImageIcon titleImage=new ImageIcon(getClass().getResource("/nin2.png"));
        Image setTitleImage=titleImage.getImage();
        Image setSizeTitleImage=setTitleImage.getScaledInstance(220, 70, Image.SCALE_SMOOTH);
        titleImage=new ImageIcon(setSizeTitleImage);
        JLabel titleLabel1=new JLabel(titleImage);
        titleLabel1.setBounds(75, 140,220, 70);

        ImageIcon titleNameImage=new ImageIcon(getClass().getResource("/nin1.png"));
        Image setTitleNameImage=titleNameImage.getImage();
        Image setSizeTitleNameImage=setTitleNameImage.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        titleNameImage=new ImageIcon(setSizeTitleNameImage);
        JLabel titleLabel2=new JLabel(titleNameImage);
        titleLabel2.setBounds(80,250,200, 100);
        startPanel.add(titleLabel2);

        JLabel titleLabel3=new JLabel("색깔 맞추기");
        titleLabel3.setFont(new Font("고딕",Font.BOLD,30));
        titleLabel3.setBounds(110,400,200,50);
        startPanel.add(titleLabel3);


        ImageIcon titleButtonImage=new ImageIcon(getClass().getResource("/start.png"));
        Image setTitleButtonImage=titleButtonImage.getImage();
        Image setSizeTitleButtonImage=setTitleButtonImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        titleButtonImage=new ImageIcon(setSizeTitleButtonImage);
        startButton=new JButton(titleButtonImage);
        startButton.setBounds(465,250,100,50);
        startButton.setFocusable(false);

        ImageIcon titleButtonEndImage=new ImageIcon(getClass().getResource("/end.png"));
        Image setTitleButtonEndImage=titleButtonEndImage.getImage();
        Image setSizeTitleButtonEndImage=setTitleButtonEndImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        titleButtonEndImage=new ImageIcon(setSizeTitleButtonEndImage);
        endButton=new JButton(titleButtonEndImage);
        endButton.setBounds(465,350,100,50);
        endButton.setFocusable(false);
        startPanel.add(endButton);

        endButton.addActionListener(this);


        //  게임 설명 화면---------------------------------------------------
        menualPanel=new JPanel();
        menualPanel.setLayout(null);
        menualPanel.setBackground(new Color(255,255,255,200));
        menualPanel.setBounds(0,0,700,700);

        JPanel expaineAllPanel=new JPanel();
        expaineAllPanel.setLayout(null);
        expaineAllPanel.setBackground(new Color(204,254,255));
        expaineAllPanel.setBounds(90,80,500,500);
        expaineAllPanel.setBorder(new LineBorder(new Color(91,252,255),5,true));
        menualPanel.add(expaineAllPanel);

        JLabel explaineLabel=new JLabel("게임 설명");
        explaineLabel.setBounds(130,10,250,80);
        explaineLabel.setHorizontalAlignment(SwingConstants.CENTER);
        explaineLabel.setFont(new Font("고딕", Font.BOLD, 40));
        explaineLabel.setBorder(new LineBorder(Color.WHITE,5,true));
        expaineAllPanel.add(explaineLabel);

        ImageIcon gameMenualImage=new ImageIcon(getClass().getResource("/setting.png"));
        Image setGameMenualImage=gameMenualImage.getImage();
        Image setSizeGameMenualImage=setGameMenualImage.getScaledInstance(400, 200 , Image.SCALE_SMOOTH);
        gameMenualImage=new ImageIcon(setSizeGameMenualImage);
        JLabel gameMenualImageLabel=new JLabel(gameMenualImage);
        gameMenualImageLabel.setBounds(50,120,400,200);
        expaineAllPanel.add(gameMenualImageLabel);


        
        JLabel menualLabel=new JLabel();
        menualLabel.setText("크기가 중간인 글자의 색을 찾아 누르세요");
        menualLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menualLabel.setBounds(50,330,400,80);
        menualLabel.setBorder(new LineBorder(Color.WHITE,5,true));
        menualLabel.setFont(new Font("고딕",Font.BOLD,20));
        menualLabel.setBackground(new Color(204,204,204));
        expaineAllPanel.add(menualLabel);

        ImageIcon menuCloseButtonImage=new ImageIcon(getClass().getResource("/close.png"));
        Image setMenuCloseButtonImage=menuCloseButtonImage.getImage();
        Image setSizeMenuCloseButtonImage=setMenuCloseButtonImage.getScaledInstance(100,50,Image.SCALE_SMOOTH);
        menuCloseButtonImage=new ImageIcon(setSizeMenuCloseButtonImage);
        menualButton=new JButton(menuCloseButtonImage);
        menualButton.setBounds(200,420,100,50);
        menualButton.setFocusable(false);
        expaineAllPanel.add(menualButton);


        // menualPanel.add(menualLabel);
        // menualPanel.add(explaineLabel);
        // menualPanel.add(menualButton);
        //menualPanel.add(menualButtonFrame);


        //  게임 화면--------------------------------------------------------
        mainPanel=new JPanel()
        {
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);

                g.drawImage(mainIcon.getImage(),0,0,null);
            }
        };
        mainPanel.setLayout(null);
        mainPanel.setBounds(0,0,700,700);
        //mainPanel.setBackground(Color.WHITE);           //  -------------------------> 메인 페널 색
        mainPanel.add(menualPanel);
        //mainPanel.setVisible(false);

                //  점수판
        JPanel pointPanel=new JPanel();
        pointPanel.setLayout(null);
        pointPanel.setBounds(0,0,686,100);
        pointPanel.setBackground(new Color(204,255,255));           //  --------------------------> 점수 패널 색
        pointPanel.setBorder(new LineBorder(Color.black, 5, true));
        JLabel pointTextLabel=new JLabel("점수");
        // pointTextLabel.setBounds(0,0,700,50);
        // pointTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // pointTextLabel.setFont(new Font("고딕", Font.BOLD,20));
        pointLabel=new JLabel();
        pointLabel.setBounds(0,25,350,50);
        pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pointLabel.setFont(new Font("고딕", Font.BOLD, 20));
        pointLabel.setText("0점");                 // ----------------------------> 점수 여기다 추가

        questionTimer=new JLabel();
        questionTimer.setBounds(350,25,350,50);
        questionTimer.setHorizontalAlignment(JLabel.CENTER);
        questionTimer.setFont(new Font("고딕", Font.BOLD, 20));
        questionTimer.setText("째깍째깎");

        pointPanel.add(pointTextLabel);
        pointPanel.add(pointLabel);
        pointPanel.add(questionTimer);
        //pointPanel.setVisible(false);

                // 문제 판
        JPanel questionPanel=new JPanel();
        questionPanel.setLayout(null);
        questionPanel.setBounds(50,105,255,450);
        questionPanel.setBackground(new Color(255,255,255,200));
        

        letterPanel1=new JPanel();
        letterPanel1.setLayout(new BorderLayout());
        letterPanel1.setBounds(70,20,130,100);
        letterPanel1.setBackground(Color.white);

        letterLabel1=new JLabel("글자");
        letterLabel1.setHorizontalAlignment(JLabel.CENTER);
        letterPanel1.add(letterLabel1);


        letterPanel2=new JPanel();
        letterPanel2.setBounds(70,140,130,100);
        letterPanel2.setBackground(Color.white);
        letterPanel2.setLayout(new BorderLayout());

        letterLabel2=new JLabel("글자");
        letterLabel2.setHorizontalAlignment(JLabel.CENTER);
        letterPanel2.add(letterLabel2);

        letterPanel3=new JPanel();
        letterPanel3.setBounds(70,270,130,100);
        letterPanel3.setBackground(Color.white);
        letterPanel3.setLayout(new BorderLayout());

        letterLabel3=new JLabel("글자");
        letterLabel3.setHorizontalAlignment(JLabel.CENTER);
        letterPanel3.add(letterLabel3);


        questionPanel.add(letterPanel1);
        questionPanel.add(letterPanel2);
        questionPanel.add(letterPanel3);



        //  버튼
        JPanel answerPanel=new JPanel();
        answerPanel.setLayout(null);
        answerPanel.setBounds(385,150,250,360);
        answerPanel.setBackground(new Color(255,255,255,200));

        button1=new JButton("빨강");
        button1.setBounds(80,50,100,50);
        button1.setFocusable(false);
        button1.setEnabled(false);
        button2=new JButton("노랑");
        button2.setBounds(80,160,100,50);
        button2.setFocusable(false);
        button2.setEnabled(false);
        button3=new JButton("파랑");
        button3.setBounds(80,270,100,50);
        button3.setFocusable(false);
        button3.setEnabled(false);
        answerPanel.add(button1);
        answerPanel.add(button2);
        answerPanel.add(button3);
        
        //answerPanel.setVisible(false);
        

        //  패널에 추가 하고 숨기고 ------------------------------------------------------



        mainPanel.add(answerPanel);
        mainPanel.add(questionPanel);
        mainPanel.add(pointPanel);


        //  패널 추가---------------------------------------------------------
        startPanel.add(titleLabel1);
        startPanel.add(startButton);
        this.add(startPanel);
        //this.add(mainPanel);
        this.add(rt.retryPanel);
        
        //  시작 버튼 누를 시 --------------------------------------------
        startButton.addActionListener(this);
        //  메뉴 닫기 버튼 루를 시----------------------------------------
        menualButton.addActionListener(this);
        // 다시 시작 버튼 누를 시 ----------------------------------------
        rt.retryButton.addActionListener(this);
        // 끝내기 버튼 누를 시 -------------------------------------------
        rt.exitButton.addActionListener(this);
        

        
        

        this.setVisible(true);


    }

    
    

    public static void main(String[] args)
    {
        JFrame frame=new Main();
        System.out.println(System.getProperty("user.dir"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==startButton)
        {
            contentPane.remove(startPanel);
            contentPane.add(mainPanel);

            contentPane.revalidate();
            contentPane.repaint();
        }
        else if(e.getSource()==menualButton)
        {
            menualPanel.setVisible(false);
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            contentPane.revalidate();
            contentPane.repaint();

            ex.repeat(letterLabel1, letterLabel2, letterLabel3,button1,button2,button3);
            ex.setPoint(pointLabel);
            ex.setQuestionTimer(questionTimer);
            ex.setPanel(rt.retryPanel,rt.lastPoint,rt.bestPointLabel);
            ex.setContentPane(contentPane);
            ex.setLetterPanel(letterPanel1,letterPanel2,letterPanel3);
            mainPanel.addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyPressed(KeyEvent e)
                {
                    if(e.getKeyCode()==37)
                    {
                        System.out.println("왼쪽");
                    }
                    else if(e.getKeyCode()==38)
                    {
                        System.out.println("위쪽");
                    }
                    else if(e.getKeyCode()==39)
                    {
                        System.out.println("오른쪽");
                    }
                }
            });
            
        }
        else if(e.getSource()==rt.retryButton)
        {
            System.out.println("retry");
            rt.retryPanel.setVisible(false);
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            ex.resetGame();

        }
        else if(e.getSource()==rt.exitButton || e.getSource()==endButton)
        {
            System.out.println("exit");
            System.exit(0);
        }

    }

    
}
