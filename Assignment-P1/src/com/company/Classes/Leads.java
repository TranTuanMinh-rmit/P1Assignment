package com.company.Classes;

public class Leads {

    private String lead_id;
    private String Name;
    private String DoB;
    private String Gender;
    private String Phone;
    private String Email;
    private String Address;


    //The Lead constructor
    public Leads(String lead_id, String Name, String DoB, String Gender, String Phone, String Email, String Address){
        this.lead_id = lead_id;
        this.Name = Name;
        this.DoB = DoB;
        this.Gender = Gender;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
    }

    public Leads() {

    }

    ///Mutators and Accessors////
    public String getLead_id() {
        return lead_id;
    }

    public void setLead_id(String lead_id) {
        this.lead_id = lead_id;
    }

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getDoB(){
        return DoB;
    }

    public void setDoB(String DoB){
        this.DoB = DoB;
    }

    public String getGender(){
        return Gender;
    }

    public void setGender(String Gender){
        this.Gender = Gender;
    }

    public String getPhone(){
        return Phone;
    }

    public void setPhone(String Phone){
        this.Phone = Phone;
    }

    public String getEmail(){
        return Email;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public String getAddress(){
        return Address;
    }

    public void setAddress (String Address){
        this.Address = Address;
    }


    @Override
    public String toString() {
        return "ID: "+lead_id + ", Name: "  + Name +", DOB: " + DoB + ", Gender: " + Gender + ", Phone Number: "
                    + Phone + ", Email: " + Email + ", Address: " + Address;
    }
}