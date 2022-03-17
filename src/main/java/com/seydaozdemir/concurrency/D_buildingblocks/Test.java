package com.seydaozdemir.concurrency.D_buildingblocks;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        File file=new File("test.txt");
        Writer writer=new FileWriter(file);
        String s="hello java world111";
//        for(char c:s.toCharArray()){
//            writer.write(c);
//        }
        writer.write(s);
        writer.close();
        String r=null;
        try(var is=new BufferedInputStream(new FileInputStream(file))){
            StringBuilder sb=new StringBuilder();
            int b;
            while((b=is.read())!=-1){
                sb.append((char)b);
            }
            r=sb.toString();
        }catch (Exception e){

        }
        System.out.println(r);

    }
}
