package springChap3googleAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springChap3googleAPI.model.UserSNS;

public interface UserRepository extends JpaRepository <UserSNS, Long>{

}
