package com.ivan.characterStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 中文
 * 31886��
 * 28000�
 * 21614��
 * 29300��
 * 37817�
 * 57789��
 * 58637��
 * 28000�
 * 21057��
 * 28229��
 * 29785�
 * 20345��
 * 26870��
 * 29785�
 * 65533?
 */
public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        FileReader inputStream = null;
        FileWriter outputStream = null;
        try{
            inputStream = new FileReader("java-io/abc/china.txt");
            outputStream = new FileWriter("java-io/abc/china1.txt");

            int c;
            // the int variable holds a character value in its last 16bits
            while ((c = inputStream.read())!= -1){
                outputStream.write(c);
                System.out.print(c);
                System.out.println(Character.toChars(c));
            }
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
