package ru.otus.softwarearchitect.defimov.fias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.softwarearchitect.defimov.gateway.service.AddressSyncronizationService;

@RestController
class FiasImportServiceRESTController {
	@Autowired
	private AddressSyncronizationService addressSyncService;

	@GetMapping(value = "/fias/syncronize", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	void getDownloadLinks(@RequestParam SyncronizationMode mode) {
		if (mode == SyncronizationMode.INCREMENTAL) {
			addressSyncService.syncronizeIncrimental();
		} else {
			addressSyncService.syncronizeAll();
		}
	}
}
