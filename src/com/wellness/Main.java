package com.wellness;
//TODO - could greatly simplify module system using a parent Module class with each module being a subclass.
// Would need to know more on how inheritance works before implementing this - esp wrt the values in variables
// Would like to make log output in a JSON or DB file for easy lookup & comparison. Tried to use a JSON, failed. Went with plain text for now!
// Would like to have graphs/charts to show progress - would need ability to look up days & ratings for that

public class Main {

    public static void main(String[] args) {
        Menu.welcomeMenu();
    }
}

