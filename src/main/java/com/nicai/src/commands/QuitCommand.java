package com.nicai.src.commands;

public class QuitCommand extends Command {
	public static final int QUIT_COMMAND_PARAMS_LENGTH = 0;
	
	public boolean run(String[] params) {
		if (!checkParams(params)) {
			return false;
		}
		
		System.exit(0);
		return true;
	}
	
	public boolean checkParamsLength(String[] params) {
		if (params.length != QUIT_COMMAND_PARAMS_LENGTH) {
			return false;
		}
		return true;
	}
	
	public boolean checkParamsTypes(String[] params) {
		return true;
	}
}
