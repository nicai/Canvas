package com.nicai.src;

import java.util.ArrayList;
import java.util.List;

import com.nicai.src.shapes.Shape;

public class Canvas {
	private int width;
	private int height;
	private List<Shape> shapes;
	// Canvas is a 2D array of type byte, byte is used instead of char for the type
	// because there are 256 colours which fit the range of byte values
	private byte[][] canvasMatrix;
	
	public Canvas(int width, int height) {
		this.width = width;
		this.height = height + 2;
		shapes = new ArrayList<Shape>();
		canvasMatrix = new byte[this.height][this.width];
	}
	
	public byte[][] getCanvasMatrix() {
		return canvasMatrix;
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void print() {
		// Set the borders
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (row == 0 || row == height - 1) {
					// Set top and bottom borders with '-'
					canvasMatrix[row][col] = '-';
				} else if (col == 0 || col == width - 1) {
					// Set left and right borders with '|'
					canvasMatrix[row][col] = '|';
				} else {
					// Set the rest non-borders with ' '
					canvasMatrix[row][col] = ' ';
				}
			}
		}
		
		// Set all shapes
		for (Shape s : shapes) {
			s.draw(canvasMatrix);
		}
		
		// Print the canvas
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				System.out.print((char)canvasMatrix[row][col]);
			}
			System.out.println();
		}
	}
}
