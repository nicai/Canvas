package com.nicai.src.shapes;

import com.nicai.src.Point;

public class Line implements Shape {
	private Point p1;
	private Point p2;
	
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void draw(byte[][] canvas) {
		int p1_x = p1.getX();
		int p1_y = p1.getY();
		int p2_x = p2.getX();
		int p2_y = p2.getY();
		
		if (p1_x == p2_x) {
			if (p1_y == p2_y) {
				System.out.print("Cannot draw a line with 2 same points");
			} else {
				int min_y = Math.min(p1_y, p2_y);
				int max_y = Math.max(p1_y, p2_y);
				int col = p1_x;
				
				// Set a horizontal line
				for (int row = min_y; row <= max_y; row++) {
					canvas[row][col] = (byte)'x';
				}
			}
		} else {	// p1_x != p2_x
			if (p1_y != p2_y) {
				System.out.println("Cannot draw a horizontal or a vertical line");
			} else {	// p1_y == p2_y
				int min_x = Math.min(p1_x, p2_x);
				int max_x = Math.max(p1_x, p2_x);
				int row = p1_y;
				
				// Set a vertical line
				for (int col = min_x; col <= max_x; col++) {
					canvas[row][col] = (byte)'x';
				}
			}
		}
	}
}
