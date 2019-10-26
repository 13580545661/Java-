package com.ccnu.nercel.Tools;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.ccnu.nercel.listener.PaintPanel;
import com.ccnu.nercel.ui.Paint;
import com.ccnu.nercel.shape.*;

	public class Open {  
	    public static void main(String[] args) throws ClassNotFoundException,  
	            InstantiationException, IllegalAccessException,  
	            UnsupportedLookAndFeelException {  
	        String path = null;  
	        //���ý�����  
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
	        JFileChooser jdir = new JFileChooser();  
	        //����ѡ��·��ģʽ  
	        jdir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
	        //���öԻ������  
	        jdir.setDialogTitle("��ѡ��·��");  
	        if (JFileChooser.APPROVE_OPTION == jdir.showOpenDialog(null)) {//�û������ȷ��  
	            path = jdir.getSelectedFile().getAbsolutePath();//ȡ��·��ѡ��  
	        }  
	        System.out.println(path);  
	    }  
	}  
