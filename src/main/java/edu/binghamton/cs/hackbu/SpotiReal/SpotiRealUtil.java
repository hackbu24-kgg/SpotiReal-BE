package edu.binghamton.cs.hackbu.SpotiReal;

import java.io.*;

public class SpotiRealUtil {
    static String clientid;
    static String clientsecret;

    static void readClientInfo() throws IOException, FileNotFoundException
    {
        File idfile = new File("..\\..\\..\\..\\..\\..\\..\\..\\client.id");
        File secretfile = new File("..\\..\\..\\..\\..\\..\\..\\..\\client.secret");

        BufferedReader br = new BufferedReader(new FileReader(idfile));
        clientid = br.readLine();
        br = new BufferedReader(new FileReader(secretfile));
        clientsecret = br.readLine();
    }
}
