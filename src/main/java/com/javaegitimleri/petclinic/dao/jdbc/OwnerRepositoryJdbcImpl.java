package com.javaegitimleri.petclinic.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.javaegitimleri.petclinic.dao.OwnerRepository;
import com.javaegitimleri.petclinic.model.Owner;

@Repository
public class OwnerRepositoryJdbcImpl implements OwnerRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<Owner> rowMapper = new RowMapper<Owner>() {

		@Override
		public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
			Owner owner = new Owner();
			owner.setId(rs.getLong("id"));
			owner.setFirstName(rs.getString("first_name"));
			owner.setLastName(rs.getString("last_name"));
			return owner;
		}
	};

	@Override
	public List<Owner> findAll() {
		String sql = "select id,first_name,last_name from t_owner";
		
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Owner findById(Long id) {
		String sql = "select id,first_name,last_name from t_owner where id = ?";
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		String sql = "select id,first_name,last_name from t_owner where last_name like ?";
		return jdbcTemplate.query(sql, rowMapper, "%" + lastName + "%");
	}

	@Override
	public void create(Owner owner) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con.prepareStatement(
						"insert into t_owner(id,first_name,last_name) "
						+ " values(petclinic_sequence.nextval,?,?)");
				stmt.setString(1,owner.getFirstName());
				stmt.setString(2, owner.getLastName());
				return stmt;
			}
		};
		int count = jdbcTemplate.update(psc, keyHolder);
		if(count != 1) {
			throw new RuntimeException("Unable to create owner :" + owner);
		}
		owner.setId((Long) keyHolder.getKey());
	}

	@Override
	public Owner update(Owner owner) {
		int count = jdbcTemplate.update("update t_owner "
				+ "set first_name = ?, last_name = ? "
				+ "where id = ?",owner.getFirstName(),owner.getLastName(),owner.getId());
		if(count != 1) {
			throw new RuntimeException("Unable to update owner :" + owner);
		}
		return owner;
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from t_owner where id = ?";
		jdbcTemplate.update(sql,id);
	}

}
