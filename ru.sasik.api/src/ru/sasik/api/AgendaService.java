package ru.sasik.api;

import java.util.List;

public interface AgendaService {
	List<Conference> listConferences();
	void addConference(Conference conference);
}
