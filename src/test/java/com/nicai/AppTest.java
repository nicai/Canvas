package com.nicai;

import java.util.Arrays;

import com.nicai.src.commands.*;
import com.nicai.src.factory.CommandFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public void testCanvasCommand()
    {
    	Command cCmd = CommandFactory.getCommand('C');
    	assertTrue(cCmd instanceof CanvasCommand);
    	
    	String[] correctParams   = {"20", "4"};
    	String[] tooManyParams   = {"20", "4", "3"};
    	String[] tooLessParams   = {"20"};
    	String[] incorrectParams = {"20", "a"};
    	
    	assertTrue(cCmd.run(correctParams));
    	assertFalse(cCmd.run(tooManyParams));
    	assertFalse(cCmd.run(tooLessParams));
    	assertFalse(cCmd.run(incorrectParams));
    }
    
    public void testLineCommand()
    {
    	// Create a canvas
    	Command cCmd = CommandFactory.getCommand('C');
    	assertTrue(cCmd instanceof CanvasCommand);
    	String[] canvasParams = {"20", "4"};
    	assertTrue(cCmd.run(canvasParams));
    	
    	// Get the line command
    	Command lCmd = CommandFactory.getCommand('L');
    	assertTrue(lCmd instanceof LineCommand);
    	lCmd.setCanvas(cCmd.getCanvas());
    	
    	String[] correctParams   = {"1", "2", "6", "2"};
    	String[] tooManyParams   = {"1", "2", "6", "2", "3"};
    	String[] tooLessParams   = {"1", "2", "6"};
    	String[] incorrectParams = {"1", "2", "6", "a"};
    	
    	assertTrue(lCmd.run(correctParams));
    	assertFalse(lCmd.run(tooManyParams));
    	assertFalse(lCmd.run(tooLessParams));
    	assertFalse(lCmd.run(incorrectParams));
    }
    
    public void testRectangleCommand()
    {
    	// Create a canvas
    	Command cCmd = CommandFactory.getCommand('C');
    	assertTrue(cCmd instanceof CanvasCommand);
    	String[] canvasParams = {"20", "4"};
    	assertTrue(cCmd.run(canvasParams));
    	
    	// Get the rectangle command
    	Command rCmd = CommandFactory.getCommand('R');
    	assertTrue(rCmd instanceof RectangleCommand);
    	rCmd.setCanvas(cCmd.getCanvas());
    	
    	String[] correctParams   = {"14", "1", "18", "3"};
    	String[] tooManyParams   = {"14", "1", "18", "3", "3"};
    	String[] tooLessParams   = {"14", "1", "18"};
    	String[] incorrectParams = {"14", "1", "18", "a"};
    	
    	assertTrue(rCmd.run(correctParams));
    	assertFalse(rCmd.run(tooManyParams));
    	assertFalse(rCmd.run(tooLessParams));
    	assertFalse(rCmd.run(incorrectParams));
    }
    
    public void testBucketFillCommand()
    {
    	// Create a canvas
    	Command cCmd = CommandFactory.getCommand('C');
    	assertTrue(cCmd instanceof CanvasCommand);
    	String[] canvasParams = {"20", "4"};
    	assertTrue(cCmd.run(canvasParams));
    	
    	// Get the bucket fill command
    	Command bCmd = CommandFactory.getCommand('B');
    	assertTrue(bCmd instanceof BucketFillCommand);
    	bCmd.setCanvas(cCmd.getCanvas());
    	
    	String[] correctParams   = {"10", "3", "o"};
    	String[] tooManyParams   = {"10", "3", "3", "o"};
    	String[] tooLessParams   = {"10", "3"};
    	String[] incorrectParams = {"10", "a", "o"};
    	
    	assertTrue(bCmd.run(correctParams));
    	assertFalse(bCmd.run(tooManyParams));
    	assertFalse(bCmd.run(tooLessParams));
    	assertFalse(bCmd.run(incorrectParams));
    }

    public void testApp()
    {
        Command cCmd = CommandFactory.getCommand('C');
        assertTrue(cCmd instanceof CanvasCommand);
        
        // Create a canvas
        String[] canvasParams = {"20", "4"};
        assertTrue(cCmd.run(canvasParams));
        
        // Check that the canvas is as expected
        byte[][] canvasMatrix = cCmd.getCanvas().getCanvasMatrix();
        byte[][] expectedCanvasMatrix =
        	{{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
        	 {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
        	 {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
        	 {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
        	 {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
        	 {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}};
        assertTrue(Arrays.deepEquals(canvasMatrix, expectedCanvasMatrix));
        
        // Create a line command
        String[] lineParams1 = {"1", "2", "6", "2"};
        String[] lineParams2 = {"6", "3", "6", "4"};
        Command lCmd = CommandFactory.getCommand('L');
        assertTrue(lCmd instanceof LineCommand);
        lCmd.setCanvas(cCmd.getCanvas());
        assertTrue(lCmd.run(lineParams1));
        assertTrue(lCmd.run(lineParams2));
        
        // Check that the canvas is as expected
        canvasMatrix = lCmd.getCanvas().getCanvasMatrix();
        expectedCanvasMatrix = new byte[][]
        	{{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
        	 {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
        	 {'|','x','x','x','x','x','x',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
        	 {'|',' ',' ',' ',' ',' ','x',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
        	 {'|',' ',' ',' ',' ',' ','x',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
        	 {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}};
        assertTrue(Arrays.deepEquals(canvasMatrix, expectedCanvasMatrix));
        
        // Create a rectangle command
        String[] rectangleParams = {"14", "1", "18", "3"};
        Command rCmd = CommandFactory.getCommand('R');
        assertTrue(rCmd instanceof RectangleCommand);
        rCmd.setCanvas(cCmd.getCanvas());
        assertTrue(rCmd.run(rectangleParams));
        
        // Check that the canvas is as expected
        canvasMatrix = rCmd.getCanvas().getCanvasMatrix();
        expectedCanvasMatrix = new byte[][]
           	{{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
           	 {'|',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','x','x','x','x','x','|'},
           	 {'|','x','x','x','x','x','x',' ',' ',' ',' ',' ',' ',' ','x',' ',' ',' ','x','|'},
           	 {'|',' ',' ',' ',' ',' ','x',' ',' ',' ',' ',' ',' ',' ','x','x','x','x','x','|'},
           	 {'|',' ',' ',' ',' ',' ','x',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','|'},
           	 {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}};
        assertTrue(Arrays.deepEquals(canvasMatrix, expectedCanvasMatrix));
        
        // Create a bucket fill command
        String[] bucketFillParams = {"10", "3", "o"};
        Command bCmd = CommandFactory.getCommand('B');
        assertTrue(bCmd instanceof BucketFillCommand);
        bCmd.setCanvas(cCmd.getCanvas());
        assertTrue(bCmd.run(bucketFillParams));
        
        // Check that the canvas is as expected
        canvasMatrix = bCmd.getCanvas().getCanvasMatrix();
        expectedCanvasMatrix = new byte[][]
        	{{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
        	 {'|','o','o','o','o','o','o','o','o','o','o','o','o','o','x','x','x','x','x','|'},
        	 {'|','x','x','x','x','x','x','o','o','o','o','o','o','o','x',' ',' ',' ','x','|'},
        	 {'|',' ',' ',' ',' ',' ','x','o','o','o','o','o','o','o','x','x','x','x','x','|'},
        	 {'|',' ',' ',' ',' ',' ','x','o','o','o','o','o','o','o','o','o','o','o','o','|'},
        	 {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}};
        assertTrue(Arrays.deepEquals(canvasMatrix, expectedCanvasMatrix));
        
        // Create a line command again
        String[] lineParams3 = {"6", "4", "13", "4"};
        lCmd.setCanvas(cCmd.getCanvas());
        assertTrue(lCmd.run(lineParams3));
        
        // Check that the canvas is as expected
        canvasMatrix = lCmd.getCanvas().getCanvasMatrix();
        expectedCanvasMatrix = new byte[][]
           	{{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
           	 {'|','o','o','o','o','o','o','o','o','o','o','o','o','o','x','x','x','x','x','|'},
           	 {'|','x','x','x','x','x','x','o','o','o','o','o','o','o','x',' ',' ',' ','x','|'},
           	 {'|',' ',' ',' ',' ',' ','x','o','o','o','o','o','o','o','x','x','x','x','x','|'},
           	 {'|',' ',' ',' ',' ',' ','x','x','x','x','x','x','x','x','o','o','o','o','o','|'},
           	 {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}};
        assertTrue(Arrays.deepEquals(canvasMatrix, expectedCanvasMatrix));
        
        // Create a bucket fill command again
        String[] bucketFillParams2 = {"1", "2", "."};
        bCmd.setCanvas(cCmd.getCanvas());
        assertTrue(bCmd.run(bucketFillParams2));
        
        // Check that the canvas is as expected
        canvasMatrix = bCmd.getCanvas().getCanvasMatrix();
        expectedCanvasMatrix = new byte[][]
           	{{'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'},
           	 {'|','o','o','o','o','o','o','o','o','o','o','o','o','o','x','x','x','x','x','|'},
             {'|','.','.','.','.','.','.','o','o','o','o','o','o','o','x',' ',' ',' ','x','|'},
             {'|',' ',' ',' ',' ',' ','.','o','o','o','o','o','o','o','x','x','x','x','x','|'},
             {'|',' ',' ',' ',' ',' ','.','.','.','.','.','.','.','.','o','o','o','o','o','|'},
             {'-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-','-'}};
        assertTrue(Arrays.deepEquals(canvasMatrix, expectedCanvasMatrix));
    }
}
