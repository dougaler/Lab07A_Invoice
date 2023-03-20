import java.util.stream.Stream;

public class title{
    String titleAll;
    String titleName;
    String addressPart;
    public String getFullTitle(String Address){
        addressPart = Address;
        titleName = String.format("%20s","INVOICE");
        titleAll = titleName + "\n" + addressPart + "\n"+ "===========================================================\n";

        return  titleAll;
    }
}
