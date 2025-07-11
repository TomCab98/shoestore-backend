// Ubicación sugerida: core.adapters.controllers
package com.project.shoestore.core.adapters.controllers.ports;

/**
 * Interface defining CRUD operations exposed to the infrastructure controller layer.
 *
 * @param <D>  The DTO used for external communication
 * @param <ID> The type of the resource's identifier
 */
public interface ControllerAdapterPort<D, ID> {
  D create(D dto);
  D update(ID id, D dto);
  D findById(ID id);
  java.util.List<D> getAll();
  void delete(ID id);
}
