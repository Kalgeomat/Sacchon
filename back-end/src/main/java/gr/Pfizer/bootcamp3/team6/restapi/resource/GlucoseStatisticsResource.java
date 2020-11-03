package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.representation.GlucoseStatisticsRepresentation;
import org.restlet.resource.Get;

public interface GlucoseStatisticsResource {
    @Get("json")
    GlucoseStatisticsRepresentation getGlucoseStatistics();
}
