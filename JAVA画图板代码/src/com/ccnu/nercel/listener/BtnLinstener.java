package com.ccnu.nercel.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import com.ccnu.nercel.Tools.Function;
import com.ccnu.nercel.ui.DrawShapes;
import com.ccnu.nercel.ui.Paint;
/*
 * Button��������ȡButton����
 * ����Ӧ��ͼ��
 */
public class BtnLinstener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton target = (JButton)e.getSource();
	    String actionCommand = target.getActionCommand();
	    if(actionCommand.contentEquals("ֱ��")) {
	    		DrawShapes.type = DrawShapes.LINE;
	    		}
	    if(actionCommand.contentEquals("ֱ�Ǿ���")) {
	    		DrawShapes.type = DrawShapes.RECT;
    			}
	    if(actionCommand.contentEquals("��Բ")) {
	    		DrawShapes.type = DrawShapes.CIRCLE;
			}
	    if(actionCommand.contentEquals("Ǧ��")) {
	    		DrawShapes.type = DrawShapes.write;
    			}
	    if(actionCommand.contentEquals("����Բ")) {
    		DrawShapes.type = DrawShapes.ROUND;
			}
        if(actionCommand.contentEquals("Բ�Ǿ���")) {
    		DrawShapes.type = DrawShapes.ROUNDRECT;
		}
        if(actionCommand.contentEquals("��Ƥ��")) {
    		DrawShapes.type = DrawShapes.ERASER;
			}
        if(actionCommand.contentEquals("ʵ��Բ")) {
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