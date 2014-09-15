package ru.sasik.datafile;

public class Point {
	private Integer n;
	
	private Double x;
	
	private Double y;
	
	private Integer unknow1 = 1;
	
	private Double unknow2 = 0.0;
	
	
	
	public Point(Integer n, Double x, Double y) {
		this.n = n;
		this.x = x;
		this.y = y;
	}

	public Point(Integer n, Double x, Double y, Integer unknow1, Double unknow2) {
		super();
		this.n = n;
		this.x = x;
		this.y = y;
		this.unknow1 = unknow1;
		this.unknow2 = unknow2;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Integer getUnknow1() {
		return unknow1;
	}

	public void setUnknow1(Integer unknow1) {
		this.unknow1 = unknow1;
	}

	public Double getUnknow2() {
		return unknow2;
	}

	public void setUnknow2(Double unknow2) {
		this.unknow2 = unknow2;
	}

	@Override
	public String toString() {
		return "Point [n=" + n + ", x=" + x + ", y=" + y + ", unknow1="
				+ unknow1 + ", unknow2=" + unknow2 + "]";
	}
	
	
}
