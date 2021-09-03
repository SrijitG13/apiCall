import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class frame {
    public frame(){
 
        //String selected = "";
 
        JTextField textField = new JTextField();
        textField.setBounds(100, 100, 300, 50);
        textField.setLayout(null);
        textField.setFont(new Font("Aerial", Font.PLAIN, 15));
 
        JLabel label = new JLabel();
        label.setLayout(null);
        label.setForeground(Color.black);
        label.setBounds(100, 200, 500, 200);
 
        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setLayout(null);
        comboBox.setBounds(100, 20, 100, 30);
        //comboBox.addItem("Instagram");
        //comboBox.addItem("Github");
        //comboBox.addItem("Covid-19");
        comboBox.addItem("Herokuapp");
 
        JButton button = new JButton("GET");
        button.setBounds(450, 100, 100, 50);
        button.setFocusable(false);
        button.setBackground(Color.green);
        button.setForeground(Color.white);
        button.setFont(new Font("Comic Sans", Font.BOLD, 20));
        button.addActionListener(e -> {
            String s = textField.getText();
            try {
                new apiCall();
                String link = comboBox.getSelectedItem().toString();
 
                /*if(link.equals("Instagram")) {
                    link = "https://www.instagram.com/"+s+"/?__a=1";
                }
                else if(link.equals("Github")) {
                    link = "https://api.github.com/users/"+s;
                }
                else if(link.equals("Covid-19")) {
                    link = "https://covid19.mathdro.id/api";
                }*/
                if(link.equals("Herokuapp")) {
                    link = "https://javademoapi.herokuapp.com/data/{}";
                }
                String data = apiCall.get(s, link);
                //System.out.println(data);
                label.setText(data);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        button.setLayout(null);
 
        JFrame frame = new JFrame("Api Calling System");
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(3);
        frame.setLocationRelativeTo(null);
        frame.add(textField);
        frame.add(button);
        frame.add(comboBox);
        frame.add(label);
        frame.setLayout(null);
        frame.setVisible(true);
 
    }
 
    public static void main(String[] args) {
        new frame();
    }
}