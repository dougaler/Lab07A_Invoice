import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.stream.Stream;

public class organizerFrame extends JFrame{
    JPanel mainPnl;
    JPanel titlePnl;
    JPanel inputPnl;
    JPanel displayPnl;
    JLabel titleLbl;
    JLabel addressLbl;
    JLabel itemLbl;
    JLabel quantLbl;
    JLabel costLbl;
    JLabel addLbl;

    JButton quitBtn;
    JButton addItemBtn;
    JButton createInvBtn;
    JTextArea getAddress;
    JTextArea getItemName;
    JTextArea getItemCost;
    JTextArea getItemQuant;
    ArrayList<String> allNames = new ArrayList<String>();
    ArrayList<Integer> allQuants = new ArrayList<Integer>();
    ArrayList<Double> allCosts = new ArrayList<Double>();
    JTextArea displayTA;
    JScrollPane scroller;

    Organizer theInvoice = new Organizer();
    public organizerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTitlePanel();
        mainPnl.add(titlePnl, BorderLayout.NORTH);

        createInputPanel();
        mainPnl.add(inputPnl, BorderLayout.CENTER);

        createDisplayPanel();
        mainPnl.add(displayPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(600, 900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void createTitlePanel()
    {
        titlePnl = new JPanel();
        titlePnl.setLayout(new GridLayout(5, 1));
        titleLbl = new JLabel("INVOICE", JLabel.CENTER);
        titleLbl.setFont(new Font("Courier", Font.BOLD,30));
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        addressLbl = new JLabel("Address:");
        getAddress = new JTextArea(3, 25);
        createInvBtn = new JButton("Create Invoice");
        createInvBtn.addActionListener((ActionEvent ae) ->{
            displayTA.append(theInvoice.getInvoice(getAddress.getText(),allNames,allQuants,allCosts));
        });

        titlePnl.add(titleLbl);
        titlePnl.add(addressLbl);
        titlePnl.add(getAddress);
        titlePnl.add(createInvBtn);
    }
    private void createInputPanel()
    {
        inputPnl = new JPanel();
        inputPnl.setLayout(new GridLayout(4, 2));

        addItemBtn = new JButton("Add Item");

        addItemBtn.addActionListener((ActionEvent ae) ->{
            allNames.add(getItemName.getText());
            allQuants.add(Integer.valueOf(getItemQuant.getText()));
            allCosts.add(Double.valueOf(getItemCost.getText()));
            getItemName.setText("");
            getItemCost.setText("");
            getItemQuant.setText("");
        });

        getItemName = new JTextArea(1, 25);
        getItemQuant = new JTextArea(1, 25);
        getItemCost = new JTextArea(1, 25);
        getItemCost.setBorder(BorderFactory.createEtchedBorder());
        getItemName.setBorder(BorderFactory.createEtchedBorder());
        getItemQuant.setBorder(BorderFactory.createEtchedBorder());
        itemLbl = new JLabel("Item Name:");
        quantLbl = new JLabel("Quantity:");
        costLbl = new JLabel("Cost:");
        addLbl = new JLabel("Click to Add Item:");

        inputPnl.add(itemLbl);
        inputPnl.add(getItemName);
        inputPnl.add(quantLbl);
        inputPnl.add(getItemQuant);
        inputPnl.add(costLbl);
        inputPnl.add(getItemCost);
        inputPnl.add(addLbl);
        inputPnl.add(addItemBtn);

    }
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();

        displayPnl.setLayout(new GridLayout(2, 1));

        displayTA = new JTextArea(15, 48);

        displayTA.setEditable(false);
        displayTA.setFont(new Font("Courier New", Font.PLAIN, 12));
        quitBtn = new JButton("Quit");

        quitBtn.addActionListener((ActionEvent ae) -> {System.exit(0);});

        scroller = new JScrollPane(displayTA);
        displayPnl.add(scroller);
        displayPnl.add(quitBtn);
        quitBtn.setSize(600, 10);
    }
}
