package com.seydaozdemir.concurrency.C_composingobjects;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class VisualComponent {
    /**
     * For example, it would be safe to publish mouseListeners or keyListeners in VisualComponent.
     * Because VisualComponent does not impose any constraints on the valid states of its listener lists,
     * these fields could be made public or otherwise published without compromising thread safety.
     */
    private final List<KeyListener> keyListeners=new CopyOnWriteArrayList<>();
    private final List<MouseListener> mouseListeners=new CopyOnWriteArrayList<>();

    public void addKeyListener(KeyListener keyListener){
        this.keyListeners.add(keyListener);
    }

    public void addMouseListener(MouseListener mouseListener){
        this.mouseListeners.add(mouseListener);
    }
}
