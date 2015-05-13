
public class NetworkServiceIsCurrentlyDown extends Exception{
    private String causeOfProblem;
    private int severetyOfProblem;
    private boolean isHumanMistake;
    
    public NetworkServiceIsCurrentlyDown(String cause, int sev, boolean isHum){
        this.causeOfProblem = cause;
        this.severetyOfProblem = sev;
        this.isHumanMistake = isHum;
    }
    
    public NetworkServiceIsCurrentlyDown() {
        returnProblem();
    }

    public void returnProblem(){
        if(severetyOfProblem > 5 && isHumanMistake == true)
            System.out.println("It is a grave human mistake !");
        else if(severetyOfProblem < 5 && isHumanMistake == true)
            System.out.println("It is a minor human mistake !");
        else if(isHumanMistake != true)
            System.out.println("Tis' but a scratch");
        else {
            System.out.println("Unknown error 404 occured");
        }
    }
    
    
    
}
