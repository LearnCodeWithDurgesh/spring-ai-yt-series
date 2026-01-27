package com.mcp.app.config;

public record Post(
        Integer userId,
        Integer id,
        String title,
        String body
) {
}
