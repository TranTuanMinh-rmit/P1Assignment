package com.company;

import com.company.Classes.Interactions;
import com.company.Classes.Leads;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class LeadsManager{
    private ArrayList<Leads> leads = new ArrayList<>();

    public ArrayList<Leads> getLeads(){
        return leads;
    }


    ///Actual method to call a Lead from its ID/////
    public Leads getLeadsById(String lead_id){
        for (int i = 0; i < leads.size(); i++){
            if(lead_id.equals(leads.get(i).getLead_id())){
                return leads.get(i);
            }
        }
        return null;
    }


    ////Writing to file////
    public void saveLeadToFile(Leads lead){
        try{
            FileWriter fileWriter = new FileWriter("leads.csv");
            fileWriter.write(lead.toString());

        }catch (IOException e){
            System.out.println("Error occurred while writing customer to the file.");
            e.printStackTrace();
        }

        System.out.println("saved! ");
    }




    ///Adding a lead////
    public boolean addLeads(Leads lead){
        return leads.add(lead);
    }


    ////Actual printing////
    public void printAllLeads(){
        for (int i = 0; i < leads.size(); i++) {
            System.out.println(leads.get(i));
        }
        if(leads.size()==0){
            System.out.println("The list is empty.");
        }
    }


    ///Actual deleting////
    public boolean deleteLeads(String lead_id){
        Leads lead = getLeadsById(lead_id);
        if(lead == null){
            return false;
        }else{
            return leads.remove(lead);
        }
    }

    ////////Updating Data//////
    /////Might not work!!!  Duan check xem co dung dc khong. Xong thi xoa line note nay/////
    public boolean updateLeads(String lead_Id){

        Leads leads = getLeadsById(lead_Id);

        if(leads == null){
            return false;
        }

        printLeadUpdateManual();

        Scanner s = new Scanner(System.in);
        boolean isDone = false;
        String newInfo = "";

        Interactions inter = null;
        while(!isDone){
            String target = s.nextLine();

            switch (target){
                case "name" : {
                    newInfo = updateInfoPrompt(target);
                    // leads.setName(newInfo);
                    boolean isValid = InputValidator.getInstance().validateName(newInfo);
                    if(isValid){
                        JOptionPane.showMessageDialog(null,"valid form!");
                        leads.setName(newInfo);
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid");
                    }
                    break;
                }

                case "dob" : {
                    System.out.print("enter new date of birth(MM/DD/YYYY) : ");
                    String newDate = new Scanner(System.in).nextLine();
                    boolean isValid = InputValidator.getInstance().validateBirthDay(newDate);
                    if(isValid){
                        leads.setDoB(newDate);
                    }else{
                        System.out.println("Invalid birthday form!");
                    }
                    break;
                }
                case "gender" : {

                    newInfo = updateInfoPrompt(target);
                    // leads.setGender(newInfo);
                    boolean isValid = InputValidator.getInstance().validateGender(newInfo);
                    if(isValid){
                        JOptionPane.showMessageDialog(null,"valid form!");
                        leads.setGender(newInfo);
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid");
                    }
                    break;

                }

                case "phone" : {
                    newInfo = updateInfoPrompt(target);
                    // leads.setName(newInfo);
                    boolean isValid = InputValidator.getInstance().validatePhoneNumber(newInfo);
                    if(isValid){
                        JOptionPane.showMessageDialog(null,"valid form!");
                        leads.setPhone(newInfo);
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid");
                    }
                    break;

                }

                case "email" : {

                    newInfo = updateInfoPrompt(target);
                    // leads.setName(newInfo);
                    boolean isValid = InputValidator.getInstance().validateEmail(newInfo);
                    if(isValid){
                        JOptionPane.showMessageDialog(null,"valid form!");
                        leads.setEmail(newInfo);
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid");
                    }
                    break;
                }

                case "address" : {

                    newInfo = updateInfoPrompt(target);
                    // leads.setName(newInfo);
                    boolean isValid = InputValidator.getInstance().validateAddress(newInfo);
                    if(isValid){
                        JOptionPane.showMessageDialog(null,"valid form!");
                        leads.setAddress(newInfo);
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid");
                    }
                    break;
                }

                case "0" : {
                    isDone = true;
                    break;
                }
                default : {
                    System.out.println("Wrong Input !");
                    printLeadUpdateManual();
                    break;
                }
            }
        }
        return true;
    }

    private void printLeadUpdateManual(){
        System.out.println("Which information would you like to update?");
        System.out.println("OPTIONS : [name, dob (MM/DD/YYYY), gender, phone, email, address]");
        System.out.println("Enter '0' when update is complete.");
    }

    private String updateInfoPrompt(String updateTarget){
        System.out.println("Type new "+ updateTarget+" to update: ");
        return new Scanner(System.in).nextLine();
    }
}