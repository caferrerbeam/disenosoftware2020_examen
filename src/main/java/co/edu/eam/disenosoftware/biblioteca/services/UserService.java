package co.edu.eam.disenosoftware.biblioteca.services;

import co.edu.eam.disenosoftware.biblioteca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;
}
