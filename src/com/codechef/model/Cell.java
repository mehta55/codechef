package com.codechef.model;

public class Cell implements Comparable<Cell> {
	int num;
	int row;
	int col;
	
	

	public Cell(int num, int row, int col) {
		super();
		this.num = num;
		this.row = row;
		this.col = col;
	}

	@Override
	public String toString() {
		return "Cell [num=" + num + ", row=" + row + ", col=" + col + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Cell cell = (Cell) obj;
		return cell.num == this.num;
	}
	
	@Override
	public int compareTo(Cell obj) {
		return this.num - obj.num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
	
	
	

}