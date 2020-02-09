package ru.otus.softwarearchitect.defimov.fias.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DownloadFileInfo {
	@JsonProperty("VersionId")
	private int versionId;

	@JsonProperty("TextVersion")
	private String textVersion;

	@JsonProperty("FiasCompleteXmlUrl")
	private String fiasCompleteXmlUrl;

	@JsonProperty("FiasDeltaXmlUrl")
	private String fiasDeltaXmlUrl;
}
