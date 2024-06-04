package org.example.TUGAS6MDL6.com.main;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.example.TUGAS6MDL6.books.*;
import org.example.TUGAS6MDL6.data.Admin;
import org.example.TUGAS6MDL6.data.Student;

import java.util.ArrayList;

public class LibrarySystem {
    public static ArrayList<Book> daftarBuku = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();

    public static void startLibrarySystem(Stage stage) {
        daftarBuku.add(new StoryBook("SB32F", "Jiraiya", 17, "Story", "Martis"));
        daftarBuku.add(new HistoryBook("HB324", "Satu Hari", 2, "History", "Moskov"));
        daftarBuku.add(new TextBook("TB323", "Pasutri", 4, "Text", "Eudora"));

        studentList.add(new Student("202310370311194", "Daito", "Teknik", "Mesin"));
        studentList.add(new Student("202310370311195", "Opik", "Teknik", "Informatika"));
        studentList.add(new Student("202310370311196", "Naruto", "Teknik", "Elektro"));

        HBox root = new HBox(10);
        Scene scene = new Scene(root, 400, 300);

        Label label = new Label("===== Library System =====");

        root.setAlignment(Pos.CENTER);
        Button studentLoginButton = new Button("Login sebagai Mahasiswa");
        studentLoginButton.setPrefHeight(50);
        studentLoginButton.setPrefWidth(200);

        Button adminLoginButton = new Button("Login sebagai Admin");
        adminLoginButton.setPrefHeight(50);
        adminLoginButton.setPrefWidth(200);

        Button exitButton = new Button("Keluar");
        exitButton.setPrefWidth(200);
        exitButton.setPrefHeight(50);

        studentLoginButton.setOnAction(event -> studentLogin(stage));
        adminLoginButton.setOnAction(event -> {
            try {
                new Admin().login(stage);
            } catch (Exception e) {
                showErrorDialog("Error", e.getMessage());
            }
        });
        exitButton.setOnAction(event -> stage.close());

        root.getChildren().addAll(label, studentLoginButton, adminLoginButton, exitButton);

        stage.setScene(scene);
        stage.setTitle("Library System");
        stage.show();
    }

    private static void studentLogin(Stage stage) {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 400, 300);

        Label label = new Label("Masukkan NIM : ");
        TextField nimField = new TextField();
        Button loginButton = new Button("Login");
        Button backButton = new Button("Kembali");

        loginButton.setOnAction(event -> {
            String nimStudent = nimField.getText();
            if (nimStudent.length() == 15 && checkNim(nimStudent)) {
                Student student = new Student(nimStudent);
                student.login(stage);
            } else {
                showErrorDialog("Error", "Nim tidak terdaftar atau tidak valid!");
            }
        });

        backButton.setOnAction(event -> startLibrarySystem(stage));

        root.getChildren().addAll(label, nimField, loginButton, backButton);

        stage.setScene(scene);
    }

    private static void showErrorDialog(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
