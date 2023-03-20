import java.util.ArrayList;

public class items{
    String fullItems;

    double totalMonees = 0;
    String allFields = "\n";
    public String getFullItems(ArrayList<String> names,ArrayList<Integer> quantity, ArrayList<Double> cost){
        String itemLabel = String.format("%-24s","Items:");
        String qtyLabel = String.format("%-8s","Qty:");
        String costLabel = String.format("%-8s","Cost:");
        String totCostLabel = String.format("%-24s","Total Cost: ");
        String item;
        int num;
        double monee;
        double morMonee;
        for(int i = 0; i < names.size(); i++){
            item = names.get(i);
            num = quantity.get(i);
            monee = cost.get(i);
            morMonee = num * monee;
            totalMonees = totalMonees + morMonee;
            allFields = allFields + String.format("%-24s",item) + String.format("%-8s",num) +String.format("%-8s",String.format("%.2f",monee)) + String.format("%-8s",String.format("%.2f", morMonee)) +"\n";
        }
        fullItems = itemLabel + qtyLabel + costLabel + totCostLabel + "\n" + allFields + "\n" + "===========================================================\n";
        return fullItems;
    }
}
