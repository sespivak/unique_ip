package com.ecwid.ip4count;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IpSource {
    private BufferedReader bufferedReader;

    public IpSource(String ipFileName) {
        try {
            FileReader fileReader = new FileReader(ipFileName);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    public String getIp() {
        String res = "";
        try {
            res = bufferedReader.readLine();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
