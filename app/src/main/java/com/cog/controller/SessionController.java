package com.cog.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @PostMapping("/set")
    public String setSessionAttribute(HttpSession session, @RequestParam String key, @RequestParam String value) {
        session.setAttribute(key, value);
        return "Session attribute set: " + key + " = " + value;
    }

    @GetMapping("/get")
    public String getSessionAttribute(HttpSession session, @RequestParam String key) {
        Object value = session.getAttribute(key);
        return value != null ? "Session attribute: " + key + " = " + value : "No session attribute found for key: " + key;
    }

    @PostMapping("/invalidate")
    public String invalidateSession(HttpSession session) {
        session.invalidate();
        return "Session invalidated.";
    }
}

