package com.checkedVsUnchecked;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedVsUnchecked {

	public static void main(String[] args) {

		readFile("myFile.txt");

	}

	private static void readFile(String fileName) {

		try {
			FileReader reader = new FileReader(fileName);
		}

		catch (FileNotFoundException fnfe) {
			System.out.println("Hey that file doesn't exits!");
		}
	}
}
