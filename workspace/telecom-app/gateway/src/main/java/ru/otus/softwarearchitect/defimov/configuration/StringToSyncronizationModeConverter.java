package ru.otus.softwarearchitect.defimov.configuration;

import org.springframework.core.convert.converter.Converter;
import ru.otus.softwarearchitect.defimov.fias.SyncronizationMode;

public class StringToSyncronizationModeConverter
		implements Converter<String, SyncronizationMode> {

	@Override
	public SyncronizationMode convert(String s) {
		return SyncronizationMode.valueOf(s.toUpperCase());
	}
}
