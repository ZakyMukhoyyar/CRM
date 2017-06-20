package com.agit.crm.shared.object;

import java.io.Serializable;

/**
 * An entity, as explained in the DDD model
 *  
 */
public interface EntityObject<T> extends Serializable {

  boolean sameIdentityAs(T other);

}
