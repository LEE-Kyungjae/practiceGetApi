package com.lkj.getapi.util;

import com.lkj.getapi.domain.User;
import com.lkj.getapi.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SessionUtil {

    private final UserRepository userRepository;

    public Optional<User> getUser(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null) {
            return userRepository.findById(userId);
        }
        return Optional.empty();
    }

    public void setUser(HttpSession session, User user) {
        session.setAttribute("userId", user.getId());
    }

    public void invalidateSession(HttpSession session) {
        session.invalidate();
    }
}
