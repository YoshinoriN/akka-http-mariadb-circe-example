package net.yoshinorin.akkahttpexample.services

import net.yoshinorin.akkahttpexample.models.db.{Users, UsersRepository}

object UsersService {

  /**
   * Get user
   *
   * @param userName user name
   * @return
   */
  def getUser(userName: String): Option[Users] = {
    UsersRepository.findByName(userName)
  }

}
