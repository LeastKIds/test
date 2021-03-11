package project;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Panel extends JPanel{
    Execution1 ex=new Execution1();
    JPanel retryPanel=new JPanel();
    JButton retryButton, exitButton;
    JLabel lastPoint=new JLabel();
    JLabel bestPointLabel=new JLabel();


    public Panel()
    {
        retryPanel.setLayout(null);
        retryPanel.setBackground(new Color(255,255,255,200));
        retryPanel.setBounds(0,0,700,700);
        retryPanel.setVisible(false);

        JPanel retryAllPanel=new JPanel();
        retryAllPanel.setLayout(null);
        retryAllPanel.setBackground(new Color(204,254,255));
        retryAllPanel.setBounds(90,80,500,500);
        retryAllPanel.setBorder(new LineBorder(new Color(91,252,255),5,true));
        retryPanel.add(retryAllPanel);


        JLabel timeOutLabel =new JLabel("½Ã°£ ÃÊ°ú!!");
        timeOutLabel.setBounds(100,10,300,100);
        timeOutLabel.setHorizontalAlignment(JLabel.CENTER);
        timeOutLabel.setFont(new Font("°íµñ",Font.BOLD,20));
        retryAllPanel.add(timeOutLabel);

        lastPoint.setBounds(100,80,300,100);
        lastPoint.setHorizontalAlignment(JLabel.CENTER);
        lastPoint.setFont(new Font("°íµñ",Font.BOLD,20));
        retryAllPanel.add(lastPoint);


        
        bestPointLabel.setBounds(100,150,300,100);
        bestPointLabel.setHorizontalAlignment(JLabel.CENTER);
        bestPointLabel.setFont(new Font("°íµñ",Font.BOLD,20));
        retryAllPanel.add(bestPointLabel);

        ImageIcon retryButtonImage=new ImageIcon(getClass().getResource("/retry.png"));
        Image setRetryButtonImage=retryButtonImage.getImage();
        Image setSizeRetryButtonImage=setRetryButtonImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        retryButtonImage=new ImageIcon(setSizeRetryButtonImage);
        retryButton=new JButton(retryButtonImage);
        retryButton.setBounds(200,280,100,50);
        retryAllPanel.add(retryButton);
        //retryPanel.add(retryButton);

        ImageIcon titleButtonEndImage=new ImageIcon(getClass().getResource("/end.png"));
        Image setTitleButtonEndImage=titleButtonEndImage.getImage();
        Image setSizeTitleButtonEndImage=setTitleButtonEndImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
        titleButtonEndImage=new ImageIcon(setSizeTitleButtonEndImage);
        exitButton=new JButton(titleButtonEndImage);
        exitButton.setBounds(200,370,100,50);
        retryAllPanel.add(exitButton);
        //retryPanel.add(exitButton);

        
    }

    public void setLastPoint(String point)
    {
        lastPoint.setText(point);
    }
}
