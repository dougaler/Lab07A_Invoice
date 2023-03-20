import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Organizer {
    String wholeInv;
    String fullAddress;
    ArrayList<String> itemNames;
    ArrayList<Integer> itemQuant;
    ArrayList<Double> itemCost;
    title titlePart = new title();
    items itemPart = new items();
    total totalPart = new total();
    public String getInvoice(String address, ArrayList<String> names,ArrayList<Integer> quantity, ArrayList<Double> cost){
        fullAddress = address;
        itemNames = names;
        itemQuant = quantity;
        itemCost = cost;
        wholeInv = titlePart.getFullTitle(fullAddress) + itemPart.getFullItems(names,quantity,cost) + totalPart.getTotalStuff(quantity, cost);
        return wholeInv;
    }


}
