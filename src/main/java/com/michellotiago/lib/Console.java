package com.michellotiago.lib;

import java.io.IOException;

public class Console {
    public final static void limparConsole()
    {

        try
        {
            final String os = System.getProperty("os.name");
            System.out.println("\nConsole limpa\n " + os);
            if (os.contains("Windows"))
                // não funciona em uma IDE de Desenvolvimento, somente no JAR
                //Runtime.getRuntime().exec("cls");
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                // não funciona em uma IDE de Desenvolvimento, somente no JAR
                Runtime.getRuntime().exec("clear");
        }
        catch (final Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
