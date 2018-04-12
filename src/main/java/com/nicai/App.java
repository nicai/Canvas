package com.nicai;

import java.util.Arrays;
import java.util.Scanner;

import com.nicai.src.Canvas;
import com.nicai.src.commands.Command;
import com.nicai.src.factory.CommandFactory;

/**
 * Simple app that draws shapes on a canvas based on user input
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Canvas canvas = null;
        Scanner s = new Scanner(System.in);
        while(true) {
        	System.out.print("enter command: ");
        	String line = s.nextLine().trim();
        	if (!line.isEmpty()) {
        		String[] tokens = line.split(" ");
        		char cmd = tokens[0].charAt(0);
        		String[] params = Arrays.copyOfRange(tokens, 1, tokens.length);
        		switch(cmd) {
        		case 'C':
        			Command cCmd = CommandFactory.getCommand('C');
        			cCmd.run(params);
        			canvas = cCmd.getCanvas();
        			break;
        		case 'L':
        			Command lCmd = CommandFactory.getCommand('L');
        			lCmd.setCanvas(canvas);
        			lCmd.run(params);
        			break;
        		case 'R':
        			Command rCmd = CommandFactory.getCommand('R');
        			rCmd.setCanvas(canvas);
        			rCmd.run(params);
        			break;
        		case 'B':
        			Command bCmd = CommandFactory.getCommand('B');
        			bCmd.setCanvas(canvas);
        			bCmd.run(params);
        			break;
        		case 'Q':
        			Command qCmd = CommandFactory.getCommand('Q');
        			qCmd.run(params);
        			break;
        		default:
        			System.out.println("Invalid command");
        			break;
        		}
        	}
        }
    }
}
