package com.company.Classes;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Interactions {
    private String inter_id;
    private String DoI;
    private Leads lead;
    private String Means;
    private String Potential;

    public Interactions(){

    }

    public String getId(){
        return inter_id;
    }

    public void setInter_id(String inter_id){
        this.inter_id = inter_id;
    }

    public String getDoI(){
        return DoI;
    }

    public void setDoI(String DoI){
        this.DoI = DoI;
    }

    public Leads getLead_id(){
        return lead;
    }

    public void setLead_id(Leads Lead_id){
        this.lead = Lead_id;
    }

    public String getMeans(){
        return Means;
    }

    public void setMeans(String Means){
        this.Means = Means;
    }

    public String getPotential(){
        return Potential;
    }

    public void setPotential(String Potential){
        this.Potential = Potential;
    }

    @Override
    public String toString() {
        return "ID: "+inter_id +", DOI: " + DoI + ", lead_ID: " + lead.getLead_id() + ", Interaction Method: " + Means + ", Potential: "
                + Potential;
    }


}