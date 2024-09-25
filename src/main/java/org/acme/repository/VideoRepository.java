package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Video;

@ApplicationScoped
public class VideoRepository implements PanacheRepository<Video> {
}
