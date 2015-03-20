package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Kitchen kitchen;
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        while(true){
            menu.mainMenu();
            if(menu.kitchenMenuCall(scanner.nextInt())){
                return;
            }
        }
    }
}
