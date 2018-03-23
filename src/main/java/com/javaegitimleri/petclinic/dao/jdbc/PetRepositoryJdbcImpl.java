package com.javaegitimleri.petclinic.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javaegitimleri.petclinic.dao.PetRepository;
import com.javaegitimleri.petclinic.model.Pet;

@Repository
public class PetRepositoryJdbcImpl implements PetRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> findByOwnerId(Long ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet update(Pet pet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByOwnerId(Long ownerId) {
		String sql = "delete from t_pet where owner_id = ?";
		jdbcTemplate.update(sql,ownerId);
	}

}
