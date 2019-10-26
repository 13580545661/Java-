package com.ccnu.nercel.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

import javax.swing.*;

import com.ccnu.nercel.listener.BtnLinstener;
import com.ccnu.nercel.listener.ColorPanel;
import com.ccnu.nercel.listener.ThicknessPanel;
import com.ccnu.nercel.shape.Shape;

import com.ccnu.nercel.listener.PaintPanel;

public class Paint extends JFrame{
	/*
	 * ��ͼ�壬����ColorPanel��ɫѡ��panel��ThicknessPanel��ϸѡ��panel��ShapeButtonͼ��ѡ��panel��File �˵���
	 * PaintPanel ����
	 */
	JPanel pnlCommandArea = new JPanel(new FlowLayout());
	public static PaintPanel pnlDisplayArea = new PaintPanel();//����
	private JMenuBar mb1 =new JMenuBar();
	private ColorPanel gcolor =new ColorPanel();//��ɫpanel
	public static ThicknessPanel thickpanel = new ThicknessPanel();//��ϸpanel
	ShapeButton sbtn = new ShapeButton();//ͼ��ѡ��panel
	
	
	//File �˵���
	JButton newbtn = new JButton("�½�");
	JButton undobtn = new JButton("����");
	JButton redobtn = new JButton("����");
	JButton clearbtn = new JButton("���");
	JButton savebtn = new JButton("����");
	
    private JButton[] buttonArray = new JButton[]{newbtn,undobtn,redobtn,clearbtn,savebtn};
    private JToolBar toolbar = new JToolBar();
    /*****************/
	public Paint() {
		pnlCommandArea.setLayout(new FlowLayout());		
		BtnLinstener btns = new BtnLinstener();
		JFrame jf = new JFrame("���໭ͼ��");
		JPanel jp = new JPanel();
		
		/******/
		JPanel jp1 = new JPanel();
		for(int i=0;i<buttonArray.length;i++)
		{
			toolbar.add(buttonArray[i]);
			
			buttonArray[i].addActionListener(btns);
			
		}
		buttonArray[0].setActionCommand("newfile");
		buttonArray[0].setToolTipText("�½�");
		buttonArray[1].setActionCommand("undo");
		//Ϊ��ť���ù�����ʾ��Ϣ����������������ʱ��ʾ��ʾ��Ϣ
		buttonArray[1].setToolTipText("����");
		buttonArray[2].setActionCommand("redo");
		buttonArray[2].setToolTipText("����");
		buttonArray[3].setActionCommand("clear");
		buttonArray[3].setToolTipText("���");
		buttonArray[4].setActionCommand("save");
		buttonArray[4].setToolTipText("����");

		/******/
		jp.setBackground(Color.WHITE);//��ɫ����
		/******/
		jp.setLayout(new BorderLayout());
		jp.add(toolbar,BorderLayout.NORTH);
		jp1.add(gcolor);
		jp1.add(thickpanel);
		jp1.add(sbtn);
		jp.add(jp1);
		/******/
		jf.add(jp,BorderLayout.NORTH);
		jf.add(pnlDisplayArea);
		jf.setSize(800, 700);//��ͼ���С800*800
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setCursor(HAND_CURSOR);//���������ʽ
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
	}
}
