package LoggingWhoseAcitons;


public class Main {
    public void run(){ //run-metode med tom parameterliste

        //New instance
        LoggingThoseActions log = new LoggingThoseActions("");
        log.menu();


    }


    public static void main(String[] args) {
        new Main().run(); //main-metode, der kalder den ikke-statiske metode run
    }
}
