package com.company.draft;

import com.company.Main;

public class Draft {


    public static void main(String[] args) {

        String cmd = "$PWON,OK$TCOP,1";
        for(String c : cmd.split("\\$")){
            Main.println(c);
        }
    }
}
