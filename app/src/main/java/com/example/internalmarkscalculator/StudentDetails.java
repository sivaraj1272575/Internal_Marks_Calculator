package com.example.internalmarkscalculator;

import java.io.Serializable;

public class StudentDetails implements Serializable {
    public String name;
    public String rollNo;
    public int currentSubject,maxSubject,maxLabs;
    public Theory theory[];
    public Laboratory lab[];

    public StudentDetails(String name, String rollNo){
        this.name = name;
        this.rollNo = rollNo;
        this.currentSubject = 0;
        this.maxSubject = 5;
        this.maxLabs = 2;
        this.theory = new Theory[5];
        this.lab = new Laboratory[2];

        this.theory[0] = new Theory();
        this.theory[1] = new Theory();
        this.theory[2] = new Theory();
        this.theory[3] = new Theory();
        this.theory[4] = new Theory();

        this.lab[0] = new Laboratory();
        this.lab[1] = new Laboratory();

        this.theory[0].name = "Mobile Systems Engineering";
        this.theory[1].name = "Cryptography and Network security";
        this.theory[2].name = "Internet of Things";
        this.theory[3].name = "Cloud Computing";
        this.theory[4].name = "Artificial Intelligence";
        this.lab[0].name = "AI Lab";
        this.lab[1].name = "MSE Lab";

        this.theory[0].code = "15z703";
        this.theory[1].code = "15z704";
        this.theory[2].code = "15z008";
        this.theory[3].code = "15z003";
        this.theory[4].code = "15z701";
        this.lab[0].code = "15z710";
        this.lab[1].code = "15z711";
    }
}

class Theory implements Serializable{
    public String name;
    public String code;
    public float CA[];
    public float tut[];
    public float ap;
    public float aggCA;
    float total;

    public Theory(){
        this.name = "";
        this.code = "";
        this.CA = new float[3];
        this.tut = new float[2];
        this.ap = 0;
    }
    public void calculateMarks(){
        float min1 = Math.min(CA[1],CA[2]);
        this.aggCA = ((CA[0]+CA[1]+CA[2] - Math.min(CA[0],min1))/2)/40*25;
        this.total = this.aggCA+this.ap+this.tut[0]+this.tut[1];
    }

    public boolean validateMarks()
    {
        if((CA[0]>=0 && CA[0]<=40) && (CA[1]>=0 && CA[1]<=40) && (CA[2]>=0 && CA[2]<=40) && (ap>=0 && ap<=15) &&
                (tut[0]>=0 && tut[0]<=5) && (tut[1]>=0 && tut[1]<=5))
        {
            return true;
        }
        return false;
    }
}

class  Laboratory implements Serializable{
    public String name;
    public String code;
    public float preLab[];
    public float report[];
    public float total;

    public Laboratory(){
        this.name = "";
        this.code = "";
        this.preLab = new float[2];
        this.report = new float[2];
    }
    public void calculateMarks(){
        this.total = this.preLab[0]+this.preLab[1]+this.report[0]+this.report[1];
    }

    public boolean validateMarks(){
        if((preLab[0]>=0 && preLab[0]<=10) && (preLab[1]>=0 && preLab[1]<=10) && (report[0]>=0 && report[0]<=15)
            &&(report[1]>= 0&& report[1]<=15)){
            return true;
        }
        return false;
    }
}

