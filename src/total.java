import java.util.ArrayList;
import java.util.stream.Stream;
public class total{
    String itsTheTotal;
    public String getTotalStuff(ArrayList<Integer> quantity, ArrayList<Double> cost){
        int num;
        double monee;
        double morMonee;
        double totalMonees = 0;
        for(int i = 0; i < cost.size(); i++) {
            num = quantity.get(i);
            monee = cost.get(i);
            morMonee = num * monee;
            totalMonees = totalMonees + morMonee;
        }
        itsTheTotal = "AMOUNT DUE: " + totalMonees +"\n";
        return itsTheTotal;
    }
}
