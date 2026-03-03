package kashif;

import javax.swing.*;
import java.awt.*;

public class gui extends JFrame{
    private JTextField longurlfield;
    private JTextField shorturlfield;
    private JButton shortbutton,expandbutton;

    private url s=new url();

    public gui(){
        setTitle("URL Shortener Application");
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2,10,10));

        longurlfield=new JTextField();
        shorturlfield=new JTextField();
        shortbutton=new JButton("Shorten URL");
        expandbutton=new JButton("Expand URL");

        add(new JLabel("Long URL:"));
        add(longurlfield);
        add(new JLabel("Short URL:"));
        add(shorturlfield);
        add(shortbutton);
        add(expandbutton);

        shortbutton.addActionListener(e->{
            String longurl=longurlfield.getText().trim();
            if(longurl.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter a Long URL!");
                return;
            }
            String shorturl=s.shorturl(longurl);
            shorturlfield.setText(shorturl);
        });

        expandbutton.addActionListener(e->{
            String shorturl=shorturlfield.getText().trim();
            if(shorturl.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter a Short URL!");
                return;
            }
            String original=s.expandurl(shorturl);
            longurlfield.setText(original);
        });
        setVisible(true);
}
    public static void main(String[] args) {
        new gui();
    }
}
