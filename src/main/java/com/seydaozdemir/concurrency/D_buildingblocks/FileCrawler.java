package com.seydaozdemir.concurrency.D_buildingblocks;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

public class FileCrawler implements Runnable{
    private BlockingQueue<File> fileQueue;
    private FileFilter fileFilter;
    private File root;

    public void run(){

    }

    public void crawl(File root) throws InterruptedException {
        File[]entries= root.listFiles(fileFilter);
        if(entries!=null){
            for(File entry:entries){
                if(entry.isDirectory()){
                    crawl(entry);
                }else if(!alreadyIndexed(entry)){
                    fileQueue.put(entry);
                }
            }
        }
    }

    private boolean alreadyIndexed(File entry) {
        return !fileQueue.contains(entry);
    }
}
