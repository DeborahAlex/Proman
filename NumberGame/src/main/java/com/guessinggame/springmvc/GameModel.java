package com.guessinggame.springmvc;

import org.springframework.stereotype.Component;

@Component
public class GameModel {
	private int TargetNumber;
	private int Tries;
	private int preval;
	
	public int getPreval() {
		return preval;
	}
	public void setPreval(int preval) {
		this.preval = preval;
	}
	public GameModel() {
		TargetNumber = 0;
		Tries = 0;
	}
	public int getTargetNumber() {
		return TargetNumber;
	}
	public void setTargetNumber(int targetNumber) {
		TargetNumber = targetNumber;
	}
	public int getTries() {
		return Tries;
	}
	public void setTries(int tries) {
		Tries = tries;
	}
	
	
}
