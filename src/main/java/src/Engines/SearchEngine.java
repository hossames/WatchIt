package src.Engines;
import src.ContentControl.*;
import src.DataBase.*;
import src.Cast.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchEngine {
    public boolean SearchMovie()
    {
        String[] validInput;
        String choice;
        InputChecker inputChecker = new InputChecker();
        Map<Long, Integer> vis = new HashMap<Long, Integer>();
        Scanner input = new Scanner(System.in);
        validInput = new String[]{"n", "a", "d"};
        choice = inputChecker.GetValidChoice("To search by name enter n, To search by actor enter a, To search by director enter d: ", validInput);
        if (choice.equals("n"))
        {
            System.out.print("Enter the movie title: ");
            choice = input.nextLine();
            if (!DataBase.getInstance().moviesData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
            {
                for (Movie movie : DataBase.getInstance().moviesData.getDataThatContains(choice.toLowerCase(), 2))
                    System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
            }
            else
                return false;
        }
        else if (choice.equals("a"))
        {
            System.out.print("Enter the actor's name: ");
            choice = input.nextLine();
            if (!DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
            {
                for (CastMember cast : DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2))
                {
                    if (!cast.Contents.isEmpty())
                    {
                        for (String content : cast.Contents)
                        {
                            if (!DataBase.getInstance().moviesData.getDataByString(content.toLowerCase(), 2).isEmpty())
                            {
                                for (Movie movie : DataBase.getInstance().moviesData.getDataByString(content.toLowerCase(), 2))
                                {
                                    if (!vis.containsKey(movie.contentID))
                                    {
                                        System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
                                        vis.put(movie.contentID, 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
                return false;
        }
        else
        {
            System.out.print("Enter the director's name: ");
            choice = input.nextLine();
            if (!DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
            {
                for (Director director : DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2))
                {
                    if (!director.Contents.isEmpty())
                    {
                        for (String content : director.Contents)
                        {
                            if (!DataBase.getInstance().moviesData.getDataByString(content.toLowerCase(), 2).isEmpty())
                            {
                                for (Movie movie : DataBase.getInstance().moviesData.getDataByString(content.toLowerCase(), 2))
                                {
                                    if (!vis.containsKey(movie.contentID))
                                    {
                                        System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
                                        vis.put(movie.contentID, 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
                return false;
        }
        return true;
    }

    public boolean SearchSeries()
    {
        String[] validInput;
        String choice;
        InputChecker inputChecker = new InputChecker();
        Map <Long, Integer> vis = new HashMap<Long, Integer>();
        Scanner input = new Scanner(System.in);
        validInput = new String[]{"n", "a", "d"};
        choice = inputChecker.GetValidChoice("To search by name enter n, To search by actor enter a, To search by director enter d: ", validInput);
        if (choice.equals("n"))
        {
            System.out.print("Enter the series title: ");
            choice = input.nextLine();
            if (!DataBase.getInstance().seriesData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
            {
                for (Series series : DataBase.getInstance().seriesData.getDataThatContains(choice.toLowerCase(), 2))
                    System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
            }
            else
                return false;
        }
        else if (choice.equals("a"))
        {
            System.out.print("Enter the actor's name: ");
            choice = input.nextLine();
            if (!DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
            {
                for (CastMember cast : DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2))
                {
                    if (!cast.Contents.isEmpty())
                    {
                        for (String content : cast.Contents)
                        {
                            if (!DataBase.getInstance().seriesData.getDataByString(content.toLowerCase(), 2).isEmpty())
                            {
                                for (Series series : DataBase.getInstance().seriesData.getDataByString(content.toLowerCase(), 2))
                                {
                                    if (!vis.containsKey(series.contentID))
                                    {
                                        System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
                                        vis.put(series.contentID, 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
                return false;
        }
        else
        {
            System.out.print("Enter the director's name: ");
            choice = input.nextLine();
            if (!DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
            {
                for (Director director : DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2))
                {
                    if (!director.Contents.isEmpty())
                    {
                        for (String content : director.Contents)
                        {
                            if (!DataBase.getInstance().seriesData.getDataByString(content.toLowerCase(), 2).isEmpty())
                            {
                                for (Series series : DataBase.getInstance().seriesData.getDataByString(content.toLowerCase(), 2))
                                {
                                    if (!vis.containsKey(series.contentID))
                                    {
                                        System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
                                        vis.put(series.contentID, 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else
                return false;
        }
        return true;
    }

    public boolean Search()
    {
        InputChecker inputChecker = new InputChecker();
        String choice;
        Scanner input = new Scanner(System.in);
        String[] validInput;
        validInput = new String[]{"m", "s"};
        choice = inputChecker.GetValidChoice("To Search For a movie enter m, To Search For a Series enter s: ", validInput);
        if (choice.equals("m"))
        {
            return this.SearchMovie();
        }
        else
        {
            return this.SearchSeries();
        }
    }
}
