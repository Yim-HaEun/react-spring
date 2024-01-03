package springChap3googleAPI.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import springChap3googleAPI.model.MemberGoogle;
public interface MemberGoogleRepository extends JpaRepository <MemberGoogle, Long>{
	MemberGoogle findByUsername(String username);
}








