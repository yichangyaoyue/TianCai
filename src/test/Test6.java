package test;

import java.io.*;

public class Test6 {

    public static void main(String[] args) {
        File to = new File("d:/img");
        if (!to.exists()) {
            to.mkdirs();
        }
        File from = new File("d/");
        copyAllImage(from,to);

    }


    private static void copyAllImage(File from, File to) {
        //获取文件列表
        File[] files = from.listFiles();
        if (files == null) {
            return;
        }
        for (File file :
                files) {
            if (file.isDirectory()) {
                copyAllImage(file, to); //使用递归寻找文件，排除文件夹
            } else {
                //获取文件名
                String fileName = file.getName();
                if (fileName.endsWith(".jpg") || fileName.endsWith(".png")) {
                    File newFile = new File(to, fileName);
                    try {
                        FileInputStream in = new FileInputStream(file);
                        FileOutputStream out = new FileOutputStream(newFile);
                        byte[] b = new byte[1024];
                        int len = 0;
                        while ((len = in.read(b)) != -1) {
                            out.write(b, 0, len);
                        }
                        out.flush();
                        out.close();
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }


            }
        }


    }


}
