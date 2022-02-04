package cw2a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BoardSquareButton extends JButton{
	
	public boolean mine, investigated, potentialMine;

	public BoardSquareButton(int width, int height, Color color, int Xcoordinate, int Ycoordinate) {
		setMinimumSize(new Dimension(width/3, height/3));
		setPreferredSize(new Dimension(width, height));
		this.initialise();
	}

	public void initialise() {
		this.setText("?");
		this.setFont(new Font("Ariel", Font.BOLD, 30));
		this.setBackground(Color.gray);
		this.investigated = false;
		this.potentialMine = false;
		this.mine = false;
	}

	public void setMine(boolean newMine)
	{
		mine = newMine;
	}

	public boolean getMine()
	{
		return mine;
	}

	public void setPotentialMine(boolean newPotentialMine)
	{
		potentialMine = newPotentialMine;
	}

	public boolean getPotentialMine()
	{
		return potentialMine;
	}

	public boolean getInvestigated()
	{
		return investigated;
	}

	public void setInvestigated(boolean newInvestigated)
	{
		investigated = newInvestigated;
	}








}