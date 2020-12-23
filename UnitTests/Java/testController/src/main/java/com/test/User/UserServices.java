package com.test.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServices {
    public static final int USERS_PER_PAGE = 5;

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll(){
        return userRepository.findAll(Sort.by("email").ascending());
    }

//    public Page<User> listAll(int pageNum, String sortField, String sortDir, String keyword) {
//        Sort sort = Sort.by(sortField);
//        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
//
//        Pageable pageable = PageRequest.of(pageNum - 1, USERS_PER_PAGE, sort);
//
//        if (keyword != null) {
//            return userRepository.findAll(keyword, pageable);
//        }
//    }

    public boolean isUniqueEmailViolated(Integer id, String email) {
        boolean isUniqueViolated = false;

        User userByEmail = userRepository.findByEmail(email);
        boolean isCreatingNew = (id == null || id == 0);

        if(isCreatingNew){
            if(userByEmail != null) isUniqueViolated = true;
        }else {
            if(userByEmail.getId() != id){
                isUniqueViolated = true;
            }
        }

        return isUniqueViolated;

    }

}
