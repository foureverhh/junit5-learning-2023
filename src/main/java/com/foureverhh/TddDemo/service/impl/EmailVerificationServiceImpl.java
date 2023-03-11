package com.foureverhh.TddDemo.service.impl;

import com.foureverhh.TddDemo.model.User;
import com.foureverhh.TddDemo.service.EmailVerificationService;

public class EmailVerificationServiceImpl implements EmailVerificationService {
    @Override
    public void scheduledEmailConfirmation(User user) {
        // Put user Details into email
        System.out.println("method is called");
    }
}
