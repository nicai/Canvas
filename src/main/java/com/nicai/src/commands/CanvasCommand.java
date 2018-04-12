package com.nicai.src.commands;

import com.nicai.src.Canvas;

public class CanvasCommand extends Command {
	public static final int CANVAS_COMMAND_PARAMS_LENGTH = 2;
	
	public boolean run(String[] params) {
		if (!checkParams(params)) {
			return false;
		}
		
		int width = Integer.parseInt(params[0]);
		int height = Integer.parseInt(params[1]);
		canvas = new Canvas(width, height);
		canvas.print();
		return true;
	}
	
	public boolean checkParamsLength(String[] params) {
		if (params.length != CANVAS_COMMAND_PARAMS_LENGTH) {
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
