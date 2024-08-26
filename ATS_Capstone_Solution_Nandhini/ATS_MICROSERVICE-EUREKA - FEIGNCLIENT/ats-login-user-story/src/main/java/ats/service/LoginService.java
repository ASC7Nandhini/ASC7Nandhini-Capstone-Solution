package ats.service;

import ats.model.BookingModel;
import ats.model.LoginDetailsModel;

import java.util.List;

public interface LoginService {
    List<BookingModel> login(LoginDetailsModel loginDetailsModel);
    List<LoginDetailsModel> getAllLoginDetails();
    LoginDetailsModel getLoginDetailsById(Long id);
}
