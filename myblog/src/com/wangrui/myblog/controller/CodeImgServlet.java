package com.wangrui.myblog.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/codeImg")
public class CodeImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedImage img = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 100, 40);
		
		g.setColor(Color.BLACK);
		int ran = (int)(Math.random()*10000);
		String s = String.valueOf(ran);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("code", s);
		
		
		g.setFont(new Font("ËÎÌו", Font.BOLD, 30));
		g.drawString(s, 10, 30);
		
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(img, "jpg", out);
		
	}

}
