package org.Frozen;


public class Main{

     public static Frame frame;
     public static Patches patches;

    public static void main(String[] args) {
        patches = new Patches();
        frame = new Frame();
        for (int i = 0;i <= 63;i++){
            frame.add(Patches.allPatch.get(i));
        }
        new Baseboard();
        frame.pack();



    }
}
