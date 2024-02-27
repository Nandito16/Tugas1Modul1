package org.example;

import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String AdminUser = "Admin";
        String PassAdmin = "admin123";

        int choice;

        do {
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Chose option (1-3) : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    LoginStudent(scanner);
                    break;
                case 2:
                    LoginAdmin(scanner, AdminUser, PassAdmin);
                    break;
                case 3:
                    Exit(scanner);
                default:
                    System.out.println("Pilihan tidak ada");
            }
        } while (choice != 3);

        scanner.close();
    }
    private static void LoginStudent(Scanner scanner) {
        System.out.print("Enter your NIM : ");
        String StudentInput = scanner.nextLine();

        if (StudentInput.length() == 15) {
            System.out.println("Succesfull login as Student");
        } else {
            System.out.println("Failed to login");
        }
    }
    private static void LoginAdmin(Scanner scanner, String AdminUser, String PassAdmin) {
        System.out.print("Enter your Username : ");
        String UserInput = scanner.nextLine();
        System.out.print("Enter your Password : ");
        String PassInput = scanner.nextLine();

        if (UserInput.equals(AdminUser) && PassInput.equals(PassAdmin)) {
            System.out.println("Succesfull login as Admin");
        } else {
            System.out.println("Failed to login");
        }
    }
    private static void Exit(Scanner scanner) {
        System.out.println("METUO COK");
        System.exit(0);
    }
}