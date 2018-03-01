package com.baidu.common.test.service.folder;

import java.io.File;

public class CreateFile {
    public static void mkDir(File file) {
        if (file.getParentFile().exists()) {
            file.mkdir();
        } else {
            mkDir(file.getParentFile());
            file.mkdir();
        }
    }

    public static void main(String[] args) {
        File file = new File("c:/2/1/s/e");
        mkDir(file);
    }
}
