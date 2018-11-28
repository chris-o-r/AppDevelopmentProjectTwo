package ie.chris.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.chris.domain.Role;

public interface IRoleDao extends JpaRepository<Role, Integer> {

}
