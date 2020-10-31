package gr.Pfizer.bootcamp3.team6.restapi.resource;

import gr.Pfizer.bootcamp3.team6.restapi.representation.CarbsStatisticsRepresentation;
import org.restlet.resource.Get;

public interface CarbsStatisticsResource {
    @Get("json")
    CarbsStatisticsRepresentation getCarbsStatistics();
}
