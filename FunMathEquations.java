/********************************************************************************************
 ********************************************************************************************
 *****                         Project Title: Fun Math Equations                        *****                                  
 *****                                Author: Ryan Huffman                              *****                            
 *****                    Project Start Date: September 1st, 2018                       *****
 *****               Project Completion Date: September 4th, 2018                       *****
 *****                             Copyright: Ryan Huffman 2018                         *****
 *****            Author Contact Information: Phone:                                    *****
 *****                                        Email:                                    *****                                                                                                                                                                                                                                                                    
 ********************************************************************************************
 ********************************************************************************************/

//IMPORTS of needed tools, utilities and plug-ins.
import javax.swing.JOptionPane;
import java.util.Calendar;
 
 //START of main CLASS for this project called "FunMathEquations".
 public class FunMathEquations 
{
     //START of "main" METHOD where the program begins running code.
	 public static void main(String[] args) 
    {
	     //VARIABLES used (in part) in output of final answer.
		 int answerInt;
		 String[] answer = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
									"Friday", "Saturday"};
         
		 //Tells the user what the program is built to do in a MESSAGE DIALOG BOX.
		 JOptionPane.showMessageDialog(null, 
			 "With this program, you can ENTER A DATE and \nfind out which DAY OF "
			     + "THE WEEK \nthat date was on or will be on!!! \n\nCAREFULLY FOLLOW ALL "
			     + "DIRECTIONS!  \n\n*NOTE: This program only handles ''AD'' dates. \n        "
			     + "  ''BC'' dates may be added at a later date!", "Program Information!", 
			     JOptionPane.INFORMATION_MESSAGE);
				
         //Gets the month of the date from user input and converts it to an INTEGER....
         	//VARIABLE "m" and then reassigns it to INTEGER VARIABLE "fM" and then....
         	//subtracts 1 from "m" so that it can be compared to the current date.
		 String month = JOptionPane.showInputDialog(null, "Please enter the number that "
							+ "corresponds to the MONTH of the date you wish to work with. "
							+  "\n\n1)January  \n2)February  \n3)March  \n4)April  "
							+ "\n5)May  \n6)June  \n7)July  \n8)August  "
							+ "\n9)September  \n10)October  \n11)November  \n12)December");
		 int m = Integer.parseInt(month);
		 int fM = m;
		 m--;
				
		 //IF and ELSE IF Statement blocks used to adjust the INTEGER VARIABLE "fM"....
		     //so that it works with the main formula.
		 if(m < 3) 
        {
		     fM += 10;
        }//<--END of IF Statement with the CONDITION "(m < 3)".
		 else if(m > 2 && m <= 12)
        {
		     fM -= 2;
        }//<--END of ELSE IF Statement with the CONDITIONs "(m > 2 && m <= 12)".
		 
         //Gets the date from user input and converts it to an INTEGER VARIABLE "d".
		 String date = JOptionPane.showInputDialog(null, "Please enter the DATE of the month, "
						   + "of the date that you wish to work with!!!  \n\nExample: "
						   + "for the date December 19th, 2158 .... enter 19!");
		 int d = Integer.parseInt(date);
				
		 //Gets the Year from user input and converts it to an INTEGER VARIABLE "yANDc.... 
		 	//The code then, separates the century from the year and assigns them to the....
		 	//INTEGER VARIABLES "c" (for century) and "y" (for year).
		 String year = JOptionPane.showInputDialog(null, "Please enter the FULL YEAR "
						   + "of the date you wish to work with!!!  (Ex: 862 or 1980)"
						   + "\n\nFor Example: for the date December 19th, 2158, you "
						   + "would enter ''2158''");
         int yANDc = Integer.parseInt(year);
		 int c = yANDc / 100;
		 int y = yANDc % 100;
		 
		 //IF Statement used to correct the INTEGER VARIABLE "y" in accordance to the....
		 	//formula, depending upon the INTEGER VARIABLE "fM" gained from user input.
		 if(fM == 11 || fM == 12) 
        {
			 y--;
		}//<--END of IF Statement with the CONDITIONs "(fM == 11 || fM == 12)".
		 
		 //Parts of formula that need to be calculated first and later put into main....
		 	//formula. These calculations are then stored to INTEGER VARIABLES.
		 int tempA = 13 * fM;
		 int tempB = tempA - 1;
		 int tempC = tempB / 5;
		 int tempD = y / 4;
		 int tempE = c / 4;
		 int tempF = 2 * c;
				
         //Calculates the final output using the final parts of the main formula.
		 answerInt = d + tempC + y + tempD + tempE;
		 answerInt -= tempF;
		 answerInt = answerInt % 7;
				
		 //IF Statement that corrects the INTEGER VARIABLE "y" to display.... 
		 	//correctly in the final answer output, after INTEGER VARIABLE "y" was.... 
			//changed to be used in the main formula correctly.
         if(fM == 11 || fM == 12) 
        {
        	 y++;
        }//<--END of IF Statement with the CONDITIONs "(fM == 11 || fM == 12)".	
		
         //Converts the INTEGER VARIABLE "fM" into a STRING ARRAY VARIABLE "months".... 
         	//that will print the correct month in final output.
		 String[] months = {"", "March", "April", "May", "June", "July", "August", "September", 
								"October", "November", "December", "January", "February"};
		 
		 //Formats the year to make sure that INTEGER VARIABLE "y" is displayed as....
		 	//two digits, used for when the user inputs a year between "xx00" and "xx09".
		 String sOFy = String.format("%02d", y);
		 
		 //Gets the current date and assigns each part of the current date to.... 
		 	//the INTEGER VARIABLES "curMonth", "curDate" and "curYear".
    	 Calendar calendar = Calendar.getInstance();
		 int curMonth = calendar.get(Calendar.MONTH); 
		 int curDate = calendar.get(Calendar.DAY_OF_MONTH);
		 int curYear = calendar.get(Calendar.YEAR);
		 
		 //IF, ELSE IF and ELSE Statement blocks used to figure out if the user input....
		 	//date is in the past, is today or in the future and then, assigns....
		 	//that answer to the INTEGER VARIABLE "pORf" and then used to display correct....
		 	//grammar in the final output MESSAGE DIALOG BOX through the STRING....
		 	//ARRAY VARIABLE "tenseOut".
		 int pORf;
		 if(curYear == yANDc)
        {
		     
        	 if(curMonth == m)
            {
		    	 
		    	 if(curDate == d)
		    	{
		    		 pORf = 1;
		    	}//<--END of IF Statement with the CONDITION "(curDate == d)".
		    	 else if(curDate < d)
		    	{
		    		 pORf = 2; 
		    	}//<--END of ELSE IF Statement with the CONDITION "(curDate < d)".
		    	 else
		    	{
		    		 pORf = 0;
		    	}//<--END of ELSE Statement in case IF and ELSE IF Statements are FALSE.
            
            }//<--END of IF Statement with the CONDITION "(curYear == yANDc)".
		     else if(curMonth < m)
		    {
		         pORf = 2;	 
		    }//<--END of ELSE IF Statement with the CONDITION "(curMonth < m)".
		     else
		    {
		    	 pORf = 0;
		    }//<--END of ELSE Statement in case IF and ELSE IF Statement are FALSE.
        
        }//<--END of IF Statement with the CONDITION "(curYear == yANDc)".
         
         else if(curYear < yANDc)
        {
        	 pORf = 2;
        }//<--END of ELSE IF Statement with the CONDITION "(curYear < yANDc)".
         
         else
        {
        	 pORf = 0;
        }//<--END of ELSE Statement in case IF and ELSE IF Statements are FALSE.
		 String[] tenseOut = {"Fell on a: ", "IS TODAY!!! Today is: ", "Will fall on a: "};
		 
		 //Outputs the final answer to the user in a MESSAGE DIALOG BOX.
		 JOptionPane.showMessageDialog(null,months[fM] + " " + d + ", " + c + sOFy + "  "
						+ "\n\n" + tenseOut[pORf] + "\n\n" + answer[answerInt], "Results!!!!", 
						JOptionPane.WARNING_MESSAGE);
		 
		 //System exit command.
		 System.exit(0);
    
    }//<--END of "main" METHOD where the program runs.

}//<--END of "FunMathEquations" CLASS. This is the main CLASS of this program.


