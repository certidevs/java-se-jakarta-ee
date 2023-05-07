package com.example.jakartasecurity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class InMemAuthorization implements IdentityStore {

    Map<String, List<String>> userRoles = new HashMap<>();

    public InMemAuthorization() {
        loadDemoData();
    }

    private void loadDemoData() {
        userRoles.put("user", List.of("USER"));
        userRoles.put("manager", List.of("USER", "MANAGER"));
        userRoles.put("admin", List.of("USER", "MANAGER", "ADMIN"));
    }


    @Override
    public Set<String> getCallerGroups(CredentialValidationResult validationResult) {
        String key = validationResult.getCallerPrincipal().getName();
        return new HashSet<>(userRoles.get(key));
    }

    @Override
    public int priority() {
        return 80;
    }

    @Override
    public Set<ValidationType> validationTypes() {
        return EnumSet.of(ValidationType.PROVIDE_GROUPS);
    }
}
