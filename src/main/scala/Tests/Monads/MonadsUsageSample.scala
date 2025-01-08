package Tests.Monads

import scala.util.{Success, Failure, Try}

case class Contact(id: Int, name: String, phone: Option[String], email: Option[String], friendIds: List[Int])

object MonadsUsageSample {
	def Run(): Unit = {

		val friendIds : List[Int] = List(1, 2, 3, 4, 5)

		val successes = friendIds.flatMap { id =>
			dbLookup(id) match {
				case Failure(exception) => None
				case Success(friend) => friend.email match {
					case None => None
					case Some(email) => if (sendEmail(email)) Some(id) else None
				}
			}
		}

		println(successes)
	}

	def dbLookup(id: Int): Try[Contact] = {
		Success(Contact(id, "Name", None, Some("email"), List(1, 2, 3, 4, 5)))
	}

	def sendEmail(email: String): Boolean = true;
}
