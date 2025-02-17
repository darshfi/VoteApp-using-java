import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FrontEnd {
    // Array to store the checkboxes for each group
    static JCheckBox[] headBoyOptions = new JCheckBox[4];
    static JCheckBox[] headGirlOptions = new JCheckBox[4];
    static JCheckBox[] viceHeadBoyOptions = new JCheckBox[4];
    static JCheckBox[] viceHeadGirlOptions = new JCheckBox[4];

    public void createGUI() {
        JFrame la = new JFrame("VOTING");
        la.setResizable(false);
        la.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        la.getContentPane().setBackground(new Color(0xA9EF78));
        la.setLayout(new GridLayout(1, 1));
        la.setExtendedState(JFrame.MAXIMIZED_BOTH);la.setUndecorated(true);
        la.setVisible(true);
        la.setFocusable(false);

        JPanel main = new JPanel(new GridLayout(0, 1));
        main.setBackground(new Color(0xA9EF78));

        JMenuBar bar = new JMenuBar();
        bar.setBackground(Color.lightGray);
        JMenu menu = new JMenu("NOTA: None of the above");
        JMenuItem set = new JMenuItem("Save");
        JMenuItem close = new JMenuItem("Close");

        close.addActionListener(_ -> System.exit(0));
        set.addActionListener(_ -> BackEnd.saveResults());

        menu.add(set);
        menu.addSeparator();
        menu.add(close);
        bar.add(menu);
        la.setJMenuBar(bar);
        addVotingOptions(main);
        BackEnd.initialize();
        la.add(main);
    }

    private void addVotingOptions(JPanel main) {
        main.add(createTitlePanel("HEADBOY OPTIONS:"));
        JPanel hbPanel = createCheckBoxPanel(headBoyOptions, "Candidate 1", "Candidate 2", "Candidate 3", "NOTA");
        main.add(hbPanel);

        main.add(createTitlePanel("HEADGIRL OPTIONS:"));
        JPanel hgPanel = createCheckBoxPanel(headGirlOptions, "Candidate 1", "Candidate 2", "Candidate 3", "NOTA");
        main.add(hgPanel);

        main.add(createTitlePanel("VICE HEADBOY OPTIONS:"));
        JPanel vhbPanel = createCheckBoxPanel(viceHeadBoyOptions, "Candidate 1", "Candidate 2", "Candidate 3", "NOTA");
        main.add(vhbPanel);

        main.add(createTitlePanel("VICE HEADGIRL OPTIONS:"));
        JPanel vhgPanel = createCheckBoxPanel(viceHeadGirlOptions, "Candidate 1", "Candidate 2", "Candidate 3", "NOTA");
        main.add(vhgPanel);

        JPanel submit = new JPanel();
        JButton sub = new JButton("Submit");
        sub.addActionListener(_ -> BackEnd.submitVote());
        submit.setLayout(new GridLayout(1, 1));
        submit.setBackground(new Color(0xA9EF78));
        submit.add(sub);
        main.add(submit);
    }

    private JPanel createTitlePanel(String title) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel label = new JLabel("<html><span style='font-weight:bold;font-size:20pt;'>" + title + "</span></html>");
        panel.setBackground(new Color(0xA9EF78));
        panel.add(label);
        return panel;
    }

    private JPanel createCheckBoxPanel(JCheckBox[] group, String... labels) {
        JPanel panel = new JPanel(new GridLayout(1, labels.length, 5, 1));
        panel.setBackground(new Color(0xA9EF78));

        // Initialize the checkboxes for this group
        for (int i = 0; i < labels.length; i++) {
            group[i] = createCheckbox(labels[i]);
            panel.add(group[i]);
        }

        // Add action listeners to ensure only one checkbox can be selected per group
        for (JCheckBox checkBox : group) {
            checkBox.addActionListener(createSelectionListener(checkBox, group));
        }

        return panel;
    }

    private JCheckBox createCheckbox(String text) {
        JCheckBox check = new JCheckBox("<html><span style='font-weight:bold;font-size:20pt;'>" + text + "</span><html>");
        check.setBackground(new Color(16381678));
        return check;
    }

    private ActionListener createSelectionListener(JCheckBox selected, JCheckBox[] group) {
        return _ -> {
            for (JCheckBox checkBox : group) {
                if (checkBox != selected) {
                    checkBox.setSelected(false);
                }
            }
        };
    }
}
