package pers.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyJavaProcess {

    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("python /Users/benjamin/Documents/pytest.py");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line ;
            while (null != (line = bufferedReader.readLine())){
                System.out.println(line);
            }
            bufferedReader.close();

            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
