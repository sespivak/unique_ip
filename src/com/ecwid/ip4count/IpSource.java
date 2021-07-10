package com.ecwid.ip4count;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IpSource {
    private BufferedReader bufferedReader;

    public IpSource(String ipFileName) {
        try {
            FileReader fileReader = new FileReader(ipFileName);
            this.bufferedReader = new BufferedReader(fileReader);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getIp() {
        String res = "";
        try {
            res = this.bufferedReader.readLine();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
