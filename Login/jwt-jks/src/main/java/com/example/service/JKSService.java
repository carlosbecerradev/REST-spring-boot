package com.example.service;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class JKSService {

	private KeyStore keyStore;

	@PostConstruct
	public void init() {
		try {
			keyStore = KeyStore.getInstance("JKS");
			InputStream resourceAsStream = getClass().getResourceAsStream("/someJKS.jks");
			keyStore.load(resourceAsStream, "secret".toCharArray());
		} catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
			throw new RuntimeException("Exception ocurred while loading keystore");
		}
	}

	public PrivateKey getPrivateKey() {
		try {
			return (PrivateKey) keyStore.getKey("someJKS", "secret".toCharArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
			throw new RuntimeException("Exception ocurred while retrieving public key from keystore");
		}
	}

	public PublicKey getPublicKey() {
		try {
			return keyStore.getCertificate("someJKS").getPublicKey();
		} catch (KeyStoreException e) {
			throw new RuntimeException("Exception ocurred while retrieving public key from keystore");
		}
	}
}
