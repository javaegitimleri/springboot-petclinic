package com.javaegitimleri.petclinic.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.javaegitimleri.petclinic.dao.PetRepository;
import com.javaegitimleri.petclinic.model.Pet;

@Repository("petRepository")
public class PetRepositoryJpaImpl implements PetRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Pet findById(Long id) {
		return entityManager.find(Pet.class, id);
	}

	@Override 
	public List<Pet> findByOwnerId(Long ownerId) {
		return entityManager.createQuery("from Pet where owner.id = :ownerId", Pet.class)
				.setParameter("ownerId", ownerId).getResultList();
	}

	@Override
	public void create(Pet pet) {
		entityManager.persist(pet);
	}

	@Override
	public Pet update(Pet pet) {
		return entityManager.merge(pet);
	}

	@Override
	public void delete(Long id) {
		entityManager.remove(entityManager.getReference(Pet.class, id));
	}

	@Override
	public void deleteByOwnerId(Long ownerId) {
		entityManager.createQuery("delete from Pet where owner.id = :ownerId").setParameter("ownerId", ownerId)
				.executeUpdate();
	}
}
