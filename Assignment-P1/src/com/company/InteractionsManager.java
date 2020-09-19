package com.company;

import com.company.Classes.Interactions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InteractionsManager{
    private ArrayList<Interactions> interactions = new ArrayList<>();

    public ArrayList<Interactions> getInteractions() {
        return interactions;
    }

    ///Adding an Interaction
    public boolean addInteraction(Interactions interaction){
        return interactions.add(interaction);
    }


    //Deleting an Interaction
    public boolean deleteInteraction(String interactionId){
        for (int i = 0; i < interactions.size(); i++) {
            if(interactionId.equals(interactions.get(i).getId())){
                return interactions.remove(interactions.get(i));
            }
        }

        return false;
    }


    private void printInteractionUpdateManual(){
        System.out.println("Which information would you like to update?");
        System.out.println("OPTIONS : [date(MM/DD/YYYY), method, potential]");
        System.out.println("Enter '0' when update is complete.");
    }

    private String updateInfoPrompt(String updateTarget){
        System.out.print("Type new " + updateTarget + " to update : ");
        return new Scanner(System.in).nextLine();
    }


    ///Printing all Interaction into Console
    public void printAllInteractions(){
        for (int i = 0; i < interactions.size(); i++) {
            System.out.println("Printing all interactions in the list... \n\n");
            System.out.println(interactions.get(i));
        }
        if(interactions.size()==0){
            System.out.println("The sales people list is empty.");
        }
    }


    ////Updating data of an Interaction////
    public boolean updateInteraction(String interactionId){

        printInteractionUpdateManual();

        Scanner s = new Scanner(System.in);
        String newInfo = "";
        boolean isDone = false;
        Interactions inter = null;

        for (int i = 0; i < interactions.size(); i++) {
            if(interactionId.equals(interactions.get(i).getId())){
                // finding object to modify
                inter = interactions.get(i);
            }

            if(inter == null){
                return false;
            }

            while(!isDone) {
                String target = s.nextLine();

                switch (target) {
                    case "date": {
                        newInfo = updateInfoPrompt(target);
                        inter.setDoI(newInfo);
                        boolean isValid = InputValidator.getInstance().validateBirthDay(newInfo);
                        if(isValid){
                            inter.setDoI(newInfo);
                        }else{
                            System.out.println("Invalid date form!");
                        }
                        break;
                    }

                    case "method": {
                        newInfo = updateInfoPrompt(target);
                        inter.setMeans(newInfo);
                        Boolean isValid = InputValidator.getInstance().validateName(newInfo);
                        if(isValid){
                            JOptionPane.showMessageDialog(null,"valid form!");
                            inter.setPotential(newInfo);
                        }else{
                            JOptionPane.showMessageDialog(null,"Invalid");
                        }
                        break;
                    }
                    case "potential": {
                        newInfo = updateInfoPrompt(target);
                        inter.setPotential(newInfo);
                        Boolean isValid = InputValidator.getInstance().validatePotential(newInfo);
                        if(isValid){
                            JOptionPane.showMessageDialog(null,"valid form!");
                            inter.setPotential(newInfo);
                        }else{
                            JOptionPane.showMessageDialog(null,"Invalid");
                        }
                        break;
                    }
                    case "0": {
                        isDone = true;
                        break;
                    }
                    default: {
                        System.out.println("wrong input!");
                        break;
                    }
                }
            }
        }
        return true;


    }
}