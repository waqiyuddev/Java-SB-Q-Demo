package com.q.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "api_log")
public class ApiLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String endpoint;

    @Column(name = "called_at", nullable = false)
    private LocalDateTime calledAt;

    public ApiLog() {}

    public ApiLog(String method, String endpoint) {
        this.method   = method;
        this.endpoint = endpoint;
        this.calledAt = LocalDateTime.now();
    }

    public Long getId()                { return id; }
    public String getMethod()          { return method; }
    public String getEndpoint()        { return endpoint; }
    public LocalDateTime getCalledAt() { return calledAt; }
}
