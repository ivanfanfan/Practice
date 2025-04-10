package com.ivan.character;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FamiliarWord {

    private static final String ORIGINAL_FILE_PATH = "D:\\ivan-project\\Practice\\PRE_introduction_to_algorithms.txt";
    private static final String FAMILIAR_FILE_PATH = "D:\\ivan-project\\Practice\\exclusive.txt";
    private static final String ALREADY_LEARN_FILE_PATH = "D:\\ivan-project\\Practice\\ALREADY_introduction_to_algorithms.txt";
    private static final String UNFAMILIAR_FILE_PATH = "D:\\ivan-project\\Practice\\UNFAM_introduction_to_algorithms.txt";



    public static Set<String> getWordByFile(String path) throws IOException{
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Set<String> wordList = new HashSet<String>();
        String line;
        while((line = bufferedReader.readLine()) != null){
            wordList.add(line);
        }
        bufferedReader.close();
        return wordList;
    }
    public static void main(String[] args) throws IOException {
//        Set<String> alreadyLearn = getWordByFile(ALREADY_LEARN_FILE_PATH);
        writeFamiliarWord(UNFAMILIAR_FILE_PATH,FAMILIAR_FILE_PATH,ORIGINAL_FILE_PATH);

    }

    private static void writeFamiliarWord(String unfamiliarWordPath,String familiarFilePath,String originalFilePath) throws IOException {
        Set<String> unfamiliarWord = getWordByFile(unfamiliarWordPath);
        Set<String> oldFamiliarWord = getWordByFile(familiarFilePath);
        Set<String> newFamiliarWord = new HashSet<>();
        FileReader fileReader = new FileReader(originalFilePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(familiarFilePath, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] words = line.split("[^a-zA-Z'-]+");
            newFamiliarWord.addAll(Arrays.asList(words));
        }
        for (String s : newFamiliarWord) {
            if(!oldFamiliarWord.contains(s) && !unfamiliarWord.contains(s)){
                bufferedWriter.write(s + "\n");
            }
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
