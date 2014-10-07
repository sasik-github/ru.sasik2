package ru.sasik.client.console;

import java.util.List;

import ru.sasik.api.AgendaService;
import ru.sasik.api.Conference;

public class ConsoleClient {
	
	private volatile AgendaService agendaService;
	
	public void start() {
		List<Conference> conferences = agendaService.listConferences();
		for (Conference conf : conferences) {
			System.out.println(conf);
		}
		
//		new TestDraw();
	}
}
