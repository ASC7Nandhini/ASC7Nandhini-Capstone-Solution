package ats.service;

import ats.model.LoginDetailsModel;

import java.util.List;

public interface LoginService {
    String login(LoginDetailsModel loginDetailsModel);
    List<LoginDetailsModel> getAllLoginDetails();
    LoginDetailsModel getLoginDetailsById(Long id);
}
