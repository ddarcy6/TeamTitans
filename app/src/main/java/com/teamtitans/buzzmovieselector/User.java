package com.teamtitans.buzzmovieselector;

/**
 * Created by Alex on 2/15/2016.
 */
public class User {

    public enum MajorDegree {
        CS, INTA, CHBE, ME, AE, CM, MSE, NRE, BA, ARCH, ID, BME, CE, COMPE, EE,
        ECON, EIA, BIO, PHYS, MATH, EAS, PSYCH, CHEM
    }

    private String name;
    private int year;
    private String password;
    private String majorStr;
    private MajorDegree major;

    public User(String password) {
        this.password = password;
    }

    public void setName(String input) {
        this.name = input;
    }

    public void setMajorStr(String input) {
        majorStr = input;
    }

    public String getMajorStr() {
        return majorStr;
    }

    public String getName() {
        return name;
    }

    public void setYear(int input) {
        this.year = input;
    }

    public int getYear() {
        return year;
    }

    public void setPassword(String input) {
        this.password = input;
    }

    public String getPassword() {
        return password;
    }

    public void setMajor(MajorDegree input) {
        this.major = input;
    }

    public MajorDegree getMajor() {
        return major;
    }

}
