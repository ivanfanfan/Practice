package com.ivan.data;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class DataStreamDemo {
    static final String dataFile = "invoicedata.txt";

    static final double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
    static final int[] units = {12, 8, 13, 29, 50};
    static final String[] descs = {
            "Java T-shirt",
            "Java Mug",
            "Duke Juggling Dolls",
            "Java Pin",
            "Java Key Chain"
    };

    public static void main1(String[] args) throws IOException {

        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

        for (int i = 0; i < prices.length; i++) {
            out.writeDouble(prices[i]);
            out.writeInt(units[i]);
            out.writeUTF(descs[i]);
        }
        out.flush();
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

        double price;
        int unit;
        String desc;
        double total = 0.0;
        try {
            while (true) {
                price = in.readDouble();
                unit = in.read();
                desc = in.readUTF();
                System.out.format("You ordered %d" + "units of %s at $%.2f%n", unit, desc, price);
                total += unit * price;
            }
        } catch (EOFException e) {

        }
        in.close();
        System.out.format("Total cost %.2f", total);

    }

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        URI src = new URI("http", null,"10.90.20.115",5000,"/src",null,null  );
        String string = src.toString();
        System.out.println(string);
    }
}
