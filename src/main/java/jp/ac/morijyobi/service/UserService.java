package jp.ac.morijyobi.service;

import jp.ac.morijyobi.bean.entity.User;
import jp.ac.morijyobi.bean.form.UserForm;

public interface UserService {

    User regeisterUser(UserForm userForm);
}
