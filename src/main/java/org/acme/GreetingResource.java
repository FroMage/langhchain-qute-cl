package org.acme;

import io.quarkus.qute.TemplateGlobal;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @TemplateGlobal
    public static class ApplicationGlobals {
    	
    	public static boolean displayNewSpeakers() {
    		return Configuration.displayNewSpeakers();
    	}
    }
    
	@Inject
	ScheduleAI scheduleAI;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	return scheduleAI.findTalks("bla bli");
    }
}
