package com.company;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class calculator extends JFrame implements ActionListener {

    // создать рамку

    static JFrame f;
    // создать текстовое поле
    static JTextField l;
    // сохраняем оператор и операнды

    String s0, s1, s2;
    // по умолчанию constrcutor

    calculator() {
        s0 = s1 = s2 = "";
    }
    // основная функция

    public static void main(String args[]) {
        // создать рамку

        f = new JFrame("calculator");

        try {

            // установить внешний вид

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {

            System.err.println(e.getMessage());

        }
        // создаем объект класса

        calculator c = new calculator();
        // создать текстовое поле

        l = new JTextField(16);
        // установить текстовое поле как недоступное для редактирования

        l.setEditable(false);
        // создаем цифровые кнопки и некоторые операторы

        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
        // создаем цифровые кнопки

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // кнопка равно

        beq1 = new JButton("=");

        // создаем кнопки оператора
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");

        // Создайте . кнопка

        be = new JButton(".");


        // создать панель

        JPanel p = new JPanel();
        // добавить слушателей действия
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);
        // добавляем элементы на панель
        p.add(l);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);

        // установить фон панели
        p.setBackground(Color.blue);


        // добавить панель в рамку
        f.add(p);
        f.setSize(200, 220);
        f.show();

    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        // если значение является числом
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {

            // если операнд присутствует, то добавляем ко второму нет

            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;
            // установить значение текста
            l.setText(s0 + s1 + s2);

        } else if (s.charAt(0) == 'C') {

            // очистить одну букву
            s0 = s1 = s2 = "";
            // установить значение текста
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {
            double te;
            // сохранить значение в 1-ом

            if (s1.equals("+"))

                te = (Double.parseDouble(s0) + Double.parseDouble(s2));

            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
            // установить значение текста
            l.setText(s0 + s1 + s2 + "=" + te);
            // преобразовать его в строку
            s0 = Double.toString(te);

            s1 = s2 = "";

        } else {

            // если не было операнда

            if (s1.equals("") || s2.equals(""))
                s1 = s;
                // остальное оценить
            else {
                double te;
                // сохранить значение в 1-ом
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
                // преобразовать его в строку
                s0 = Double.toString(te);

                // разместить оператора
                s1 = s;
                // сделать операнд пустым
                s2 = "";
            }
            // установить значение текста
            l.setText(s0 + s1 + s2);

        }

    }

}