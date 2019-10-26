package com.ccnu.nercel.listener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ccnu.nercel.ui.Paint;

/*
 * ��ɫ��
 * ��ѡ������button��ɫ
 * Ҳ����ʹ����ɫѡ����ѡ����ɫ
 */
public class ColorPanel extends JPanel{
	private JButton
		btn1 = new JButton( "��ɫ"),
		btn2 = new JButton("��ɫ"),
		btn3 = new JButton("��ɫ"),
		btn4 = new JButton("����");//��ɫѡ����
	JColorChooser chooser;
	Color color0;
	public static Color color = new Color(0, 0, 0);
	public ColorPanel() {
		super(new GridLayout(2,2));//2��2�����񲼾�
		setPreferredSize(new Dimension(200, 60));
		color=new Color(0,0,0);//��ʼ��ɫΪ��
		btn1.addActionListener(new ActionListener() {/*ѡ���ɫ*/
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.RED;  
                	btn1.setForeground(color);
                	btn1.repaint();
                	btn2.setForeground(Color.BLACK);
                	btn3.setForeground(Color.BLACK);
                	btn4.setForeground(Color.BLACK);
                	Paint.thickpanel.repaint();
			}});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.GREEN;  
                	btn2.setForeground(color);
                	btn2.repaint();
                	btn1.setForeground(Color.BLACK);
                	btn3.setForeground(Color.BLACK);
                	btn4.setForeground(Color.BLACK);
                	Paint.thickpanel.repaint();
			}});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub 
                color=Color.BLUE;  
                	btn3.setForeground(color);
                	btn3.repaint();
                	btn2.setForeground(Color.BLACK);
                	btn1.setForeground(Color.BLACK);
                	btn4.setForeground(Color.BLACK);
                	Paint.thickpanel.repaint();
			}});
		btn4.addActionListener(new ActionListener() {/*��ɫѡ����*/
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chooser=new JColorChooser(); 
				color0=chooser.showDialog(new JFrame(), "ColorChooser",Color.lightGray );//��ȡ�û�ѡ�����ɫ
                if (color0 != null)  
                   color=color0;  
                	   btn4.setForeground(color);
                	   btn2.setForeground(Color.BLACK);
                	   btn3.setForeground(Color.BLACK);
                	   btn1.setForeground(Color.BLACK);
                	   Paint.thickpanel.repaint();
			}});
		/*panel�м����ĸ�button*/
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	}
}