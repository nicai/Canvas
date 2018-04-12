package com.nicai.src.commands;

import com.nicai.src.Point;
import com.nicai.src.shapes.Rectangle;

public class RectangleCommand extends Command {
	public static final int RECTANGLE_COMMAND_PARAMS_LENGTH = 4;
	
	public boolean run(String[] params) {
		if (!checkParams(params)) {
			return false;
		}
		
		int p1_x = Integer.parseInt(params[0]);
		int p1_y = Integer.parseInt(params[1]);
		int p2_x = Integer.parseInt(params[2]);
		int p2_y = Integer.parseInt(params[3]);
		
		Point topLeft = new Point(p1_x, p1_y);
		Point bottomRight = new Point(p2_x, p2_y);
		
		Rectangle r = new Rectangle(topLeft, bottomRight);
		canvas.addShape(r);
		canvas.print();
		return true;
	}
	
	public boolean checkParamsLength(String[] params) {
		if (params.length != RECTANGLE_COMMAND_PARAMS_LENGTH) {
			System.out.println("Parameters length is incorrect");
			return false;
		}
		return true;
	}
	
	public boolean checkParamsTypes(String[] params) {
		for (String param : params) {
			try {
				Integer.parseInt(param);
			} catch (NumberFormatException e) {
				System.out.println("Parameter '" + param + "' is not an integer");
				return false;
			}
		}
		return true;
	}
}
