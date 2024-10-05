package com.michellotiago.service.Patterns.Singleton;
/*
-> Descrição do Problema:

 - Em sistemas complexos, frequentemente existe a necessidade de manter uma
única instância de configuração que seja acessível globalmente.

Por exemplo, um sistema pode necessitar de um conjunto único de propriedades de
configuração que controlam diversos aspectos operacionais, como conexões
de banco de dados, configurações de API, e preferências de usuário.

-> Solução com Singleton:

- O Singleton garante que uma classe tenha apenas uma instância e fornece
um ponto de acesso global a essa instância. Isso é especialmente útil para
gerenciar configurações, onde múltiplas instâncias seriam desnecessárias ou
potencialmente problemáticas.

___________________________________________________________________________________

-> Problema: Você quer garantir que um determinado objeto seja instanciado uma única vez em todo
seu programa. Além disso, gostaria de facilitar o acesso a esse objeto

- Solução: Torne o construtor privado e forneça um método estático de acesso ao seu objeto.

*/
// https://docs.oracle.com/javase/8/docs/api/java/util/Properties.html
// https://stackoverflow.com/questions/1318347/how-to-use-java-property-files
// https://stackoverflow.com/questions/16806434/where-to-put-a-properties-file-in-java

import java.util.Properties;

// https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html
// https://stackoverflow.com/questions/32796097/how-fileinputstream-and-fileoutputstream-works-in-java
import java.io.FileInputStream;

// https://docs.oracle.com/javase/8/docs/api/java/io/IOException.html

import java.io.IOException;

public class Configuration {
    private static Configuration instance;
    private Properties properties;

    private Configuration(){
        properties = new Properties();
        try (  FileInputStream fileInputStream = new FileInputStream("config.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return ;
        }
    }
    public static synchronized Configuration getInstance(){
        if (instance ==null){
            instance = new Configuration();
        }
        return instance;
    }
    public String getProperty(String key){
        return properties.getProperty(key);
    }
}