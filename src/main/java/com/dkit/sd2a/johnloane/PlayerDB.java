package com.dkit.sd2a.johnloane;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerDB
{
    private ArrayList<Player> players;

    public PlayerDB()
    {
        players = new ArrayList<>();
    }

    protected void loadPlayersFromFile()
    {
        try(Scanner playersFile = new Scanner(new BufferedReader(new FileReader("players.txt"))))
        {
            String input;
            while(playersFile.hasNextLine())
            {
                input = playersFile.nextLine();
                String[] data = input.split(",");
                String name = data[0];
                int hitPoints = Integer.parseInt(data[1]);
                int strength = Integer.parseInt(data[2]);
                String weapon = data[3];

                Player readInPlayer = new Player(name, hitPoints, strength, weapon);
                this.players.add(readInPlayer);
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println(Colours.PURPLE + "Could not load players. If this is the first time running the app this might be fine");
        }
    }
}
