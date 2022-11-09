package LoggingWhoseAcitons;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LoggingThoseActions {
    ArrayList<LoggingThoseActions> lines = new ArrayList<>();
    ArrayList<LoggingThoseActions> deleteLine =new ArrayList<>();
    String lineOutput;
    String line;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
    LocalDateTime now = LocalDateTime.now();
    String dateTimeString = now.format(formatter);

  LocalDateTime localDateTime3 = LocalDateTime.now();

    public LoggingThoseActions(){

    }

    public LoggingThoseActions(String line) {
        this.line=line;
    }
    public String getLine(){
        return line;
    }
    public  void setLines(String line){
        this.line=line;
    }


    Scanner sc = new Scanner(System.in);
          
    public void menu() {

        Menu menu = new Menu("MENU:", "Please choose option: ", new String[]{
                "1. Add line ", "2. View lines", "3. Delete line", "9. Exit"});
        while (true) {
            menu.printMenu();
            int userChoice = menu.readChoice();

            switch (userChoice) {
                case 1:
                    addline();
                    break;
                case 2:
                    viewLine();
                    break;
                case 3:
                    deleteLine();
                    break;
                case 4:
                    break;

            }

        }
    }

    //Add line-metoden
    public void addline() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your line");
        String line = scanner.nextLine();
        lines.add(new LoggingThoseActions(line));
        deleteLine.add(new LoggingThoseActions(line));
        for (LoggingThoseActions loggingThoseActions : lines) {
            System.out.println(loggingThoseActions);
        }
        saveFile();
    }

      public String saveFile(){
          try {
              PrintStream ps= new PrintStream(new PrintStream("logfile.txt"));
               for (int i=0; i<lines.size();i++){
           
            
            ps.println(dateTimeString + " Adding new line: "
                   + lines.get(i)+getLine());  }

       }catch (FileNotFoundException e) {

   }
   return line;
    }


       //View line-metoden
        void viewLine(){
           for (int i = 0; i < lines.size(); i++)
               System.out.println(lines.get(i));
       }


        //Delete file-metoden
        void deleteLine() {
           int lineNumber;
            String line;
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nDELETE USER:");
            System.out.print("Enter # of user to delete: ");
            lineNumber = scanner.nextInt();


            System.out.println("\nUser deleted.");


            System.out.println();
            System.out.println("Line deleted");
            for (int i = 0; i < deleteLine.size(); i++) {
                System.out.println("Deleted line: ");
                saveFile();
            }

        }

        //Create file-metoden
        File file = new File(" output.txt");
        PrintStream ps = null;


        void write(String msg) {
        try {

            ps = new PrintStream(file);
            ps.println(msg);
            ps.close();

        } catch (IOException e) {

            System.out.println("Message:" + e.getMessage());

        }
    }


        public String readFil(){
            try {
                PrintStream printStream = new PrintStream(new PrintStream("word.txt"));
                for (int i=0; i<lines.size();i++){
                    System.out.println(".");
                }

            }catch ( FileNotFoundException e){

            }
            return lineOutput;

        }

    @Override
    public String toString(){
            return line;
    }

}








