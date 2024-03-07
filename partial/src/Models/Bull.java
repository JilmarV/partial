/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author jilssa
 */
public class Bull {
    private String name;
    private String race;
    private String owner;
    private float weight;
    //bewteen 1 to 10
    private int agressivenessLevel;

    public Bull(String name, String race, String owner, float weigth, int agressivenessLevel) {
        this.name = name;
        this.race = race;
        this.owner = owner;
        this.weight = weigth;
        this.agressivenessLevel = agressivenessLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weigth) {
        this.weight = weigth;
    }

    public int getAgressivenessLevel() {
        return agressivenessLevel;
    }

    public void setAgressivenessLevel(int agressivenessLevel) {
        this.agressivenessLevel = agressivenessLevel;
    }
    
}
