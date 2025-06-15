import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Info about: https://docs.oracle.com/javase/8/docs/api/java/awt/package-summary.html
public class AppGUI extends Frame {
    public AppGUI() {
        super("JavaBudget");

        setLayout(new BorderLayout());

        //TODO: Fix to actually include proper and dynamic debit structure.
        Panel leftPanel = new Panel(new GridLayout(3, 1));
        leftPanel.add(new Label("Debits:"));
        leftPanel.add(new Label("Debits:"));
        leftPanel.add(new Label("Debits:"));
        //TODO: Adapt to comfortable screen size.
        setSize(600, 400);
        setVisible(true);
    
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new AppGUI();
    }
}