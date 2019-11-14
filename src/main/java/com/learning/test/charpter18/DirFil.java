package com.learning.test.charpter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFil implements FilenameFilter {

    private Pattern pattern;

    public DirFil(String name){
        pattern = Pattern.compile(name);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
