package com.klasnic.pos.model.catalogs;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.klasnic.pos.model.data.PersistentObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Jesús Israel
 */
@MappedSuperclass
@Data()
@EqualsAndHashCode(callSuper=true)
public class Versionable extends PersistentObject {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date fechaCreacion;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date fechaModificacion;

}
