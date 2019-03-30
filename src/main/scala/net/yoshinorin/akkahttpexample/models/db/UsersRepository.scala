package net.yoshinorin.akkahttpexample.models.db

import net.yoshinorin.akkahttpexample.services.QuillProvider

trait UsersRepository {

  def insert(user: Users): Unit
  def findByName(name: String): Option[Users]

}

object UsersRepository extends UsersRepository with QuillProvider {

  import ctx._

  /**
   * Insert user
   *
   * @param user Users case class
   */
  def insert(user: Users): Unit = {
    this.findByName(user.name) match {
      case None => run(query[Users].insert(lift(user)))
      case Some(u) => println(s"${u.name} is already exists. skip create user.")
    }
  }

  /**
   * Find user by name
   *
   * @param name user name
   * @return
   */
  def findByName(name: String): Option[Users] = {
    run(query[Users].filter(u => u.name == lift(name))).headOption
  }

}
