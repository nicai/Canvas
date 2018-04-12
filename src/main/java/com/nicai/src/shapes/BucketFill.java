package com.nicai.src.shapes;

import com.nicai.src.Point;

public class BucketFill implements Shape {
	private Point p;
	private byte colour;
	
	public BucketFill(Point p, byte colour) {
		this.p = p;
		this.colour = colour;
	}

	public void draw(byte[][] canvas) {
		// Get the point's character
		char c = (char)canvas[p.getY()][p.getX()];
		if (c == ' ') {
			fillCanvasWithColourO(canvas, p);
		} else if (c == 'x') {
			fillCanvasWithColourDot(canvas, p);
		}
	}

	// Recursive method to fill bucket with colour o
	private void fillCanvasWithColourO(byte[][] canvas, Point p) {
		int row = p.getY(); 
		int col = p.getX();
		if (canvas[row][col] == ' ') {
			canvas[row][col] = colour;
			fillCanvasWithColourO(canvas, new Point(col + 1, row));
			fillCanvasWithColourO(canvas, new Point(col - 1, row));
			fillCanvasWithColourO(canvas, new Point(col, row + 1));
			fillCanvasWithColourO(canvas, new Point(col, row - 1));
		}
	}
	
	// Recursive method to fill bucket with colour Dot
	private void fillCanvasWithColourDot(byte[][] canvas, Point p) {
		int row = p.getY();
		int col = p.getX();
		if (canvas[row][col] == 'x') {
			canvas[row][col] = colour;
			fillCanvasWithColourDot(canvas, new Point(col + 1, row));
			fillCanvasWithColourDot(canvas, new Point(col - 1, row));
			fillCanvasWithColourDot(canvas, new Point(col, row + 1));
			fillCanvasWithColourDot(canvas, new Point(col, row - 1));
		}
	}
}
