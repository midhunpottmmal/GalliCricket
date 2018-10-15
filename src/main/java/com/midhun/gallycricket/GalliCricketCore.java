package com.midhun.gallycricket;

import java.util.Scanner;

/**
 * <h1> Galli Cricket main class <h1>
 * @author Midhun-p 15-10-2018
 * 
 *
 */
public class GalliCricketCore {
	
	/**
	 * 
	 * Main method for Gally cricket class Flow starts from here .
	 * @param args
	 * 
	 */
	public static void main( String[] args ){
		
		//opening input scanner from console
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("-------------------------- Galli Cricket -----------------------\n");
		
    	System.out.println("Program would have input as Number of balls bowled followed by \nEither run scored for each ball or it would be “W” if batsmen gets out for a ball. \n");
    	
    	System.out.println("\r\r  RULES\n \n1.If batsman touch the ball he gets 1 run.\r\n" + 
    			"2.If batsman fails to score run on two consecutive balls he gets out.\r\n" + 
    			"3.Batsman can get out for other reasons like hit out, catch etc.\r\n" + 
    			"4.if a batsman gets out for any reason, then team will lose 2 runs\r\n");
    	
    	System.out.println("############################################################### \n");
    	
    	while (true) {
    		Integer numberOfBalls=readNumberOfBalls(scanner);
        	System.out.println("Enter Runs Scored By each Ball");
        	runCalculater(numberOfBalls,scanner);   
        	
        	System.out.println("Press 'Y' If You want to contine .......");
        	
        	String input = scanner.nextLine();
        	 if(input.equals("y")||input.equals("Y")) {
        		 System.out.println("\nStating new team Scoreboard ...");
        		 
             }else {
            	 System.out.println("\nApp Closed ...");
            	 break;
             }        	
			
		}
    	 
    	//Closing Scanner 
    	scanner.close();
    }

	/**
	 * 
	 * @param numberOfBalls
	 * @param scanner 
	 */
	private static void runCalculater(Integer numberOfBalls, Scanner scanner) {		
		
		// TotalRun is used to find final score
		int totalRun 	= 0;
		// Temporary variable used to find last ball run was 0 or not
		int prevRun		= 1;
		
		for(int index=1;index<=numberOfBalls;index++) {
			
			int currentRun = readRun(scanner);
			if(prevRun == 0 && currentRun == 0) {
				totalRun -= 2;
				currentRun= 1;
			}else {
				totalRun += currentRun;	
			}
					
			prevRun =currentRun;
		}	
		
		System.out.println("Total run scored by this team  -> "+totalRun);
	}

	
	/**
	 * This method is used to read each ball and return run .
	 * if input is 'w' or 'W' it will return -2 .
	 * if run between 0 and 6 it will return run .
	 * Any other in put other than w or 0-6 it will ask re-enter a valid run 
	 * @param scanner 
	 * @return {@link Integer} run scored in each ball 
	 */
	private static int readRun(Scanner scanner) {
		
		while (true) {
	         try {                                
	             String input=scanner.nextLine();
	             if(input.equals("w")||input.equals("W")) {
	            	 return -2;
	             }else {	            	 
	            	 int num = Integer.parseInt(input);
	            	 if(num>0 && num <7) {
	            		 return num;
	            	 }else if(num ==0) {
	            		 return 0;
	            	 }else {
	            		 throw new Exception("Bad input");
	            	 }
	             }
	         } catch (Exception e) {
	             System.out.println("Enter a valid run 0-6 or W (for wicket) ");
	         }
		}
	}

	
	/**
	 * This method will read how many balls one team can face.
	 * It will read from console reach a valid number .
	 * If input is not valid number it will ask  until a valid input come.
	 * @param scanner 
	 * 
	 * @return {@link Integer} number of balls
	 */
	private static Integer readNumberOfBalls(Scanner scanner) {
		
		 System.out.println( "Enter Number of Balls You Want to play :- " );
	     while (true) {
	         try {                                
	        	return Integer.valueOf(scanner.nextLine());
	         } catch (Exception e) {	        	 
	            System.out.println("Enter a valid number");
	         }
	     }
	}
}
