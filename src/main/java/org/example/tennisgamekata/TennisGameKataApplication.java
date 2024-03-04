package org.example.tennisgamekata;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TennisGameKataApplication {



	public static void main(String[] args) {

		TennisGame tennisGame = new TennisGame();
		Scanner scanner = new Scanner( System.in );
		System.out.print( "Enter the game result : " );

		tennisGame.getScore(scanner.nextLine());
	}

}
