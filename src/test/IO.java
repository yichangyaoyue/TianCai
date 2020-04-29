package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IO {

    public static void main(String[] args) throws IOException {

        ioTest();


    }

    public static void test02() {

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            new FileInputStream("   ");
            new FileOutputStream("  ");
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1) {
                fos.write(b, 0, len);
            }


        } catch (IOException e) {
            System.out.println("文件未找到异常");

        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }


    }


    public static void ioTest() throws IOException {

        FileInputStream fis = new FileInputStream("IO流.txt");
        FileOutputStream fos = new FileOutputStream("copy.txt");
        byte[] b = new byte[2014];
        int len;
        while ((len = fis.read(b)) != -1) {
            fos.write(b);


        }
        //关流
        fos.close();
        fis.close();

    }


}
