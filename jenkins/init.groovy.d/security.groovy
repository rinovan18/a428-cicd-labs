#!/usr/bin/env groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def hudsonRealm = new HudsonPrivateSecurityRealm(true)
hudsonRealm.createAccount("admin", "admin")

instance.setSecurityRealm(hudsonRealm)

def strategy = new hudson.security.AuthorizationStrategy.Unsecured()
strategy.add(com.cloudbees.plugins.credentials.CredentialsProvider.ALL, "admin")
instance.setAuthorizationStrategy(strategy)

instance.save()
