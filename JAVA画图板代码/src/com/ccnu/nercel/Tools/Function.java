package com.ccnu.nercel.Tools;

import java.util.Stack;

import javax.swing.JOptionPane;

import com.ccnu.nercel.shape.Shape;
import com.ccnu.nercel.ui.DrawShapes;
import com.ccnu.nercel.ui.Paint;

/*
 * Function������
 * 
 */
public class Function {
	/*
	 * redoջ
	 */
	public static Stack<Shape> rshape = new Stack<Shape>();
	/*
	 * save ���� ���ڽ����������ͼƬ
	 * 
	 */		
	//��
	public static void open() {
		Open s= new Open();
	}
	
	
	public static void save() {
		Save s= new Save();
	}
	/*
	 * undo ������һ����ͼ����
	 * Menu�е�shapesͼ�γ�ջ
	 * ��ջ��ͼ�ν���rshapeջ
	 */
	public static void undo() {
		if (!DrawShapes.shapes.isEmpty()) {
			Shape s=DrawShapes.shapes.pop();	
			rshape.push(s);
			Paint.pnlDisplayArea.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "����Ϊ�գ��޷�ִ�г��ز���");
		}
	}
	/*
	 * redo�ָ���������
	 * rshapeջ��ջ
	 */
	public static void redo() {
		if(rshape.isEmpty()) {
			JOptionPane.showMessageDialog(null, "�ѻָ����г��ز���");
		}
		else {
			Shape r=rshape.pop();
			DrawShapes.shapes.add(r);
			Paint.pnlDisplayArea.repaint();
		}
	}
	/*
	 * clear ��ջ���
	 * ���shapes
	 */
	public static void clear() {
		
		if(!DrawShapes.shapes.isEmpty()) {
			int res = JOptionPane.showConfirmDialog(null, "�Ƿ���ջ���","",JOptionPane.YES_NO_OPTION);
			if(res == JOptionPane.YES_OPTION) {
				DrawShapes.shapes.clear();
				rshape.clear();
				Paint.pnlDisplayArea.repaint();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "����Ϊ��");
		}
	}
}