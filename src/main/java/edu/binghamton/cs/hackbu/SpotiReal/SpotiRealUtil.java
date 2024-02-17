package edu.binghamton.cs.hackbu.SpotiReal;

import java.io.*;
import java.nio.Buffer;

public class SpotiRealUtil {

    public static String getEnvi() throws IOException, FileNotFoundException {
        File file = new File("envi");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String envi = br.readLine();
        br.close();
        return envi;
    }
    public static String getClientID() throws IOException, FileNotFoundException
    {
        File file = new File("client.id");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String clientid = br.readLine();
        br.close();
        return clientid;
    }

    public static String getClientSecret() throws IOException, FileNotFoundException
    {
        File file = new File("client.secret");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String secret = br.readLine();
        br.close();
        return secret;
    }
}
