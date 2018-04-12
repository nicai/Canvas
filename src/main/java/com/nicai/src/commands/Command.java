package com.nicai.src.commands;

import com.nicai.src.Canvas;

public abstract class Command {
	protected Canvas canvas;
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public abstract boolean run(String[] params);
	
	public abstract boolean checkParamsLength(String[] params);
	
	public abstract boolean checkParamsTypes(String[] params);
	
	public boolean checkParams(String[] params) {
		if (params == null) {
			return false;
		}
		return checkParamsLength(params) && checkParamsTypes(params);
	}
}
