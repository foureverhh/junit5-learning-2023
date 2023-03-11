package com.foureverhh.TddDemo.service;

import com.foureverhh.TddDemo.model.User;

public interface EmailVerificationService  {
    void scheduledEmailConfirmation(User user);
}
