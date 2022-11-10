package LoggingWhoseAcitons;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

    public class LoggingThoseActions {

    //Attributter-----------------------------------------------------------------
    ArrayList<LoggingThoseActions> lines = new ArrayList<>();
    ArrayList<LoggingThoseActions> deleteLine =new ArrayList<>();
    String lineOutput;
    String line;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
    LocalDateTime now = LocalDateTime.now();
    String dateTimeString = now.format(formatter);
    LocalDateTime localDateTime3 = LocalDateTime.now();

   // public LoggingThoseActions(){}

    //Konstruktør-----------------------------------------------------------------
    public LoggingThoseActions(String line) {
        this.line=line;
    }

    //Getter-----------------------------------------------------------------
    public String getLine(){
        return line;
    }

    //Setter-----------------------------------------------------------------
    public  void setLines(String line){
        this.line=line;
    }

    //Scanner-----------------------------------------------------------------
    Scanner sc = new Scanner(System.in);

    //Menu-metode-----------------------------------------------------------------
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
                    saveFile();
                    break;
                case 3:
                    deleteLine();
                    break;
                case 4:
                    break;

            }

        }
    }

    //Add line-metoden-----------------------------------------------------------------
    public void addline() {

        System.out.println("Type your line");
        String line = sc.nextLine();
        lines.add(new LoggingThoseActions(line));
        deleteLine.add(new LoggingThoseActions(line));
        for (LoggingThoseActions loggingThoseActions : lines) {
            System.out.println(loggingThoseActions);
        }
        saveFile();
    }

    //View line-metoden-----------------------------------------------------------------
    void viewLine(){
        System.out.println("\nLINE LIST:");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println("#" + i + ": " + lines.get(i));
        }

    }

    //Delete file-metoden-----------------------------------------------------------------
    void deleteLine() {
        viewLine();
        System.out.print("Enter # of the line to delete: ");
        int lineNumber = sc.nextInt();

        lines.remove(lineNumber);

        for (int i = 0; i < deleteLine.size(); i++) {
            saveFile();
        }
        System.out.println("Line deleted: ");
    }
    

    //Save file-metode-----------------------------------------------------------------
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

    //Create file-metoden-----------------------------------------------------------------
    void write(String msg) {
        File file = new File(" output.txt");
        PrintStream ps = null;
        try {
            ps = new PrintStream(file);
            ps.println(msg);
            ps.close();

        } catch (IOException e) {
            System.out.println("Message:" + e.getMessage());

        }
    }

    //Readd file-metode-----------------------------------------------------------------
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








