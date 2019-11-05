import java.util.List;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.FileWriter;

import java.io.IOException;




public class Account {





    private List<Sensor> sensor;

    private List<Actuator> actuator;

    private List<Rule> rules;



    private String id;

    private String name;

    private String password;

    private String email;



    public Account(String id, String name, String password, String email){

        this.id = id;

        this.name = name;

        this.password = password;

        this.email = email;



    }



    public boolean createAccount() {

        String newAccount = name+"/"+password;

        String filename= "accounts.txt";



        try

        {

            FileReader fr = new FileReader(filename);

            BufferedReader br = new BufferedReader(fr);



            String line;

            while((line = br.readLine()) != null)

                if(line.equals(newAccount)){

                    System.out.println("Account already in the system");

                    fr.close();

                    return false;

                }



            fr.close();



            FileWriter fw = new FileWriter(filename,true); //the true will append the new data

            fw.write(newAccount);//appends the string to the file

            fw.write("\n");//appends the string to the file

            System.out.println("Your account has been created successfully");

            fw.close();

            return true;

        }

        catch(IOException ioe)

        {

            System.err.println("IOException: " + ioe.getMessage());

        }

        return false;

    }



    public boolean validate(String name, String password){

        String filename= "accounts.txt";

        String account = name+"/"+password;

        try {

            FileReader fr = new FileReader(filename);

            BufferedReader br = new BufferedReader(fr);



            String line;

            while((line = br.readLine()) != null)

                if(line.equals(account)){

                    System.out.println("Welcome "+ name);

                    fr.close();

                    return true;

                }



            fr.close();



        }

        catch(Exception e) {

            System.out.println("Excepcion reading file: "+ filename + ": " + e);

        }

        System.out.println("Account not found.");



        return false;

    }



}
