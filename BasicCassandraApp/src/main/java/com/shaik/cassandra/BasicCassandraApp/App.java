package com.shaik.cassandra.BasicCassandraApp;

import java.util.Scanner;

public class App {

    protected static EnIDAOImpl en = new EnIDAOImpl();

    public static void main(String[] args) {
        System.out.println("Hello!");
        System.out.println("This is an Application to access Interns Data");
        int quit = 1;
        Scanner scan = new Scanner(System.in);
        while (quit != 0) {
            System.out.println("Select the Operation you wanted to do.");
            System.out.println("| Add-1 | Update-2 | Delete-3 | View-4 | Quit-5");

            int operation = Integer.parseInt(scan.nextLine());
            switch (operation) {
            case 1:
                System.out.println("Enter the new values of id,'name','address'");
                String adder = scan.nextLine();
                en.add(adder);
                en.view();
                break;
            case 2:
                System.out.println("Enter the id :");
                String v = scan.nextLine();
                int id = Integer.parseInt(v);
                System.out.println("Enter the new name/address of user");
                String u = scan.nextLine();
                en.update(id, u);
                en.view();
                break;
            case 3:
                System.out.println("Enter the id to delete:");
                String deleteIt = scan.nextLine();
                int i = Integer.parseInt(deleteIt);
                en.delete(i);
                en.view();
                break;
            case 4:
                en.view();
                break;
            case 5:
                quit = 0;
                System.out.println("Application Closed !");
                break;
            default:
                System.out.println("Wrong Option!");
            }

        }
        scan.close();
        en.close();
    }
}
