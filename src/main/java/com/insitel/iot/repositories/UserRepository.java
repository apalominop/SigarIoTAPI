/**
 * 
 */
package com.insitel.iot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insitel.iot.models.User;

/**
 * @author Agustín Palomino Pardo
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	/**
	 * Query para verificar nombre y password de User
	 * @param nombre
	 * @param pass
	 * @return
	 */
	//@Query("select u from User u where u.nombre = ?1 and u.password = ?2")
	@Query(value = "select * from iot_user_login where usrl_name = ?1 and usrl_password = ?2", 
			nativeQuery = true)
	public Optional<User> verificarUser(String nombre, String pass);
	
}
