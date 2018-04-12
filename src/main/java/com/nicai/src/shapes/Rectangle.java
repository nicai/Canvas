package com.nicai.src.shapes;

import com.nicai.src.Point;

public class Rectangle implements Shape {
	private Point p1;
	private Point p2;
	
	public Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public void draw(byte[][] canvas) {
		int p1_x = p1.getX();
		int p1_y = p1.getY();
		int p2_x = p2.getX();
		int p2_y = p2.getY();
		
		if (p1_x == p2_x || p1_y == p2_y) {
			System.out.println("Cannot draw a rectangle");
			return;
		}
		
		for (int row = p1_y; row <= p2_y; row++) {
			for (int col = p1_x; col <= p2_x; col++) {
				// Set the borders of a rectangle
				if (row == p1_y || row == p2_y || col == p1_x || col == p2_x) {
					canvas[row][col] = (byte)'x';					
				}
			}
		}
	}
}
