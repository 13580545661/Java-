package com.ccnu.nercel.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.lang.reflect.Constructor;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.ccnu.nercel.listener.BtnLinstener;

public class ShapeButton extends JPanel{
	
	BtnLinstener btns = new BtnLinstener();
	
	private JButton
		btn1 = new JButton( "ֱ�Ǿ���"),
		btn2 = new JButton("��Բ"),
		btn3 = new JButton("ֱ��"),
		btn4 = new JButton("Ǧ��"),
	    btn5 = new JButton("����Բ"),
		btn6 = new JButton("Բ�Ǿ���"),
		btn7 = new JButton("ʵ��Բ"),
	    btn8 = new JButton("��Ƥ��");
	
	public ShapeButton() {
		super(new GridLayout(3, 3));
		setPreferredSize(new Dimension(250, 60));
		btn1.addActionListener(btns);
		btn2.addActionListener(btns);
		btn3.addActionListener(btns);
		btn4.addActionListener(btns);
		btn5.addActionListener(btns);
		btn6.addActionListener(btns);
		btn7.addActionListener(btns);
		btn8.addActionListener(btns);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
	}
}
