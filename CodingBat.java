import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
//  look for <th> tag 
public class CodingBat{
	
	private String file;	//  Name of file to be indented
	private String code;	//  Code stripped of all new lines and tabs
	private String newCode;	//  String that contains formatted code
	private int level;		//  Number of times the current line should be indented
    String start = "<tbody><tr><th>";
	
	public Indent(String filename){		
		code = new String("");
        file = filename;		//  Sets the command line argument as filename.
		level = 0;
        newCode = new String("");
	}
	
	public static void main (String [] args){
		Indent run = new Indent(args[0]);	//  Passes the command line argument to constructor
		run.processFile();
		run.indentFile();
        run.printFile();
		run.writeToFile();
	}
	public void processFile(){
        String temp;                            //  Opens file that user entered in the 
		Scanner fromfile= OpenFile.open(file);  //  command line and each word
		while(fromfile.hasNext()){				//  with a space inbetween.
            temp = fromfile.next();
			code += temp;
			if(!checkStart(temp.charAt(temp.length()-1))){
                code += " ";
            }
		}
		fromfile.close();
	}
	
    public boolean checkStart(String current){	//  Checks to see if current word should not have a space after it.
        for(int i = 0; i < start.length(); i++){
            if(current == specialChars[i]) {
                return true;
            }
        }
        return false;
    }	
		
}