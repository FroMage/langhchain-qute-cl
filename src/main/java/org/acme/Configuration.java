package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Configuration extends PanacheEntity {

	@Enumerated(EnumType.STRING)
	public ConfigurationKey key;

	public String value;

    public static boolean displayNewSpeakers() {
        Configuration config = Configuration.find("key", ConfigurationKey.DISPLAY_NEW_SPEAKERS).firstResult();
        return config != null && config.value.equals("true");
    }
}
