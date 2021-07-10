package com.ecwid.ip4count;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IpSource {
    BufferedReader ipFile;

    public IpSource(String ipFileName) {
        try {
            FileReader reader = new FileReader(ipFileName);
            this.ipFile = new BufferedReader(reader);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public String getIp() {
        String res = "";
        try {
            res = this.ipFile.readLine();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
