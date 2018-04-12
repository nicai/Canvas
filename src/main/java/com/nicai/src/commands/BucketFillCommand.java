package com.nicai.src.commands;

import com.nicai.src.Point;
import com.nicai.src.shapes.BucketFill;

public class BucketFillCommand extends Command {
	public static final int BUCKET_FILL_COMMAND_PARAMS_LENGTH = 3;
	
	public boolean run(String[] params) {
		if (!checkParams(params)) {
			return false;
		}
		
		int x = Integer.parseInt(params[0]);
		int y = Integer.parseInt(params[1]);
		byte c = (byte)params[2].charAt(0);
		
		Point p = new Point(x, y);
		BucketFill b = new BucketFill(p, c);
		canvas.addShape(b);
		canvas.print();
		return true;
	}
	
	public boolean checkParamsLength(String[] params) {
		if (params.length != BUCKET_FILL_COMMAND_PARAMS_LENGTH) {
			System.out.println("Parameters length is incorrect");
			return false;
		}
		return true;
	}
	
	public boolean checkParamsTypes(String[] params) {
		for (int i = 0; i < params.length - 1; i++) {
			try {
				Integer.parseInt(params[i]);
			} catch (NumberFormatException e) {
				System.out.println("Parameter '" + params[i] + "' is not an integer");
				return false;
			}
		}
		return true;
	}
}
