package com.darashuk.activeMQ.entity;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Source implements Serializable {

    @NotNull
    private Long id;
    @NotNull
    private Long storage_id;
    @NotNull
    private Long song_id;
    @NotBlank
    private String name;
    @NotBlank
    private String path;
    @NotNull
    private Long size;
    @NotNull
    private String checksum;
    @NotNull
    private StorageTypes storage_types;
    @NotNull
    private String fileType;

    public Source(String name, String path, Long size, String checksum, String fileType) {
        this.name = name;
        this.path = path;
        this.size = size;
        this.checksum = checksum;
        this.fileType = fileType;
    }

    public Source(String name, StorageTypes storage_types, String fileType) {
        this.name = name;
        this.storage_types = storage_types;
        this.fileType = fileType;
    }
}