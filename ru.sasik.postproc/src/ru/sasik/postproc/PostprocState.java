package ru.sasik.postproc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import ru.sasik.datafile.SolutionAbstract;
import ru.sasik.datafile.SolutionDataFile;
import ru.sasik.entity.RezFile;
import ru.sasik.entity.Zone;

public class PostprocState extends Observable{

	private SolutionAbstract solutionDataFile;
	/**
	 * текущий кадр для отображения
	 */
	private Zone currentZone = null;
	
	
	/**
	 * Все зоны, по которым будет ходить итератор для отображения
	 */
	private ArrayList<Zone> zones;
	/**
	 * итератор зон, по нему идет изображение
	 */
	private Iterator<Zone> zoneIterator;
	
	public PostprocState() {
		// TODO Auto-generated constructor stub
	}
	
	public Iterator<Zone> getZoneIterator() {
		if (zoneIterator == null)
			zoneIterator = zones.iterator();
		return zoneIterator;
	}

	public void setZoneIterator(Iterator<Zone> zoneIterator) {
		this.zoneIterator = zoneIterator;
	}
	
	public void resetZoneIterator() {
		zoneIterator = null;
	}

	public SolutionAbstract getSolutionDataFile() {
		return solutionDataFile;
	}

	public void setSolutionDataFile(SolutionAbstract results) {
		if (results == null)
			return;
		
		this.solutionDataFile = results;
		RezFile rezFile = results.getRezFile();
		if (rezFile == null)
			return;
		
		zones = rezFile.getZones();
		nextState();
		setChanged();
		notifyObservers();
	}
	
	public Zone nextState() {
		if (getZoneIterator().hasNext()) {
			setCurrentZone(zoneIterator.next());
		}
		return getCurrentZone();
	}

	public Zone getCurrentZone() {
		if (currentZone == null) 
			return new Zone(2.);
		return currentZone;
	}

	public void setCurrentZone(Zone currentZone) {
		this.currentZone = currentZone;
	}
}
