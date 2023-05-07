package com.example.jakartasecurity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

@ApplicationScoped
public class InMemAuthentication implements IdentityStore {

    private Map<String, String> users = new HashMap<>();

    public InMemAuthentication() {
        loadDemoData();
    }

    private void loadDemoData() {
        users.put("admin", "admin");
        users.put("manager", "manager");
        users.put("user", "user");
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        if(credential instanceof UsernamePasswordCredential user){
            String key = user.getCaller();
            String password = users.get(key);
            if (password != null && password.equals(user.getPasswordAsString())){
                return new CredentialValidationResult(user.getCaller());
            }
        }
        return INVALID_RESULT;
    }

    @Override
    public int priority() {
        return 70;
    }

    @Override
    public Set<ValidationType> validationTypes() {
        return EnumSet.of(ValidationType.VALIDATE);
    }
}
