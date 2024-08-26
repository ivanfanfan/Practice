package com.ivan.nio.path;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Path1 {
    public static void main(String[] args) {
//        Path is shorthand of FileSystems.getDefault()
//        Path aDefault = FileSystems.getDefault().getPath("a", "b", "c");
//        Path path = Paths.get("a", "b", "c");

        // create Path
        Path path = Paths.get(System.getProperty("user.home"), "wangyifanPath", "c");
        System.out.println(path);

    }
}
