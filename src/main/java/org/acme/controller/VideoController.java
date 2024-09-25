package org.acme.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.model.dto.VideoDTO;
import org.acme.service.VideoService;

@Path("/videos")
@RequiredArgsConstructor
public class VideoController {

    final private VideoService videoService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(videoService.findById(id)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(videoService.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(VideoDTO videoDTO) {
        final VideoDTO savedVideoDTO = videoService.save(videoDTO);

        return Response.status(Response.Status.CREATED).entity(savedVideoDTO).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, VideoDTO videoDTO) {
        final VideoDTO updatedVideoDTO = videoService.update(id, videoDTO);

        return Response.ok(updatedVideoDTO).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        videoService.delete(id);

        return Response.noContent().build();
    }
}
