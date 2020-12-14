package com.example.mobilepo.model.files;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TxtFile {
    private String fname = "myfile.txt";
    private Context ctx;
    private final static String TAG = "File:";

    public TxtFile(Context context){
        this.ctx = context;
    }

    public void write(String str){
        try {
            File file = new File(ctx.getFilesDir() + fname);
            if (!file.exists()) {
                Log.d(TAG, "create file");
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file, false);
            fos.write(str.getBytes());
        }  catch(FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        }  catch(IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        Log.d(TAG, "end write");
    }

    public String read(){
        String line = "";
        try {
            FileInputStream fileInputStream = new FileInputStream (new File(ctx.getFilesDir() + fname));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            while ( (line = bufferedReader.readLine()) != null ) {
                stringBuilder.append(line);
            }
            fileInputStream.close();
            line = stringBuilder.toString();
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            Log.d(TAG, ex.getMessage());
        }
        catch(IOException ex) {
            Log.d(TAG, ex.getMessage());
        }
        Log.d(TAG, "end read");
        return line;
    }
}
