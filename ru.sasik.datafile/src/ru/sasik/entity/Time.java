package ru.sasik.entity;

/**
 * секция временных параметров
 * @author sasik
 *
 */
public class Time {
	/**
	 * максимальный шак по времени
	 */
	private Double maxTimeStep;
	
	/**
	 * минимальный шаг по времени
	 */
	private Double minTimeStep;
	/**
	 * время инициализации задачи
	 */
	private Double startTime;
	
	/**
	 * максимально разрешенное время расчета
	 */
	private Double endTime;
	
	public Time() {
	}

	public Time(Double maxTimeStep, Double minTimeStep, Double startTime,
			Double endTime) {
		super();
		this.maxTimeStep = maxTimeStep;
		this.minTimeStep = minTimeStep;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Double getMaxTimeStep() {
		return maxTimeStep;
	}

	public void setMaxTimeStep(Double maxTimeStep) {
		this.maxTimeStep = maxTimeStep;
	}

	public Double getMinTimeStep() {
		return minTimeStep;
	}

	public void setMinTimeStep(Double minTimeStep) {
		this.minTimeStep = minTimeStep;
	}

	public Double getStartTime() {
		return startTime;
	}

	public void setStartTime(Double startTime) {
		this.startTime = startTime;
	}

	public Double getEndTime() {
		return endTime;
	}

	public void setEndTime(Double endTime) {
		this.endTime = endTime;
	}
	
	
}
