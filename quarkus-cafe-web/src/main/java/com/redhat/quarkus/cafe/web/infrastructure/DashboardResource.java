package com.redhat.quarkus.cafe.web.infrastructure;

import com.redhat.quarkus.cafe.web.domain.DashboardUpdate;
import io.smallrye.reactive.messaging.annotations.Merge;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dashboard")
public class DashboardResource {

    Logger logger = Logger.getLogger(DashboardResource.class);

    @Inject
    @Channel("web-updates")
    @Merge(Merge.Mode.MERGE)
    Publisher<DashboardUpdate> updater;

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS) // denotes that server side events (SSE) will be produced
    @SseElementType("text/plain") // denotes that the contained data, within this SSE, is just regular text/plain data
    public Publisher<DashboardUpdate> dashboardStream() {

        return updater;
    }
}
