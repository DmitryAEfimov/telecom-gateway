package ru.otus.softwarearchitect.defimov.fias;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.otus.softwarearchitect.defimov.fias.dto.DownloadFileInfo;
import ru.otus.softwarearchitect.defimov.gateway.service.AddressSyncronizationService;

import java.net.URL;

@Service("FiasSyncService")
class FiasSyncService implements AddressSyncronizationService {
	private static final String FIAS_DOWNLOAD_API_URL = "https://fias.nalog.ru/WebServices/Public/GetLastDownloadFileInfo";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@SneakyThrows
	public void syncronizeAll() {
		var dto = restTemplate.getForObject(FIAS_DOWNLOAD_API_URL, DownloadFileInfo.class);
		assert dto != null;
		URL url = new URL(dto.getFiasCompleteXmlUrl());
	}

	@Override
	@SneakyThrows
	public void syncronizeIncrimental() {
		var dto = restTemplate.getForObject(FIAS_DOWNLOAD_API_URL, DownloadFileInfo.class);
		assert dto != null;
		URL url = new URL(dto.getFiasCompleteXmlUrl());
	}
}
