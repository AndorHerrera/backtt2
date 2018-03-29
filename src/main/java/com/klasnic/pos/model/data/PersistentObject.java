
/**
 *
 * @author Jesús Israel
 */
package com.klasnic.pos.model.data;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class PersistentObject implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @Column(length = 36)
    private String id;

    public PersistentObject() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PersistentObject)) {
            return false;
        }
        PersistentObject other = (PersistentObject) obj;
        return getId().equals(other.getId());
    }

    @Override
    public String toString() {
        return getId();
    }
    
    

}
