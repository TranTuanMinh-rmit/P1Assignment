package com.company;


import com.company.Classes.Interactions;
import com.company.Classes.Leads;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



// Main I/O interface
public class Main {

    private static int leadsId = 0;
    private static int interactionId = 0;

    private static LeadsManager leadsManager = new LeadsManager();
    private static InteractionsManager interactionsManager = new InteractionsManager();

    public static void main(String[] args) {

        //Declare Scanner
        Scanner input = new Scanner(System.in);
        System.out.print("[MENU] \n"
                + "===[MANAGING LEADS]===  \n"
                + "1) View all Leads \n"
                + "2) Create new Leads \n"
                + "3) Update a lead \n"
                + "4) Delete a lead \n"
                + "===[MANAGING INTERACTIONS]=== \n"
                + "5) View all Interactions \n"
                + "6) Create new Interactions \n"
                + "7) Update an Interaction \n"
                + "8) Delete an Interaction \n"
                + "===[Reporting and Statistics]===\n"
                + "10) N/A\n"
                + "11) N/A\n"
                + "12) N/A\n"
                + "===[Save Progress]===\n"
                + "20) Save arrays data into file.\n"
                + "Please input the desired function:");

        while(true){
            String answer = input.nextLine();

            switch (answer){
                case "1" : {
                    printLeads();
                    break;
                }

                case "2" : {
                    LeadMethod();
                    break;
                }

                case "3": {
                    String leadId = enterLeadIdPrompt();
                    updateLeads(leadId);
                    break;
                }

                case "4" : {
                    String leadId = enterLeadIdPrompt();
                    deleteLeads(leadId);
                    break;
                }

                case "5" : {
                    System.out.println("Printing all the sales people in the list ...");
                    System.out.println(" ");
                    printAllInteractions();
                    break;
                }

                case "6" : {
                    addInteractionInfo();
                    break;
                }

                case "7" : {
                    String interactionId = enterInteractionIdPrompt();
                    updateInteractionInfo(interactionId);
                    break;
                }

                case "8" : {
                    String interactionId = enterInteractionIdPrompt();
                    deleteInteractionInfo(interactionId);
                    break;
                }
            }
        }

     }




    ///////////////////////Methods for Lead///////////////////////////////////


    ////Main method for creating leads/////
    public static void LeadMethod(){

        Leads leads = createLeadsObject();

        if(leadsManager.addLeads(leads)){
            System.out.println("Added Lead Successfully! \n" + leads);
        }

        else{
            System.out.println("Adding Lead failed!");
        }


    }

    

    /////Creating the Lead Object from the Class and User input////////
    private static Leads createLeadsObject(){
        Scanner leadsInfoInput = new Scanner(System.in);
        Leads leads = new Leads();

        System.out.println("Enter Leads Data:");
        leads.setLead_id(String.format("lead_%03d", leadsId++));

        System.out.print("Name: ");
        String Name = leadsInfoInput.nextLine();
        leads.setName(Name);

        System.out.print("Date of Birth (MM/DD/YYYY) : ");
        String DateOfBirth = leadsInfoInput.nextLine();
        leads.setDoB(DateOfBirth);


        System.out.print("Gender (Male - 0, Female - 1) : ");
        String Gender = leadsInfoInput.nextLine();
        leads.setGender(Gender);

        System.out.print("Phone Number : ");
        String PhoneNumber = leadsInfoInput.nextLine();
        leads.setPhone(PhoneNumber);

        System.out.print("Email : ");
        String Email = leadsInfoInput.nextLine();
        leads.setEmail(Email);

        System.out.print("Address : ");
        String Address = leadsInfoInput.nextLine();
        leads.setAddress(Address);

        return leads;
    }


    ////Printing out the leads on the console/////
    private static void printLeads() { leadsManager.printAllLeads(); }


    ////Deleting a lead by ID////
    private static void deleteLeads(String lead_id){
        boolean isDeleted = leadsManager.deleteLeads(lead_id);
        if(isDeleted){System.out.println("Deleting lead from the list...");
            System.out.println("Deleted " + lead_id + " successfully!");
        }else{
            System.out.println("Delete lead failed!");
        }
    }


    ////Method to enter desired Lead ID////
    private static String enterLeadIdPrompt(){
        System.out.print("Enter customer id : ");
        Scanner del = new Scanner(System.in);
        return del.nextLine();
    }


    /////Method for updating a lead's data///////
    private static void updateLeads(String lead_id) {

        boolean isUpdated = leadsManager.updateLeads(lead_id);

        if(isUpdated){
            System.out.println("Update customer successful!");
        }else{
            System.out.println("Update customer failed.");
        }
    }



    /////////////////////////////////////////////////////////////////


    //////////////////////Interactions Section///////////////////////

    ///Method to call for adding Interaction
    private static void addInteractionInfo() {

        Interactions interaction = createInteractionObject();

        boolean isAdded = interactionsManager.addInteraction(interaction);
        if(isAdded){
            System.out.println("Interaction added successfully!\n" + interaction);
        }else{
            System.out.println("Interaction add failed !");
        }
    }


    ////Method for Asking the Interaction's ID////
    private static String enterInteractionIdPrompt(){
        System.out.print("Enter model.Interaction Id : ");
        Scanner interactionIdInput = new Scanner(System.in);
        return interactionIdInput.nextLine();
    }


    //////Method to call for deleting an Interaction
    private static void deleteInteractionInfo(String interactionId) {
        boolean isDeleted = interactionsManager.deleteInteraction(interactionId);
        if(isDeleted){
            System.out.println("Delete interaction information successful!");
        }else{
            System.out.println("Delete interaction information failed.");
        }
    }


    ////Method to call for Updating Interaction's data
    private static void updateInteractionInfo(String interactionId) {
        boolean isUpdated = interactionsManager.updateInteraction(interactionId);
        if(isUpdated){
            System.out.println("Update interaction information successful!");
        }else{
            System.out.println("Update interaction information failed.");
        }
    }


    ///Method to call for printing interactions///
    private static void printAllInteractions() {
        interactionsManager.printAllInteractions();
    }



    /////User Input to create data for the Interaction object
    private static Interactions createInteractionObject(){
        Scanner interactionInfoInput = new Scanner(System.in);
        Interactions interaction = new Interactions();
        interaction.setInter_id(String.format("inter_%03d", interactionId++));

        System.out.print("Date of interaction (MM/DD//YYYY) : ");
        String dateOfInteraction = interactionInfoInput.nextLine();
        interaction.setDoI(dateOfInteraction);

        System.out.print("Lead ID : ");
        String leadId = interactionInfoInput.nextLine();
        Leads lead = leadsManager.getLeadsById(leadId);

        if(lead == null){
            while(lead == null){
                System.out.println("Wrong customer id, please try again!");
                leadId = interactionInfoInput.nextLine();
                lead = leadsManager.getLeadsById(leadId);
            }
        }
        interaction.setLead_id(lead);

        System.out.print("Interaction Method (SNS / email / telephone / face to face) : ");
        String method = interactionInfoInput.nextLine();
        interaction.setMeans(method);

        System.out.print("Potential (P - positive, NEG - negative, NEU - neutral) : ");
        String potential = interactionInfoInput.nextLine();
        interaction.setPotential(potential);

        return interaction;
    }
    /////////////////////////////////////////////////////////////////////////////


}

