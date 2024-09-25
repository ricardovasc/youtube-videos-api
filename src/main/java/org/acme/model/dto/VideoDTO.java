package org.acme.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VideoDTO {

    private Long id;
    private String name;
    private String link;
}
