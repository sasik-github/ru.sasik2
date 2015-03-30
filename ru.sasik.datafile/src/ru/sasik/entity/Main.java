package ru.sasik.entity;

public class Main {
	
	/**
	 * Название задачи
	 */
	private String name;
	
	/**
	 * тип задачи(1 - плоская, 2 - осесиммитричная)
	 */
	private Integer type;
	
	/**
	 * общее количество узлов
	 */
	private Integer nodeSize;
	
	/**
	 * количество внутренних узлов
	 */
	private Integer innerNodeSize;
	
	/**
	 * количество элементво сетки
	 */
	private Integer gridSize;
	
	public Main() {	
	}
	
	public Main(String name, Integer type, Integer nodeSize,
			Integer innerNodeSize, Integer gridSize) {
		super();
		this.name = name;
		this.type = type;
		this.nodeSize = nodeSize;
		this.innerNodeSize = innerNodeSize;
		this.gridSize = gridSize;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNodeSize() {
		return nodeSize;
	}

	public void setNodeSize(Integer nodeSize) {
		this.nodeSize = nodeSize;
	}

	public Integer getInnerNodeSize() {
		return innerNodeSize;
	}

	public void setInnerNodeSize(Integer innerNodeSize) {
		this.innerNodeSize = innerNodeSize;
	}

	public Integer getGridSize() {
		return gridSize;
	}

	public void setGridSize(Integer gridSize) {
		this.gridSize = gridSize;
	}
	
	
}
