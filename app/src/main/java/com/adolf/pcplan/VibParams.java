package com.adolf.pcplan;

import java.io.Serializable;

public class VibParams implements Serializable {

    private String model;
    private int loop;

    public VibParams(String model, int loop) {
        this.model = model;
        this.loop = loop;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }
}
