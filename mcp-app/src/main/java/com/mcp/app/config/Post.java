package com.mcp.app;

public record Post(
        Integer userId,
        Integer id,
        String title,
        String body
) {
}
