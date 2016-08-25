package repository;

import java.util.List;

import my.dto.UserDTO;
import my.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.wsights.trawind.logistics.model.PerInformation;
import com.wsights.trawind.logistics.model.TraElebookRegistration;

public interface UserRepository extends JpaRepository<User,String> , QueryDslPredicateExecutor<User>{
	//寰�暟鎹簱涓繚瀛樼敤鎴�
	User saveAndFlush(User entity);
	//閫氳繃鐢ㄦ埛鍚嶆煡璇紝濡傛灉瀛樺湪杩斿洖涓�釜List闆嗗悎
	List<User> findByUsernameAndPassword(String username,String password);
}
