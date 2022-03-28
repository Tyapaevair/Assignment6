package com.coderscampus.week10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarService {
	 public List<Car> getSuspectfromFiles(String fileName ) {
		  try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
				int i = 0;
				String line;
				List<Car> suspects = new ArrayList<>();
				 fileReader.readLine();
				while ((line = fileReader.readLine()) != null) {
					 String[] lineData = line.split(",");
					 Car car = new Car(lineData[0], lineData[1]);
					 suspects.add(car);
					 i++;
				}

				return suspects;

		  } catch(IOException e) {
				e.printStackTrace();
		  }
		  return null;
	 }


}