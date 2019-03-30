package net.yoshinorin.akkahttpexample.http

import scala.concurrent.{ExecutionContext, Future}
import scala.io.StdIn
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import io.circe._
import io.circe.generic.semiauto._
import io.circe.syntax._
import net.yoshinorin.akkahttpexample.models.db.Users
import net.yoshinorin.akkahttpexample.services.UsersService

object AkkaExampleThree extends App {

  implicit val actorSystem: ActorSystem = ActorSystem("akkahttpexample")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContext = actorSystem.dispatcher

  implicit val encodeUser: Encoder[Users] = deriveEncoder[Users]

  val route = get {
    pathEndOrSingleSlash {
      complete(HttpEntity(ContentTypes.`application/json`, "{\"message\": \"Hello Akka HTTP!!\"}"))
    } ~ pathPrefix("users") {
      pathPrefix(".+".r) { userName =>
        val user = UsersService.getUser(userName).asJson
        complete(HttpEntity(ContentTypes.`application/json`, s"$user"))
      }
    }
  }

  val bindingFuture: Future[Http.ServerBinding] = Http().bindAndHandle(route, "localhost", 9000)
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => actorSystem.terminate())

}
