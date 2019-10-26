package com.ccnu.nercel.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.ccnu.nercel.Tools.Function;
import com.ccnu.nercel.ui.DrawShapes;
import com.ccnu.nercel.ui.Paint;
/*
 * Button监听，获取Button内容
 * 画相应的图形
 */
public class BtnLinstener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton target = (JButton)e.getSource();
	    String actionCommand = target.getActionCommand();
	    if(actionCommand.contentEquals("直线")) {
	    		DrawShapes.type = DrawShapes.LINE;
	    		}
	    if(actionCommand.contentEquals("直角矩形")) {
	    		DrawShapes.type = DrawShapes.RECT;
    			}
	    if(actionCommand.contentEquals("椭圆")) {
	    		DrawShapes.type = DrawShapes.CIRCLE;
			}
	    if(actionCommand.contentEquals("铅笔")) {
	    		DrawShapes.type = DrawShapes.write;
    			}
	    if(actionCommand.contentEquals("空心圆")) {
    		DrawShapes.type = DrawShapes.ROUND;
			}
        if(actionCommand.contentEquals("圆角矩形")) {
    		DrawShapes.type = DrawShapes.ROUNDRECT;
		}
        if(actionCommand.contentEquals("橡皮檫")) {
    		DrawShapes.type = DrawShapes.ERASER;
			}
        if(actionCommand.contentEquals("实心圆")) {
    		DrawShapes.type = DrawShapes.FILLROUND;
			}
	    if(actionCommand.contentEquals("newfile")) {
    		Function.open();
    		}
	    if(actionCommand.contentEquals("redo")) {
	    		Function.redo();
	    		}
	    if(actionCommand.contentEquals("undo")) {
	    		Function.undo();
	   		}
	    if(actionCommand.contentEquals("clear")) {
	    		Function.clear();
	    		} 
	    if(actionCommand.contentEquals("save")) {
	    		Function.save();
	    		}
	}

}