package ru.otus.softwarearchitect.defimov.gateway.service;

public interface AddressSyncronizationService {
	void syncronizeAll();

	void syncronizeIncrimental();
}