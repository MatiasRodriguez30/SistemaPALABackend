package com.example.SistemaPala.api.dto;

import java.time.Instant;
import java.util.List;

public record SystemInfoResponse(String applicationName, String status, List<String> activeProfiles, Instant checkedAt) {
}
