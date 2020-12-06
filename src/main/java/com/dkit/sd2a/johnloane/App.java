package com.dkit.sd2a.johnloane;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PlayerDB
 *
 */
public class App 
{
    private static Scanner keyboard = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println( Colours.BLUE + "Welcome to the player App" + Colours.RESET);
        App playerDBApp = new App();
        playerDBApp.start();
    }

    private void start()
    {
        PlayerDB playerDB = new PlayerDB();
        playerDB.loadPlayersFromFile();
        doMainMenuLoop(playerDB);
    }

    private void doMainMenuLoop(PlayerDB playerDB)
    {
        boolean loop = true;
        MainMenu menuOption;
        int option;
        while(loop)
        {
            printMainMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = MainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_APPLICATION:
                        loop = false;
                        break;
                    case DISPLAY_PLAYER_MENU:
                        doPlayerMainMenuLoop(playerDB);
                        break;
                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
                keyboard.nextLine();
            }
        }
        System.out.println(Colours.BLUE + "Thanks for using the app" + Colours.RESET);
    }

    private void doPlayerMainMenuLoop(PlayerDB playerDB)
    {
        boolean loop = true;
        PlayerMainMenu menuOption;
        int option;
        while(loop)
        {
            printPlayerMainMenu();
            try
            {
                option = keyboard.nextInt();
                keyboard.nextLine();
                menuOption = PlayerMainMenu.values()[option];
                switch (menuOption)
                {
                    case QUIT_PLAYER_MENU:
                        loop = false;
                        break;
                    case ADD_PLAYER:
                        playerDB.addPlayer();
                        break;
                    case DELETE_PLAYER:
                        playerDB.deletePlayer();
                        break;
                    case PRINT_PLAYER:
                        playerDB.printPlayer();
                        break;
                }
            } catch (InputMismatchException ime)
            {
                System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
                keyboard.nextLine();
            }
        }
    }

    private void printPlayerMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < PlayerMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + PlayerMainMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.print("Enter a number to select option (enter 0 to quit):>");
    }

    private void printMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < MainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + MainMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.print("Enter a number to select option (enter 0 to quit):>");
    }
}
