package jp.ac.morijyobi.service.impl;

import jp.ac.morijyobi.bean.entity.User;
import jp.ac.morijyobi.bean.form.UserForm;
import jp.ac.morijyobi.constants.AccountRoleConstants;
import jp.ac.morijyobi.mapper.UsersMapper;
import jp.ac.morijyobi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UsersMapper usersMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UsersMapper usersMapper, PasswordEncoder passwordEncoder) {
        this.usersMapper = usersMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User regeisterUser(UserForm userForm) {
        User user = new User();
        user.setUsername(userForm.getUsername());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.setName(userForm.getName());
        user.setAuthorityId(AccountRoleConstants.GENERAL);

        usersMapper.insertUser(user);

        return null;
    }
}
