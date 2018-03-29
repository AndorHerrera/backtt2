/**
 *
 * @author Jesús Israel
 */

package com.klasnic.pos.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.klasnic.pos.model.data.PersistentObject;

@NoRepositoryBean
public interface PersistentRepository<T extends PersistentObject>
        extends JpaRepository<T, String> {
    
}
