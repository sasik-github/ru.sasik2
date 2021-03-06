package ru.sasik.service.simple;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ru.sasik.api.AgendaService;
import ru.sasik.api.Conference;

public class SimpleAgendaService implements AgendaService {
	private List<Conference> conferences = new CopyOnWriteArrayList<Conference>();
	
	public void start() {
		conferences.add(new Conference("JavaOne", "SF"));
		conferences.add(new Conference("Devaxx", "Antwerp"));
		conferences.add(new Conference("dsfasd", "Antwerp"));
	}
	
	@Override
	public List<Conference> listConferences() {
		// TODO Auto-generated method stub
		return conferences;
	}

	@Override
	public void addConference(Conference conference) {
		// TODO Auto-generated method stub
		conferences.add(conference);
	}

}
