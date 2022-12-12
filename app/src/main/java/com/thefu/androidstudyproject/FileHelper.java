package com.thefu.androidstudyproject;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;

public class FileHelper {

    private Context context;

    public FileHelper() {

    }

    public FileHelper(Context context) {
        super();
        this.context = context;
    }

    /**
     * 这里定义的是一个文件保存的方法，写入到文件中，所以是输出流
     * @param fileName
     * @param fileContent
     * @throws Exception
     */
    public void save(String fileName, String fileContent) throws Exception {
        //这里使用私有模式，创建出来的文件只能被本应用访问，还会覆盖原文件
        FileOutputStream output = context.openFileOutput(fileName, Context.MODE_PRIVATE);
        output.write(fileContent.getBytes()); //将String字符串以字节的形式写入到输出流中
        output.close();
    }

    /**
     * 这里定义的是文件读取的方法
     * @param fileName
     * @return
     * @throws IOException
     */
    public String read(String fileName) throws IOException {
        //打开文件输入流
        FileInputStream input = context.openFileInput(fileName);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;
        //读取文件内容
        while ((len = input.read(temp)) > 0) {
            sb.append(new String(temp, 0, len));
        }
        //关闭输入流
        input.close();
        return sb.toString();
    }

}
