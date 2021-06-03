package _3_java_professional.homeworks.homework00;


public class Character implements Comparable<Character>{
    private String name;
    private String race;
    private String specialization;
    private Rank rank;
    private int power;


    public Character(){}

    public Character(String name, String race, String specialization, Rank rank, int power) {
        this.name = name;
        this.race = race;
        this.specialization = specialization;
        this.rank = rank;
        this.power = power;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int compareTo(Character c) {
        if(power < c.power){
            return 1;
        }
        if(power > c.power){
            return -1;
        }
        return 0;
    }


    @Override
    public String toString() {
        return specialization + " " + race + " " + name + ", ранг: " + rank + ", сила: " + power;
    }


    public enum Rank {
        SS, S, A, B, C, D;
    }

}
