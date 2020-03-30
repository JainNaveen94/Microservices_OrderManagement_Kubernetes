package com.nagarro.microservices.service.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nagarro.microservices.constant.AggregatorConstant;
import com.nagarro.microservices.exception.custom.UserNotFoundException;
import com.nagarro.microservices.model.User;

@Component
public class UserServiceProxyImpl {
	
	@Value("${app.userServiceUrl}")
	private String userServiceUrl;

	public User getUser(long userId) {

		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<User> rateResponse = restTemplate.exchange(userServiceUrl + "user/" +userId,
					HttpMethod.GET, null, new ParameterizedTypeReference<User>() {
					});
			return rateResponse.getBody();
		} catch (Exception exception) {
			throw new UserNotFoundException(AggregatorConstant.USER_NOT_FOUND + userId);
		}
	}

}
