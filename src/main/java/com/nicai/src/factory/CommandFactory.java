package com.nicai.src.factory;

import com.nicai.src.commands.*;

public class CommandFactory {
	public static Command getCommand(char c) {
		switch(c) {
		case 'C':
			return new CanvasCommand();
		case 'L':
			return new LineCommand();
		case 'R':
			return new RectangleCommand();
		case 'B':
			return new BucketFillCommand();
		case 'Q':
			return new QuitCommand();
		default:
			return null;
		}
	}
}
