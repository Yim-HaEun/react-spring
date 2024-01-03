package springChap3googleAPI.service;

import java.util.Optional;

import springChap3googleAPI.model.MemberGoogle;

public interface MemberGoogleService {
	MemberGoogle findByUsername(String username);
	void saveMember(MemberGoogle user);

}
