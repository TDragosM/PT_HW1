import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterfGraf extends JFrame implements ActionListener {
    private JLabel polyLabel;
    private JTextField polyField;
    private JLabel polyLabel2;
    private JTextField polyField2;
    private JLabel resLabel;
    private JTextField resField;
    private JButton aduna;
    private JButton scade;
    private JButton inmultire;
    private JButton impartire;
    private JButton integrare;
    private JButton derivare;
    private JButton clear;
    public InterfGraf (){
        setTitle("Calculator Polinomial");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(3,2));
        polyLabel=new JLabel("Polinom 1: ");
        panel.add(polyLabel);
        polyField=new JTextField();
        panel.add(polyField);
        polyLabel2=new JLabel("Polinom 2: ");
        panel.add(polyLabel2);
        polyField2=new JTextField();
        panel.add(polyField2);
        resLabel=new JLabel("Rezultat: ");
        panel.add(resLabel);
        resField=new JTextField();
        resField.setEditable(false);
        panel.add(resField);


        //calculate=new JButton("Calculeaza");
        //calculate.addActionListener(this);
        //egal = new JButton("Rezultat");
        //egal.addActionListener(this);

        aduna=new JButton("Aduna");
        aduna.addActionListener(this);

        scade=new JButton("Scade");
        scade.addActionListener(this);

        inmultire=new JButton("Inmultire");
        inmultire.addActionListener(this);

        impartire=new JButton("Impartire");
        impartire.addActionListener(this);

        integrare=new JButton("Integrare");
        integrare.addActionListener(this);

        derivare=new JButton("Derivare");
        derivare.addActionListener(this);

        clear=new JButton("Clear");
        clear.addActionListener(this);

        JPanel panouButoane=new JPanel(new FlowLayout());
        //panouButoane.add(calculate);
        panouButoane.add(aduna);
        panouButoane.add(scade);
        panouButoane.add(impartire);
        panouButoane.add(inmultire);
        panouButoane.add(integrare);
        panouButoane.add(derivare);
        panouButoane.add(clear);
        //panouButoane.add(egal);

        Container panouContinut=getContentPane();
        panouContinut.add(panel,BorderLayout.CENTER);
        panouContinut.add(panouButoane,BorderLayout.SOUTH);
    }


    public void actionPerformed(ActionEvent e) {
        resField.setText("");
        String poly = polyField.getText().trim();
        String poly2 = polyField2.getText().trim();
        String polyPattern = "([-+]?\\d*\\.?\\d*x\\^\\d+)";
        //String monoPattern = "([-+]?\\d*\\.?\\d*)(?:\\*x\\^)([-+]?\\d+)";
        Pattern pattern = Pattern.compile(polyPattern);
        Matcher matcher = pattern.matcher(poly);

        Pattern pattern2 = Pattern.compile(polyPattern);
        Matcher matcher2 = pattern2.matcher(poly2);
        Polinom p1 = new Polinom();
        while (matcher.find()) {
            String monom = matcher.group(1);
            String[] parts = monom.split("x\\^");
            double coef = Double.parseDouble(parts[0]);
            double exp = Double.parseDouble(parts[1]);
            p1.addMonom(exp, coef);
        }
        //System.out.println("p1 is empty=" +p1.valori.isEmpty());
        Polinom p2 = new Polinom();
        while (matcher2.find()) {
            String monom = matcher2.group(1);
            String[] parts = monom.split("x\\^");
            double coef = Double.parseDouble(parts[0]);
            double exp = Double.parseDouble(parts[1]);
            p2.addMonom(exp, coef);
        }
        //System.out.println("p2 is empty=" +p2.valori.isEmpty());
        if (e.getSource() == aduna) {
            Polinom result = Operatii.sumPolinom(p1, p2);
            //System.out.println(result.valori.isEmpty());
            String currentText = resField.getText();
            for (Double key : result.valori.keySet()) {
                currentText += toString(result.valori.get(key), "x", key);
            }
            resField.setText(currentText);
        }
        if (e.getSource() == scade) {
            Polinom result = Operatii.scadPolinom(p1, p2);
            //System.out.println(result.valori.isEmpty());
            String currentText = resField.getText();
            for (Double key : result.valori.keySet()) {
                currentText += toString(result.valori.get(key), "x", key);
            }
            resField.setText(currentText);
        }
        if (e.getSource() == clear) {

        }
        /*
        if (e.getSource() == impartire) {
            Polinom result = Operatii.impartirePolinom(p1, p2);
            //System.out.println(result.valori.isEmpty());
            String currentText = resField.getText();
            for (Double key : result.valori.keySet()) {
                currentText += toString(result.valori.get(key), "x", key);
            }
            resField.setText(currentText);
        }
        */

        if (e.getSource() == inmultire) {
            Polinom result = Operatii.inmultirePolinom(p1, p2);
            //System.out.println(result.valori.isEmpty());
            String currentText = resField.getText();
            for (Double key : result.valori.keySet()) {
                currentText += toString(result.valori.get(key), "x", key);
            }
            resField.setText(currentText);
        }
        if (e.getSource() == derivare) {
            Polinom result = Operatii.derivare(p1);
            //System.out.println(result.valori.isEmpty());
            String currentText = resField.getText();
            for (Double key : result.valori.keySet()) {
                currentText += toString(result.valori.get(key), "x", key);
            }
            resField.setText(currentText);
        }
        if (e.getSource() == integrare) {
            Polinom result = Operatii.integrare(p1);
            //System.out.println(result.valori.isEmpty());
            String currentText = resField.getText();
            for (Double key : result.valori.keySet()) {
                currentText += toString(result.valori.get(key), "x", key);
            }
            resField.setText(currentText);
        }

    }

    private String toString(Double coef, String x, Double key) {
        if (coef>=0){
            String fin=new String("+"+coef.toString()+"x^"+key.toString());
            return fin;
        }
        else{
            String fin=new String(coef.toString()+"x^"+key.toString());
            return fin;
        }


    }



}
