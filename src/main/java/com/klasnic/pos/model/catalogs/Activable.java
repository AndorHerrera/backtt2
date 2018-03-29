package com.klasnic.pos.model.catalogs;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Jesús Israel
 */
@MappedSuperclass
@Data()
@EqualsAndHashCode(callSuper=true)
public class Activable extends Versionable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Boolean activo = true;

   

}
