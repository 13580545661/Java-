    
package com.ccnu.nercel.listener;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.ccnu.nercel.ui.DrawShapes;
import com.ccnu.nercel.ui.Paint;
import com.ccnu.nercel.shape.*;

/*
 * ����panel
 */

public class PaintPanel extends JPanel implements MouseMotionListener, MouseListener {

	private Point Begin = null;//��ʼ��
	private Point End = null;//��ֹ��
	private boolean dottedTag = true;
	private Color color;//��ɫ
	public static int thick = 1;//Ĭ�ϻ��ʴ�ϸΪ1
	public static int w = 0;//���
	public static int h = 0;//�߶�
	DrawPencil dot;

	public PaintPanel() {

		setPreferredSize(new Dimension(600, 600));//�����С
		Border border = new LineBorder(Color.BLACK);//����߿�Ϊ��ɫ
		setBorder(border);
		setBackground(Color.white);//��ɫ����
		Begin = new ScreenPoint(0, 0);
		End = new ScreenPoint(0, 0);
		dot = new DrawPencil();
		addMouseListener(this);
		addMouseMotionListener(this);
		

	}
/*
 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
 * ��ͼ����
 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		color = ColorPanel.color;
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		w = Math.abs(End.x - Begin.x);
		h = Math.abs(End.y - Begin.y);
		Point min = new Point(0, 0);
		min.x = Math.min(End.x, Begin.x);
		min.y = Math.min(End.y, Begin.y);
		
		for ( Shape shape : DrawShapes.shapes) {
			g2.setStroke(new BasicStroke());
			shape.DrawShape(g2);
		}
		if (dottedTag) {
			Stroke dash = new BasicStroke(thick, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.5f,
					new float[] { 5, 5, }, 0f);
			g2.setStroke(dash);
			if (DrawShapes.type== DrawShapes.RECT) {
				g2.drawRect(min.x, min.y, w, h);
			} else if (DrawShapes.type == DrawShapes.LINE) {
				g2.drawLine(Begin.x, Begin.y, End.x, End.y);
			} else if (DrawShapes.type == DrawShapes.CIRCLE) {
				g2.drawOval(min.x, min.y, w, h);
			} else if (DrawShapes.type == DrawShapes.ERASER) {
				g2.clearRect(Begin.x, Begin.y, w, h);
			} else if (DrawShapes.type == DrawShapes.ROUND) {
				g2.drawOval(min.x, min.y, h, h);
			} else if (DrawShapes.type == DrawShapes.ROUNDRECT) {
				g2.drawRoundRect(min.x, min.y,w,h, 30, 40);
			} else if (DrawShapes.type == DrawShapes.FILLROUND) {
				g2.fillOval(min.x, min.y, h, h);
			}else {
				dot.DrawShape(g2);
				}
			}	
	}
/*
 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
 * Ǧ��дʱ����ʾ��������
 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		End = e.getPoint();
		if (DrawShapes.type == DrawShapes.write) {
			dot.addpoint(Begin.x, Begin.y, End.x, End.y);
			Begin = End;
		} 
		repaint();

	}
/*
 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
 * ����ͼ����ʼλ�ã����������Ϊ��㣬��ʱ�����յ�һ��
 * ������д��ʱ�򣬸��»�����ɫ�ʹ�ϸ
 */
	public void mousePressed(MouseEvent e) {
		dottedTag = true;
		Begin = e.getPoint();
		End = Begin;		
		if (DrawShapes.type == DrawShapes.write) {
			dot = new DrawPencil();
			color = ColorPanel.color;
			dot.setcolorthick(color, thick);
		}

	}
/*
 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
 * ����ͷź󣬽�����ͼ����ջ
 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		dottedTag = false;
		if (DrawShapes.type == DrawShapes.RECT) {
			DrawShapes.shapes.add(new DrawRect(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.LINE) {
			DrawShapes.shapes.add(new DrawLine(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.CIRCLE) {
			DrawShapes.shapes.add(new DrawCircle(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.write) {
			DrawShapes.shapes.add(dot);
		} else if (DrawShapes.type == DrawShapes.ROUND) {
			DrawShapes.shapes.add(new DrawOval(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.ROUNDRECT) {
			DrawShapes.shapes.add(new DrawRoundRect(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.ERASER) {
			DrawShapes.shapes.add(new DrawEraser(color, thick, Begin.x, Begin.y, End.x, End.y));
		} else if (DrawShapes.type == DrawShapes.FILLROUND) {
		    DrawShapes.shapes.add(new DrawfillOval(color, thick, Begin.x, Begin.y, End.x, End.y));
	}
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}
	
	
	
	
}