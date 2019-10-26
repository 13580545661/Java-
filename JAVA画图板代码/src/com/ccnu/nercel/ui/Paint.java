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
	 * 画图板，包含ColorPanel颜色选择panel、ThicknessPanel粗细选择panel、ShapeButton图形选择panel、File 菜单栏
	 * PaintPanel 画板
	 */
	JPanel pnlCommandArea = new JPanel(new FlowLayout());
	public static PaintPanel pnlDisplayArea = new PaintPanel();//画板
	private JMenuBar mb1 =new JMenuBar();
	private ColorPanel gcolor =new ColorPanel();//颜色panel
	public static ThicknessPanel thickpanel = new ThicknessPanel();//粗细panel
	ShapeButton sbtn = new ShapeButton();//图形选择panel
	
	
	//File 菜单栏
	JButton newbtn = new JButton("新建");
	JButton undobtn = new JButton("撤销");
	JButton redobtn = new JButton("返回");
	JButton clearbtn = new JButton("清空");
	JButton savebtn = new JButton("保存");
	
    private JButton[] buttonArray = new JButton[]{newbtn,undobtn,redobtn,clearbtn,savebtn};
    private JToolBar toolbar = new JToolBar();
    /*****************/
	public Paint() {
		pnlCommandArea.setLayout(new FlowLayout());		
		BtnLinstener btns = new BtnLinstener();
		JFrame jf = new JFrame("天青画图板");
		JPanel jp = new JPanel();
		
		/******/
		JPanel jp1 = new JPanel();
		for(int i=0;i<buttonArray.length;i++)
		{
			toolbar.add(buttonArray[i]);
			
			buttonArray[i].addActionListener(btns);
			
		}
		buttonArray[0].setActionCommand("newfile");
		buttonArray[0].setToolTipText("新建");
		buttonArray[1].setActionCommand("undo");
		//为按钮设置工具提示信息，当把鼠标放在其上时显示提示信息
		buttonArray[1].setToolTipText("撤销");
		buttonArray[2].setActionCommand("redo");
		buttonArray[2].setToolTipText("返回");
		buttonArray[3].setActionCommand("clear");
		buttonArray[3].setToolTipText("清空");
		buttonArray[4].setActionCommand("save");
		buttonArray[4].setToolTipText("保存");

		/******/
		jp.setBackground(Color.WHITE);//白色背景
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
		jf.setSize(800, 700);//画图板大小800*800
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setCursor(HAND_CURSOR);//设置鼠标样式
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
	}
}
