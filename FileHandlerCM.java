/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

/**
 *
 * @author DELL
 */
import java.io.*;
import java.util.ArrayList;

public class FileHandlerCM<T> implements Serializable {
  private static final long serialVersionUID = 77L;
  private String filePath;

public FileHandlerCM(String filePath){
    this.filePath=filePath;
}

public void saveData(T data){
    ArrayList<T> dataList=readFromFile();
    dataList.add(data);
    writeDataToFile(dataList);
    System.out.println("Data saved successfully");   
}
 public ArrayList<T> readFromFile() {
        ArrayList<T> dataList = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                T data = (T) in.readObject();
                dataList.add(data);
            }
        } catch (EOFException ex) {
            // End of file reached
            System.out.println("All data loaded from file.");
        } catch (ClassNotFoundException | IOException ex) {
            System.err.println("Error reading from file: " + filePath);
            ex.printStackTrace();
        }

        return dataList;
    }

    public void writeDataToFile(ArrayList<T> dataList) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath, false))) {
            // Overwrite file by setting append to false
            for (T item : dataList) {
                out.writeObject(item); // Write each object individually
            }
        } catch (IOException ex) {
            System.err.println("Error writing to file: " + filePath);
            ex.printStackTrace();
        }
    }

}
