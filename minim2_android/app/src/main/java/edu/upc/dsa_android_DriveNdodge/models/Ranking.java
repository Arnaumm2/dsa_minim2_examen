package edu.upc.dsa_android_DriveNdodge.models;

public class Ranking {
    private String name;
    private String avatar;
    private int points;

    public Ranking(){

    }
    public Ranking(String name, String avatar, int points){
        this.name = name;
        this.avatar = avatar;
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){return this.name;}
    public void setAvatar(String avatar){this.avatar=avatar;}
    public String getAvatar(){return this.avatar;}
    public void setPoints(int points){this.points=points;}
    public int getPoints(){return this.points;}

}
