package com.javaegitimleri.petclinic.dao;

import java.util.Collections;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.javaegitimleri.petclinic.model.Owner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class OwnerRepositoryJdbcImplTests {
	@Autowired
	@Qualifier("ownerRepositoryJdbcImpl")
	private OwnerRepository ownerRepository;

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Test
	public void testCreateOwner() {
		Owner o = new Owner();
		o.setFirstName("AAA");
		o.setLastName("BBB");

		ownerRepository.create(o);

		Integer count = jdbcTemplate.queryForObject("select count(*) from t_owner where id = :id",
				Collections.singletonMap("id", o.getId()), Integer.class);
		
		MatcherAssert.assertThat(count, Matchers.equalTo(1));
	}
	
	@Test
	public void testUpdateOwner() {
		Owner o = ownerRepository.findById(1L);
		o.setFirstName("XXX");
		o.setLastName("YYY");
		
		ownerRepository.update(o);
		
		Owner o2 = ownerRepository.findById(1L);
		
		MatcherAssert.assertThat(o2.getFirstName(), Matchers.equalTo("XXX"));
		MatcherAssert.assertThat(o2.getLastName(), Matchers.equalTo("YYY"));
	}
}
