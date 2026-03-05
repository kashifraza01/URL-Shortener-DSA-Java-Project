package kashif;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    private final JTextField luf;  //luf=longurlfield
    private final JTextField suf;  //suf=shorturlfield

    private final Url s=new Url();

    public Gui(){
        setTitle("URL Shortener Application");
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        luf=new JTextField();
        suf=new JTextField();
        JButton sb = new JButton("Shorten URL");
        //sb=shortbutton, eb= expandbutton
        JButton eb = new JButton("Expand URL");

        add(new JLabel("Long URL:"));
        add(luf);
        add(new JLabel("Short URL:"));
        add(suf);
        add(sb);
        add(eb);

        sb.addActionListener(e->{
            String lu=luf.getText().trim();
            if (lu.isEmpty()){ JOptionPane.showMessageDialog(null, "please enter a Long URL!"); return; }
            String su=s.shorturl(lu);
            suf.setText(su);
        });
        
        eb.addActionListener(e->{
            String su = suf.getText().trim();
            if (su.isEmpty()){ JOptionPane.showMessageDialog(null, "please enter a Short URL!"); return; }
            String original = s.expandurl(su);
            luf.setText(original);
        });
        setVisible(true);
    }
    public static void main(String[] args){
        new Gui();
    }
}
